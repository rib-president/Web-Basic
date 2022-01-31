package com.lotto.shinnanda.admin.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotto.shinnanda.admin.mapper.AdminSQLMapper;
import com.lotto.shinnanda.vo.Brand_CategoryVo;
import com.lotto.shinnanda.vo.ImageVo;
import com.lotto.shinnanda.vo.OrdersVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_CategoryVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@Service
public class AdminService {
	@Autowired
	private AdminSQLMapper adminSQLMapper;
	
	public ArrayList<Product_CategoryVo> getProductCategory() {
		return adminSQLMapper.selectProductCategory();
	}
	
	public ArrayList<Brand_CategoryVo> getBrandCategory() {
		return adminSQLMapper.selectBrandCategory();
	}
	
	public void uploadProduct(ProductVo productVo, String[] options, int[] stocks, ArrayList<ImageVo> imageVoList) {
		int product_no = adminSQLMapper.createProductNo();
		
		productVo.setProduct_no(product_no);
		adminSQLMapper.insertProduct(productVo);
		
		for(int i=0;i<options.length;i++) {
			Product_DetailVo product_detailVo = new Product_DetailVo();
			product_detailVo.setProduct_no(product_no);
			product_detailVo.setProduct_detail_option(options[i]);
			product_detailVo.setProduct_detail_stock(stocks[i]);
			
			adminSQLMapper.insertProductDetail(product_detailVo);
		}
		
		for(ImageVo imageVo : imageVoList) {
			imageVo.setProduct_no(product_no);
			adminSQLMapper.insertProductImage(imageVo);
		}
	}
	
	public ArrayList<ProductVo> getProduct() {
		return adminSQLMapper.selectProduct();
	}
	
	public Integer getSumOrdersDetailCountByProductDetailNo(int product_detail_no) {
		return adminSQLMapper.selectSumOrdersDetailCountByProductDetailNo(product_detail_no);
	}
	
	public ArrayList<OrdersVo> getOrders() {
		return adminSQLMapper.selectOrders();
	}
}
