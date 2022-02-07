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
	
	  
//	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//	         Object handler) throws ServletException{
//	      System.out.println("여기로 오긴하나");
//	      if( handler instanceof HandlerMethod == false ) {
//	         // return true이면  Controller에 있는 메서드가 아니므로, 그대로 컨트롤러로 진행
//	    	 System.out.println("1111");
//	         return true;
//	      }
//	      // 2.형 변환
//	      HandlerMethod handlerMethod = (HandlerMethod)handler;
//	      
//	      // 3. @Auth 받아오기
//	      Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
//	      
//	      // 4. method에 @Auth가 없는 경우, 즉 인증이 필요 없는 요청
//	      if( auth == null ) {
//	    	  System.out.println("2222");
//	         return true;
//	      }
//	      
//	      // 5. @Auth가 있는 경우이므로, 세션이 있는지 체크
//	      HttpSession session = request.getSession();
//	      if( session == null ) {
//	    	  System.out.println("3333");
//	         // 로그인 화면으로 이동
//	         try {
//				response.sendRedirect(request.getContextPath() + "/main/main");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	         return false;
//	      }
//	      
//	      // 6. 세션이 존재하면 유효한 유저인지 확인
//	      MemberVo authUser = (MemberVo)session.getAttribute("sessionUser");
//	      System.out.println("authUser : " + authUser);
//	      if ( authUser == null ) {
//	         try {
//				response.sendRedirect(request.getContextPath() + "/main/main");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	         System.out.println("실패");
//	         return false;
//	      } else {
//	    	  System.out.println("성공!");
//	      }
//
//	      // 7. admin일 경우
//	      String role = auth.role().toString();
//	      if( "ADMIN".equals(role) ) {
//	         // admin임을 알 수 있는 조건을 작성한다.
//	         if("N".equals(authUser.getMember_admin())){   // admin이 아니므로 return false
//	            try {
//					response.sendRedirect(request.getContextPath() + "/admin/main");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	            return false;
//	         }
//	      }
//	      
//	      // 8. 접근허가, 즉 메서드를 실행하도록 함
//	      return true;
//	   }		
}
