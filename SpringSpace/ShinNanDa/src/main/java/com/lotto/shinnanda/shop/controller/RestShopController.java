package com.lotto.shinnanda.shop.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lotto.shinnanda.admin.service.AdminService;
import com.lotto.shinnanda.commons.KakaoRestAPI;
import com.lotto.shinnanda.shop.service.ShopService;
import com.lotto.shinnanda.vo.CartVo;
import com.lotto.shinnanda.vo.KakaopayVo;
import com.lotto.shinnanda.vo.MemberVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@RestController
@RequestMapping("/shop/*")
public class RestShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("load16Product")
	public HashMap<String, Object> load16Product(int pageNum) {
		HashMap<String, Object> data = new HashMap<>();
		
		ArrayList<ProductVo> voList = shopService.getMainPage16Product(pageNum);
		 
		data.put("voList", voList);
		
		return data;
	}
	
	@RequestMapping("detailProductPage")
	public HashMap<String, Object> detailProductPage(int product_no) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		ArrayList<Product_DetailVo> detailVoList = shopService.getProductDetailByProductNo(product_no);
		
		ArrayList<HashMap<String, Object>> productDetailVoList = new ArrayList<>();
		for(Product_DetailVo detailVo : detailVoList) {
			HashMap<String, Object> map = new HashMap<>();
			
			int product_detail_no = detailVo.getProduct_detail_no();

			Integer orderCount = adminService.getSumOrdersDetailCountByProductDetailNo(product_detail_no);
			if(orderCount == null) orderCount = 0; 
			int stock = detailVo.getProduct_detail_stock() - orderCount;
			
			map.put("detailVo", detailVo);
			map.put("stock", stock);
			
			productDetailVoList.add(map);
		}
					
		data.put("productVo", shopService.getProduct(product_no));
		data.put("productDetailVoList", productDetailVoList);
		data.put("productImageVoList", shopService.getProductImageByProductVo(product_no));
		data.put("AgeCntList", shopService.getOrdersProductAgeCnt(product_no));
		
		return data;
	}	
	
	@RequestMapping("addCartProcess")
	public HashMap<String, Object> addCartProcess(@RequestBody Map<String, ArrayList<Integer>> params, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<>();

        ArrayList<Integer> product_detail_no = params.get("product_detail_no");
        	
        ArrayList<Integer> productCount = params.get("productCount");

		int member_no = ((MemberVo) session.getAttribute("sessionUser")).getMember_no();
		
		for(int i=0;i<product_detail_no.size();i++) {
			CartVo vo = new CartVo();
			vo.setProduct_detail_no(product_detail_no.get(i));
			vo.setMember_no(member_no);
			vo.setCart_count(productCount.get(i));
			
			shopService.addCart(vo);
		}
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("getCartInfoProcess")
	public HashMap<String, Object> getCartInfoProcess(HttpSession session, Model model) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();
		ArrayList<CartVo> cartVoList = shopService.getCartByMemberNo(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
		
		for(CartVo cartVo : cartVoList) {
			HashMap<String, Object> map = new HashMap<>();
			
			int product_detail_no = cartVo.getProduct_detail_no();
			Product_DetailVo product_DetailVo = shopService.getProductDetailByNo(product_detail_no);

			Integer orderCount = adminService.getSumOrdersDetailCountByProductDetailNo(product_detail_no);
			if(orderCount == null) orderCount = 0; 
			int stock = product_DetailVo.getProduct_detail_stock() - orderCount;
			
			int product_no = product_DetailVo.getProduct_no();
			ProductVo productVo = shopService.getProduct(product_no);
			
			map.put("productVo", productVo);
			map.put("product_DetailVo", product_DetailVo);
			map.put("stock", stock);
			map.put("cartVo", cartVo);
			
			totalVoList.add(map);
		}
		
		data.put("totalVoList", totalVoList);
		
		return data;
	}	
	
	@RequestMapping("changeCartCount")
	public HashMap<String, Object> changeCartCount(CartVo vo) {
		
		HashMap<String, Object> data = new HashMap<>();
		shopService.modifyCartCount(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("delCheckedCartProcess")
	public HashMap<String, Object> delCheckedCartProcess(String[] checked_cart_no_list) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		for(String cart_no : checked_cart_no_list) {		
			shopService.delCartByNo(Integer.parseInt(cart_no));
		}
		
		data.put("result", "success");

		return data;
	}
	
	@RequestMapping("delCartProcess")
	public HashMap<String, Object> delCartProcess(HttpSession session) {
		HashMap<String, Object> data = new HashMap<>();
		
		shopService.delCartByMemberNo(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("getOrderInfo")
	public String orderPage(int[] product_detail_no, int[] productCount, 
			@RequestParam(value = "isCartAll", defaultValue = "false") boolean isCartAll, 
			Model model, HttpSession session) {

		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();

		if(isCartAll) {
			ArrayList<CartVo> cartVoList = shopService.getCartByMemberNo(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
			int length = cartVoList.size();
			product_detail_no = new int[length];
			productCount = new int[length];
			
			for(int i=0;i<length;i++) {
				product_detail_no[i] = cartVoList.get(i).getProduct_detail_no();
				productCount[i] = cartVoList.get(i).getCart_count();
			}
		}
		
		for(int i=0;i<product_detail_no.length;i++) {
			HashMap<String, Object> map = new HashMap<>();

			Product_DetailVo product_DetailVo = shopService.getProductDetailByNo(product_detail_no[i]);
			
			int product_no = product_DetailVo.getProduct_no();
			ProductVo productVo = shopService.getProduct(product_no);
			
			map.put("productVo", productVo);
			map.put("product_DetailVo", product_DetailVo);
			map.put("productCount", productCount[i]);
			
			totalVoList.add(map);
		}
		
		model.addAttribute("totalVoList", totalVoList);
		
		return "shop/orderPage";
	}	
	
	@RequestMapping("payToKakao")
	public HashMap<String, Object> payToKakao(String item_name, String quantity, int total_amount, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		KakaoRestAPI kakao = new KakaoRestAPI();
		String partner_order_id = UUID.randomUUID().toString();
		String partner_user_id = ((MemberVo) session.getAttribute("sessionUser")).getMember_id();
		
		Map<String, String> result = kakao.payReady(partner_order_id, partner_user_id, item_name, quantity, String.valueOf(total_amount));				
				
		KakaopayVo vo = new KakaopayVo();
		
		vo.setTid(result.get("tid"));
		vo.setPartner_order_id(partner_order_id);
		vo.setTotal_amount(total_amount);		

		session.setAttribute("kakaopayVo", vo);

		data.put("next_redirect_pc_url", result.get("next_redirect_pc_url"));
		data.put("tid", result.get("tid"));
		
		return data;
	}
	
	@RequestMapping("getResponseCode")
	public HashMap<String, Object> getResponseCode(HttpSession session) {

		HashMap<String, Object> data = new HashMap<>();
		
		data.put("response_code", session.getAttribute("response_code"));
		data.put("tid", session.getAttribute("tid"));

		session.removeAttribute("response_code");
		session.removeAttribute("tid");
		
		return data;
	}
		
}
