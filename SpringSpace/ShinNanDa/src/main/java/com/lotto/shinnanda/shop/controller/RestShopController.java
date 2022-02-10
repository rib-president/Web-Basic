package com.lotto.shinnanda.shop.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lotto.shinnanda.admin.service.AdminService;
import com.lotto.shinnanda.shop.service.ShopService;
import com.lotto.shinnanda.vo.CartVo;
import com.lotto.shinnanda.vo.MemberVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@RestController
@RequestMapping("/shop/*")
public class RestShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private AdminService adminService;
	
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
}
