package com.lotto.shinnanda.admin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lotto.shinnanda.admin.service.AdminService;
import com.lotto.shinnanda.commons.MultipartFileUtil;
import com.lotto.shinnanda.member.service.MemberService;
import com.lotto.shinnanda.shop.service.ShopService;
import com.lotto.shinnanda.vo.ImageVo;
import com.lotto.shinnanda.vo.OrdersVo;
import com.lotto.shinnanda.vo.Orders_DetailVo;
import com.lotto.shinnanda.vo.ProductVo;
import com.lotto.shinnanda.vo.Product_DetailVo;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("main")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("uploadProductPage")
	public String uploadProductPage(Model model) {
		model.addAttribute("product_categoryVoList", adminService.getProductCategory());
		model.addAttribute("brand_categoryVoList", adminService.getBrandCategory());
		
		return "admin/uploadProductPage";
	}
	
	@RequestMapping("uploadProductProcess")
	public String uploadProductProcess(ProductVo productVo, String[] product_detail_option, int[] product_detail_stock,
			MultipartFile[] thumbnail, MultipartFile[] detailimages) {

		productVo.setProduct_image(MultipartFileUtil.transferToUploadProductFolder(thumbnail, productVo.getProduct_title(), true).get(0).getImage_url());

		ArrayList<ImageVo> imageVoList = MultipartFileUtil.transferToUploadProductFolder(detailimages, productVo.getProduct_title(), false);

		adminService.uploadProduct(productVo, product_detail_option, product_detail_stock, imageVoList);

		return "redirect:../admin/main";
	}
	
	@RequestMapping("manageProductPage")
	public String manageProductPage(Model model) {

		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();
		ArrayList<ProductVo> productVoList = adminService.getProduct();		
		
		for(ProductVo productVo : productVoList) {
			HashMap<String, Object> map = new HashMap<>();
			
			ArrayList<Product_DetailVo> product_DetailVoList = shopService.getProductDetailByProductNo(productVo.getProduct_no());
			
			ArrayList<Integer> sumOrdersDetailCount = new ArrayList<>();
			for(Product_DetailVo prouct_DetailVo : product_DetailVoList) {
				sumOrdersDetailCount.add(adminService.getSumOrdersDetailCountByProductDetailNo(prouct_DetailVo.getProduct_detail_no()));
			}
			
			map.put("productVo", productVo);
			map.put("product_DetailVoList", product_DetailVoList);
			map.put("sumOrdersDetailCount", sumOrdersDetailCount);
			
			totalVoList.add(map);
		}
		
		model.addAttribute("totalVoList", totalVoList);	
		
		return "admin/manageProductPage";
	}
	
	@RequestMapping("salesStatusPage")
	public String salesStatusPage(Model model) {
		ArrayList<HashMap<String, Object>> totalVoList = new ArrayList<>();
		ArrayList<OrdersVo> ordersVoList = adminService.getOrders();
		
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
		
		return "admin/salesStatusPage";
	}
	
	@RequestMapping("modifyOrdersState")
	public String modifyOrdersState(OrdersVo vo, @RequestParam(value = "isDetailPage", defaultValue = "false") boolean isDetailPage) {
		shopService.modifyOrdersState(vo);
		
		if(isDetailPage) {
			return "redirect:../admin/detailSalesStatusPage?orders_no=" + vo.getOrders_no();
		}
		
		return "redirect:../admin/salesStatusPage";
	}
	
	@RequestMapping("detailSalesStatusPage")
	public String detailSalesStatusPage(int orders_no, Model model) {
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
		model.addAttribute("memberEmail", memberService.getMemberByNo(ordersVo.getMember_no()).getMember_email());
		
		return "admin/detailSalesStatusPage";
	}
	
	@RequestMapping("memberListPage")
	public String memberListPage(Model model) {
		
		model.addAttribute("memberVoList", memberService.getMemberList());
		
		return "admin/memberListPage";
	}
	
	@RequestMapping("detailMemberPage")
	public String detailMemberPage(int member_no, Model model) {
		
		model.addAttribute("member_no", member_no);
		
		return "admin/detailMemberPage";
	}
}
