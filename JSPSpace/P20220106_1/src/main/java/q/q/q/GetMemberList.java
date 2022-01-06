package q.q.q;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMemberList
 */
//@WebServlet("/GetMemberList")
public class GetMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 코어 로직 자바로 수행 후
		String command = request.getRequestURI();
		
		if(command.equals("/P20220106_1/GetMemberList")) {
			// 멤버리스트 가져오는 서비스(코어로직) 호출
		}else if(command.equals("/P20220106_1/loginPage")) {
			// 로그인 관련 서비스 호출
		} 
		
		
		ArrayList<String> memberList= new MemberService().getMemberList();
		
		request.setAttribute("qwer", memberList);
		
		request.getRequestDispatcher("/WEB-INF/views/GetMemberList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
