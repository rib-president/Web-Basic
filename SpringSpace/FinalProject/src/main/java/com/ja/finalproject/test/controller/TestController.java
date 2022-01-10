package com.ja.finalproject.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test/*")
public class TestController {
	@RequestMapping("test1")
	public void test1() {
		System.out.println("안녕하1");
		// forward test/test1
	}
	
	@RequestMapping("test2")
	public String test2() {
		System.out.println("안녕하2");
		
		return "test/test2";	// forwarding
	}
	
	@RequestMapping("test3.do")
	public ModelAndView test3() {
		System.out.println("안녕하3");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test/test2");
		
		return mv;
	}
}
