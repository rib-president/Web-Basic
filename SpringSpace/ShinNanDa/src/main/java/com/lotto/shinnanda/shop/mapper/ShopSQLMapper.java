package com.lotto.shinnanda.shop.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.lotto.shinnanda.vo.CartVo;
import com.lotto.shinnanda.vo.ImageVo;
import com.lotto.shinnanda.vo.KakaopayVo;
import com.lotto.shinnanda.vo.OrdersVo;
import com.lotto.shinnanda.vo.Orders_DetailVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_CategoryVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

public interface ShopSQLMapper {
	//public ArrayList<ProductVo> selectLatest16Product();
	public ArrayList<ProductVo> selectLatest16Product(int pageNum);
	public int selectProductCnt();
	public ArrayList<ProductVo> selectProductByCategoryNoBrandNo(@Param("product_category_no") int product_category_no, @Param("brand_no") int brand_no);
	public Product_CategoryVo selectProductCategoryByNo(int no);
	public ArrayList<HashMap<String, Object>> selectBrandCategoryCount(int product_category_no);
	public ProductVo selectProductByNo(int no);
	public ArrayList<Product_DetailVo> selectProductDetailByProductNo(int product_no);
	public Product_DetailVo selectProductDetailByNo(int no);
	public ArrayList<ImageVo> selectProductImageByProductNo(int product_no);
	public ArrayList<HashMap<String, Integer>> selectOrdersProductAgeCnt(int product_no); 
	public void insertCart(CartVo vo);
	public ArrayList<CartVo> selectCartByMemberNo(int member_no);
	public CartVo selectCartByNo(int no);
	public void updateCartCount(CartVo vo);
	public void deleteCartByNo(int no);
	public void deleteCartByMemberNo(int member_no);
	public int createOrdersNo();
	public void insertOrders(OrdersVo vo);
	public OrdersVo selectOrdersByNo(int no);
	public ArrayList<OrdersVo> selectOrdersByMemberNo(@Param("member_no") int member_no, @Param("searchState") String searchState);
	public ArrayList<HashMap<String, Object>> selectOrdersStateCount(int member_no);
	public void insertOrdersDetail(Orders_DetailVo orders_DetailVo);
	public ArrayList<Orders_DetailVo> selectOrdersDetailByOrdersNo(int orders_no);
	public void updateOrdersState(OrdersVo vo);
	public int createKakopayNo();
	public void insertKakaopay(KakaopayVo vo);
	public void updateKakaopayOrdersNo(KakaopayVo vo);
	public KakaopayVo selectKakaopayByNo(int no);
	public KakaopayVo selectKakaopayByOrdersNo(int orders_no);
}
