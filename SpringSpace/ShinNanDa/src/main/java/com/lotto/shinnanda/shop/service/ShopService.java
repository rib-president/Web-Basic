package com.lotto.shinnanda.shop.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotto.shinnanda.shop.mapper.ShopSQLMapper;
import com.lotto.shinnanda.vo.CartVo;
import com.lotto.shinnanda.vo.ImageVo;
import com.lotto.shinnanda.vo.KakaopayVo;
import com.lotto.shinnanda.vo.OrdersVo;
import com.lotto.shinnanda.vo.Orders_DetailVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_CategoryVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@Service
public class ShopService {
	@Autowired
	private ShopSQLMapper shopSQLMapper;
	
//	public ArrayList<ProductVo> getMainPage16Product() {
//		return shopSQLMapper.selectLatest16Product();
//	}
	
	public ArrayList<ProductVo> getMainPage16Product(int pageNum) {
		return shopSQLMapper.selectLatest16Product(pageNum);
	}
	
	public int getProductCount() {
		return shopSQLMapper.selectProductCnt();
	}
	
	public ArrayList<ProductVo> getProductByCategoryNoBrandNo(int product_category_no, int brand_no) {
		return shopSQLMapper.selectProductByCategoryNoBrandNo(product_category_no, brand_no);
	}
	
	public Product_CategoryVo getProductCategoryByNo(int no) {
		return shopSQLMapper.selectProductCategoryByNo(no);
	}
	
	public ArrayList<HashMap<String, Object>> getBrandCategoryCount(int product_category_no) {
		return shopSQLMapper.selectBrandCategoryCount(product_category_no);
	}
	
	public ProductVo getProduct(int no) {
		return shopSQLMapper.selectProductByNo(no);
	}
	
	public ArrayList<Product_DetailVo> getProductDetailByProductNo(int product_no) {
		return shopSQLMapper.selectProductDetailByProductNo(product_no);
	}
	
	public Product_DetailVo getProductDetailByNo(int no) {
		return shopSQLMapper.selectProductDetailByNo(no);
	}
	
	public ArrayList<ImageVo> getProductImageByProductVo(int product_no) {
		return shopSQLMapper.selectProductImageByProductNo(product_no);
	}
	
	public ArrayList<HashMap<String, Integer>> getOrdersProductAgeCnt(int product_no) {
		return shopSQLMapper.selectOrdersProductAgeCnt(product_no);
	}
	
	public void addCart(CartVo vo) {
		shopSQLMapper.insertCart(vo);
	}
	
	public ArrayList<CartVo> getCartByMemberNo(int member_no) {
		return shopSQLMapper.selectCartByMemberNo(member_no);
	}
	
	public CartVo getCartByNo(int no) {
		return shopSQLMapper.selectCartByNo(no);
	}
	
	public void modifyCartCount(CartVo vo) {
		shopSQLMapper.updateCartCount(vo);
	}
	
	public void delCartByNo(int no) {
		shopSQLMapper.deleteCartByNo(no);
	}
	
	public void delCartByMemberNo(int member_no) {
		shopSQLMapper.deleteCartByMemberNo(member_no);
	}
	
	public int registOrders(OrdersVo ordersVo, int[] product_detail_no, int[] productCount, ArrayList<CartVo> cartVoList) {
				
		int orders_no = shopSQLMapper.createOrdersNo();
		
		ordersVo.setOrders_no(orders_no);
		shopSQLMapper.insertOrders(ordersVo);
		
		for(int i=0;i<product_detail_no.length;i++) {
			Orders_DetailVo orders_DetailVo = new Orders_DetailVo();
			
			orders_DetailVo.setOrders_no(orders_no);
			orders_DetailVo.setProduct_detail_no(product_detail_no[i]);
			orders_DetailVo.setOrders_detail_count(productCount[i]);
			
			shopSQLMapper.insertOrdersDetail(orders_DetailVo);
		}
		
		for(CartVo cartVo : cartVoList) {
			int target = cartVo.getProduct_detail_no();
			if(Arrays.stream(product_detail_no).anyMatch(a -> a == target)) {
				shopSQLMapper.deleteCartByNo(cartVo.getCart_no());
			}
		}
		
		return orders_no;
	}
	
	public OrdersVo getOrdersByNo(int no) {
		return shopSQLMapper.selectOrdersByNo(no);
	}
	
	public ArrayList<OrdersVo> getOrdersByMemberNo(int member_no, String searchState) {
		return shopSQLMapper.selectOrdersByMemberNo(member_no, searchState);
	}
	
	public ArrayList<HashMap<String, Object>> getOrdersStateCount(int member_no) {
		return shopSQLMapper.selectOrdersStateCount(member_no);
	}
	
	public ArrayList<Orders_DetailVo> getOrdersDetailByOrdersNo(int orders_no) {
		return shopSQLMapper.selectOrdersDetailByOrdersNo(orders_no);
	}
	
	public void modifyOrdersState(OrdersVo vo) {
		shopSQLMapper.updateOrdersState(vo);
	}
	
	public int createKakaopayNo() {
		return shopSQLMapper.createKakopayNo();
	}
	
	public void registKakaopay(KakaopayVo vo) {
		shopSQLMapper.insertKakaopay(vo);
	}
	
	public void modifyKakaopayOrdersNo(KakaopayVo vo) {
		shopSQLMapper.updateKakaopayOrdersNo(vo);
	}
	
	public KakaopayVo getKakaopayByNo(int no) {
		return shopSQLMapper.selectKakaopayByNo(no);
	}
	
	public KakaopayVo getKakaopayByOrdersNo(int orders_no) {
		return shopSQLMapper.selectKakaopayByOrdersNo(orders_no);
	}
}

