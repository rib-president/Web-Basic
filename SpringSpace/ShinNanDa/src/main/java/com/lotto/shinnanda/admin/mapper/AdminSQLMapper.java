package com.lotto.shinnanda.admin.mapper;

import java.util.*;

import com.lotto.shinnanda.vo.Brand_CategoryVo;
import com.lotto.shinnanda.vo.ImageVo;
import com.lotto.shinnanda.vo.OrdersVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_CategoryVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

public interface AdminSQLMapper {
	public int createProductNo();
	public void insertProduct(ProductVo vo);
	public void insertProductDetail(Product_DetailVo vo);
	public void insertProductImage(ImageVo vo);
	public void updateProductDetailStock(Product_DetailVo vo);
	public ArrayList<Product_CategoryVo> selectProductCategory();
	public ArrayList<Brand_CategoryVo> selectBrandCategory();
	public ArrayList<ProductVo> selectLatest16Product();
	public ArrayList<ProductVo> selectProduct();
	public Integer selectSumOrdersDetailCountByProductDetailNo(int product_detail_no);
	public ArrayList<OrdersVo> selectOrders();
}
