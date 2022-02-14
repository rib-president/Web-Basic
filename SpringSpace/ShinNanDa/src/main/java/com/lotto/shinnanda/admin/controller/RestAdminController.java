package com.lotto.shinnanda.admin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lotto.shinnanda.admin.service.AdminService;
import com.lotto.shinnanda.shop.service.ShopService;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@RestController
@RequestMapping("/admin/*")
public class RestAdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("getProductInfo")
	public HashMap<String, Object> getProductInfo() {
		
		HashMap<String, Object> data = new HashMap<>();

		ArrayList<ProductVo> productVoList = adminService.getProduct();		
				
		data.put("productVoList", productVoList);	
		
		return data;
	}
	
	@RequestMapping("getProductDetailInfo")
	public HashMap<String, Object> getProductDetailInfo(int product_no) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		ArrayList<Product_DetailVo> product_DetailVoList = shopService.getProductDetailByProductNo(product_no);
		
		data.put("product_DetailVoList", product_DetailVoList);
		
		return data;
	}
	
	@RequestMapping("getStock")
	public HashMap<String, Object> getStock(int product_detail_no) {		
		HashMap<String, Object> data = new HashMap<>();
		
		Integer numOfSales = adminService.getSumOrdersDetailCountByProductDetailNo(product_detail_no);
		
		if(numOfSales == null) numOfSales = 0;
		
		data.put("stock", shopService.getProductDetailByNo(product_detail_no).getProduct_detail_stock() - numOfSales);
		
		return data;
	}
	
	@RequestMapping("restockProcess")
	public HashMap<String, Object> restockProcess(@RequestBody Map<String, ArrayList<Product_DetailVo>> params) {
		HashMap<String, Object> data = new HashMap<>();
		
		ArrayList<Product_DetailVo> voList = params.get("voList");
		
		for(Product_DetailVo vo : voList) {

			adminService.restock(vo);
		}
		
		data.put("result", "success");
		
		return data;
	}
}
