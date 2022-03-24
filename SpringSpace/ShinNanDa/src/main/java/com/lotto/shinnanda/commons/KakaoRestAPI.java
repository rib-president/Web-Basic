package com.lotto.shinnanda.commons;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotto.shinnanda.vo.KakaopayVo;
import com.lotto.shinnanda.vo.MemberVo;

public class KakaoRestAPI {
	public enum HttpMethodType { POST, GET, DELETE }
	
	private static final String API_SERVER_HOST  = "https://kapi.kakao.com";
	private static final String API_SERVER_KAUTH_HOST = "https://kauth.kakao.com";
	
	private static final String PAY_READY_PATH = "/v1/payment/ready";
	private static final String PAY_APPROVE_PATH = "/v1/payment/approve";
	private static final String PAY_INFO_PATH = "/v1/payment/order";
	
	private static final String LOGIN_GET_CODE = "/oauth/authorize";
	private static final String LOGIN_GET_TOKEN = "/oauth/token";
	
	private static final ObjectMapper JACKSON_OBJECT_MAPPER = new ObjectMapper();
	private static final String PROPERTIES_PARAM_NAME = "properties";	
    
	private final String domain = "http://localhost:8181/shinnanda/";
    private final String adminKey = "ddd605113bdf2abb7b86fb6f1d3f804b";
    private final String cid = "TC0ONETIME";
    

    // kakao pay   
    public Map<String, String> payReady(String partner_order_id, String partner_user_id,
    		String item_name, String quantity, String total_amount) {
    	
    	String approval_url = this.domain + "shop/kakaoPayApproval";
    	String cancel_url = this.domain + "shop/kakaoPayCancel";
    	String fail_url = this.domain + "shop/kakaoPayFail";
    	
    	Map<String, String> params = new HashMap<>();
    	
    	params.put("cid", this.cid);
    	params.put("partner_order_id", partner_order_id);
    	params.put("partner_user_id", partner_user_id);
    	params.put("item_name", item_name);
    	params.put("quantity", quantity);
    	params.put("total_amount", total_amount);
    	params.put("tax_free_amount", "0");
    	params.put("approval_url", approval_url);
    	params.put("cancel_url", cancel_url);
    	params.put("fail_url", fail_url);
    	
    	String sendParams = mapToParams(params);    			
    	
    	String requestUrl = API_SERVER_HOST + PAY_READY_PATH;
    	
    	return Request(HttpMethodType.POST, sendParams, requestUrl);
    }
    
    public Map<String, String> payApprove(String pg_token, KakaopayVo vo, HttpSession session) {
    	
    	String requestUrl = API_SERVER_HOST + PAY_APPROVE_PATH;
    	
    	Map<String, String> params = new HashMap<>();
    	
    	params.put("cid", this.cid);
    	params.put("tid", vo.getTid());
    	params.put("partner_order_id", vo.getPartner_order_id());
    	params.put("partner_user_id", ((MemberVo) session.getAttribute("sessionUser")).getMember_id());
    	params.put("pg_token", pg_token);
    	
    	String sendParams = mapToParams(params);
    	
    	return Request(HttpMethodType.POST, sendParams, requestUrl);
    }
    
    public Map<String, String> payInfo(String tid) {
    	
    	String requestUrl = API_SERVER_HOST + PAY_INFO_PATH;
    	
    	Map<String, String> params = new HashMap<>();
    	
    	params.put("cid", this.cid);
    	params.put("tid", tid);
    	
    	String sendParams = mapToParams(params);
    	
    	return Request(HttpMethodType.POST, sendParams, requestUrl);
    }
    
    // kakao login
//    public Map<String, String> loginGetCode() {
//    	
//    	String requestUrl = API_SERVER_KAUTH_HOST + LOGIN_GET_CODE;    	
//    	
//    	String sendParams = "?client_id=" + this.adminKey + "&redirect_uri=" + 
//    			this.domain + "member/loginGetCode&response_type=code";
//    	
//    	return Request(HttpMethodType.GET, sendParams, requestUrl);
//    }
    
    public Map<String, String> loginGetToken(String code) {
    	String requestUrl = API_SERVER_KAUTH_HOST + LOGIN_GET_TOKEN;
    	
    	Map<String, String> params = new HashMap<>();
    	
    	params.put("grant_type", "authorization_code");
    	params.put("client_id", this.adminKey);
    	params.put("redirect_uri", "http://localhost:8181/shinnanda/member/loginGetCode");
    	params.put("code", code);
    	
    	String sendParams = mapToParams(params);
    	
    	return Request(HttpMethodType.POST, sendParams, requestUrl);
    }
    
    
    public Map<String, String> Request(HttpMethodType httpMethod, String sendParams, String requestUrl) {
    	
    	if(sendParams != null && sendParams.length() > 0 &&	httpMethod == HttpMethodType.GET) {
    		requestUrl += sendParams;
    	}
    	
    	HttpsURLConnection conn;
    	OutputStreamWriter writer = null;
        BufferedReader reader = null;
        InputStreamReader isr = null;
        
        try {
        	final URL url = new URL(requestUrl);
        	conn = (HttpsURLConnection) url.openConnection();
        	conn.setRequestMethod(httpMethod.toString());
        	
        	conn.setRequestProperty("Authorization", "KakaoAK " + this.adminKey);
        	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        	conn.setRequestProperty("charset", "utf-8");
        	
        	if(sendParams != null && sendParams.length() > 0 &&
        			httpMethod == HttpMethodType.POST) {
	        	conn.setDoOutput(true);
	        	writer = new OutputStreamWriter(conn.getOutputStream());
	        	writer.write(sendParams);
	        	writer.flush();
        	}
        	
        	final int responseCode = conn.getResponseCode();
        	System.out.println(String.format("\nSending '%s' request to URL : %s", httpMethod, requestUrl));
        	System.out.println("Response Code : " + responseCode);
        	
        	if(responseCode == 200) {
        		isr = new InputStreamReader(conn.getInputStream());
        	} else {
        		isr = new InputStreamReader(conn.getErrorStream());
        	}
        	
        	reader = new BufferedReader(isr);
        	final StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            System.out.println(buffer.toString());
            
            Map<String, String> result = new HashMap<>();;
            
            if(httpMethod == HttpMethodType.GET) {
            	result.put("result", buffer.toString());
            	return result;
            }
            
            result = stringToMap(buffer.toString());
            result.put("response_code", String.valueOf(responseCode));
        	            
            return result;
        	
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
            if (writer != null) try { writer.close(); } catch (Exception ignore) { }
            if (reader != null) try { reader.close(); } catch (Exception ignore) { }
            if (isr != null) try { isr.close(); } catch (Exception ignore) { }
        }

        return null;
    }
    
    public String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }    
    
    public String mapToParams(Map<String, String > map) {
        StringBuilder paramBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            paramBuilder.append(paramBuilder.length() > 0 ? "&" : "");
            paramBuilder.append(String.format("%s=%s", urlEncodeUTF8(key),
                    urlEncodeUTF8(map.get(key).toString())));
        }
        return paramBuilder.toString();
    }
    
    public Map<String, String> stringToMap(String s) {
    	Map<String, String> map = new HashMap<>();
    	
		ObjectMapper mapper = new ObjectMapper();

	    try{
	        map = mapper.readValue(s, Map.class);

	    } catch (IOException e){
	        e.printStackTrace();
	    }
	    
	    return map;
    }
}
