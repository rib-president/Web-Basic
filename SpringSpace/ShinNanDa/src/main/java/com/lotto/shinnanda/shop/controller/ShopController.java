package com.lotto.shinnanda.shop.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lotto.shinnanda.admin.service.AdminService;
import com.lotto.shinnanda.shop.service.ShopService;
import com.lotto.shinnanda.vo.CartVo;
import com.lotto.shinnanda.vo.MemberVo;
import com.lotto.shinnanda.vo.OrdersVo;
import com.lotto.shinnanda.vo.Orders_DetailVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("main")
	public String main(Model model) {
		ArrayList<ProductVo> voList = shopService.getMainPage16Product();

		model.addAttribute("voList", voList);		
		return "shop/main";
	}
	
	@RequestMapping("categoryViewPage")
	public String categoryViewPage(int product_category_no, @RequestParam(value = "brand_no", defaultValue = "0") int brand_no, Model model) {
		model.addAttribute("voList", shopService.getProductByCategoryNoBrandNo(product_category_no, brand_no));
		model.addAttribute("product_CategoryVo", shopService.getProductCategoryByNo(product_category_no));
		model.addAttribute("brandCategoryCountList", shopService.getBrandCategoryCount(product_category_no));
		
		return "shop/categoryViewPage";
	}
	
//	@RequestMapping("detailProductPage")
//	public String detailProductPage(int product_no, Model model) {
//		ArrayList<Product_DetailVo> detailVoList = shopService.getProductDetailByProductNo(product_no);
//		
//		ArrayList<HashMap<String, Object>> productDetailVoList = new ArrayList<>();
//		for(Product_DetailVo detailVo : detailVoList) {
//			HashMap<String, Object> map = new HashMap<>();
//			
//			int product_detail_no = detailVo.getProduct_detail_no();
//
//			Integer orderCount = adminService.getSumOrdersDetailCountByProductDetailNo(product_detail_no);
//			if(orderCount == null) orderCount = 0; 
//			int stock = detailVo.getProduct_detail_stock() - orderCount;
//			
//			map.put("detailVo", detailVo);
//			map.put("stock", stock);
//			
//			productDetailVoList.add(map);
//		}
//		
//		model.addAttribute("productVo", shopService.getProduct(product_no));
//		model.addAttribute("productDetailVoList", productDetailVoList);
//		model.addAttribute("productImageVoList", shopService.getProductImageByProductVo(product_no));
//		
//		return "shop/detailProductPage";
//	}
	
//	@RequestMapping("addCartProcess")
//	public String addCartProcess(int product_no, int[] product_detail_no, int[] productCount, HttpSession session) {
//
//		int member_no = ((MemberVo) session.getAttribute("sessionUser")).getMember_no();
//		
//		for(int i=0;i<product_detail_no.length;i++) {
//			CartVo vo = new CartVo();
//			vo.setProduct_detail_no(product_detail_no[i]);
//			vo.setMember_no(member_no);
//			vo.setCart_count(productCount[i]);
//			
//			shopService.addCart(vo);
//		}
//		
//		return "redirect:../shop/detailProductPage?product_no=" + product_no;
//	}

//	@RequestMapping("cartPage")
//	public String cartPage(HttpSession session, Model model) {
//		
//		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();
//		ArrayList<CartVo> cartVoList = shopService.getCartByMemberNo(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
//		
//		for(CartVo cartVo : cartVoList) {
//			HashMap<String, Object> map = new HashMap<>();
//			
//			int product_detail_no = cartVo.getProduct_detail_no();
//			Product_DetailVo product_DetailVo = shopService.getProductDetailByNo(product_detail_no);
//
//			Integer orderCount = adminService.getSumOrdersDetailCountByProductDetailNo(product_detail_no);
//			if(orderCount == null) orderCount = 0; 
//			int stock = product_DetailVo.getProduct_detail_stock() - orderCount;
//			
//			int product_no = product_DetailVo.getProduct_no();
//			ProductVo productVo = shopService.getProduct(product_no);
//			
//			map.put("productVo", productVo);
//			map.put("product_DetailVo", product_DetailVo);
//			map.put("stock", stock);
//			map.put("cartVo", cartVo);
//			
//			totalVoList.add(map);
//		}
//		
//		model.addAttribute("totalVoList", totalVoList);
//		
//		return "shop/cartPage";
//	}
	
	@RequestMapping("cartPage")
	public String cartPage() {
		
		return "shop/cartPage";
	}	
	
//	@RequestMapping("changeCartCount")
//	public String changeCartCount(CartVo vo) {
//		shopService.modifyCartCount(vo);
//		
//		return "redirect:../shop/cartPage";
//	}
	
//	@RequestMapping("delCheckedCartProcess")
//	public String delCheckedCartProcess(String[] checked_cart_no_list) {
//		
//		for(String cart_no : checked_cart_no_list) {		
//			shopService.delCartByNo(Integer.parseInt(cart_no));
//		}
//
//		return "redirect:../shop/cartPage";
//	}
	
