package com.ja.finalproject.commons;

import java.security.MessageDigest;

public class MessageDigestUtil {
	public static String getPasswordHashCode(String password) {
		
		// salt : 암호 뒤에 임의의 값을 붙임
		password = password + "아무값이나 붙여";
		
		String hashCode = null;
		
		// password를 암호화 한다
		try {
			
			MessageDigest messageDigest = 
					MessageDigest.getInstance("SHA-1");	// 160bit로 암호화
			messageDigest.reset();
			
			// 파라미터로 byte 타입 받음 -> 문자 뿐만아니라 파일도 암호화 가능
			messageDigest.update(password.getBytes("UTF-8"));
			
			// 160bit 해시 값 생성(chars.length는 20)
			byte[] chars = messageDigest.digest();
			
			// 모양 예쁘게 만들기(한 자릿수면 앞에 0 붙이기)
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<chars.length;i++) {
				// int 값을 넣으면 문자를 return
				String tmp = Integer.toHexString(chars[i] & 0xff);
				
				if(tmp.length() == 1) {
					sb.append("0");
				}
				
				sb.append(tmp);
			}
			hashCode = sb.toString();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return hashCode;
	}
}
