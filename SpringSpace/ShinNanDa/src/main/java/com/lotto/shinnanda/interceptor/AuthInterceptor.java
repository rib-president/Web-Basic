package com.lotto.shinnanda.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class AuthInterceptor extends WebContentInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		
		if(request.getSession().getAttribute("sessionUser") == null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("member/loginPage");
			
			throw new ModelAndViewDefiningException(mv);
		}
		return true;
	}
}