//	@RequestMapping("delCartProcess")
//	public String delCartProcess(HttpSession session) {
//		shopService.delCartByMemberNo(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
//		
//		return "redirect:../shop/cartPage";
//	}
	
	@RequestMapping("orderPage")
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
	
	@RequestMapping("orderProcess")
	public String orderProcess(OrdersVo ordersVo, int[] product_detail_no, int[] productCount, HttpSession session) {
		
		int member_no = ((MemberVo) session.getAttribute("sessionUser")).getMember_no();
		
		ordersVo.setMember_no(member_no);
		ArrayList<CartVo> cartVoList = shopService.getCartByMemberNo(member_no);
		
		int orders_no = shopService.registOrders(ordersVo, product_detail_no, productCount, cartVoList );		
		
		return "redirect:../shop/detailOrdersInfoPage?orders_no=" + orders_no;
	}
	
	@RequestMapping("ordersInfoPage")
	public String ordersInfoPage(String searchState, HttpSession session, Model model) {
		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();
		
		ArrayList<OrdersVo> ordersVoList = shopService.getOrdersByMemberNo(((MemberVo) session.getAttribute("sessionUser")).getMember_no(), searchState);
		
		for(OrdersVo ordersVo : ordersVoList) {
			HashMap<String, Object> map = new HashMap<>();
			
			ArrayList<Orders_DetailVo> orders_DetailVoList =  shopService.getOrdersDetailByOrdersNo(ordersVo.getOrders_no());
			
			// int orders_price = 0;
			long orders_price = 0;
			for(Orders_DetailVo forCalcVo : orders_DetailVoList) {
				orders_price += forCalcVo.getOrders_detail_count() * 
						shopService.getProduct(shopService.getProductDetailByNo(
								forCalcVo.getProduct_detail_no()).getProduct_no()).getProduct_price();
			}
			
			Product_DetailVo product_DetailVo = shopService.getProductDetailByNo(orders_DetailVoList.get(0).getProduct_detail_no());
			ProductVo productVo = shopService.getProduct(product_DetailVo.getProduct_no());
			
			map.put("ordersVo", ordersVo);
			map.put("orders_DetailVo", orders_DetailVoList.get(0));
			map.put("ordersCount", orders_DetailVoList.size()-1);
			map.put("orders_price", orders_price);
			map.put("product_DetailVo", product_DetailVo);
			map.put("productVo", productVo);
			
			totalVoList.add(map);
		}
		
		model.addAttribute("totalVoList", totalVoList);
		
		return "shop/ordersInfoPage";
	}	
	
	@RequestMapping("detailOrdersInfoPage")
	public String detailOrdersInfoPage(int orders_no, Model model) {
		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();
		
		OrdersVo ordersVo = shopService.getOrdersByNo(orders_no);
		ArrayList<Orders_DetailVo> orders_DetailVoList =  shopService.getOrdersDetailByOrdersNo(orders_no);
		
		for(Orders_DetailVo orders_DetailVo : orders_DetailVoList) {
			HashMap<String, Object> map = new HashMap<>();
			Product_DetailVo product_DetailVo = shopService.getProductDetailByNo(orders_DetailVo.getProduct_detail_no());
			ProductVo productVo = shopService.getProduct(product_DetailVo.getProduct_no());
			
			map.put("orders_DetailVo", orders_DetailVo);
			map.put("product_DetailVo", product_DetailVo);
			map.put("productVo", productVo);
			
			totalVoList.add(map);
		}
		
		model.addAttribute("ordersVo", ordersVo);
		model.addAttribute("totalVoList", totalVoList);
		
		return "shop/detailOrdersInfoPage";
	}
	
	@RequestMapping("modifyOrdersState")
	public String modifyOrdersState(OrdersVo vo) {
		shopService.modifyOrdersState(vo);
		
		return "redirect:../shop/detailOrdersInfoPage?orders_no="  + vo.getOrders_no();
	}
	
	@RequestMapping("myPage")
	public String myPage(HttpSession session, Model model) {
		ArrayList<HashMap<String, Object>> ordersStateCountList = shopService.getOrdersStateCount(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
		
		HashMap<String, Object> map = new HashMap<>();
		int totalCount = 0;
		for(HashMap<String, Object> ordersStateCount : ordersStateCountList) {
			totalCount += Integer.parseInt(String.valueOf(ordersStateCount.get("STATE_COUNT")));
			
			map.put((String) ordersStateCount.get("ORDERS_STATE"), ordersStateCount.get("STATE_COUNT"));
		}
		
		model.addAttribute("ordersStateCountMap", map);
		model.addAttribute("totalCount", totalCount);
		
		return "shop/myPage";
	}
}
