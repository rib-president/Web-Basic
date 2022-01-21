package com.ja.finalproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class AuthInterceptor extends WebContentInterceptor{
	// 오버라이딩
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws ModelAndViewDefiningException {
		
		// System.out.println("인터셉터 로직 수행..");
		// 로그인하지 않았으면 로그인이 필요한 페이지임을 알림
		
		// request.getSession() => return HttpSession 인스턴스
		if(request.getSession().getAttribute("sessionUser") == null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("member/loginRequired");	// forwarding할 곳 지정
			
			// exception을 발생시켜 forwarding함
			throw new ModelAndViewDefiningException(mv);
		}
		return true;	// 원래 목적지로 감
	}
}
