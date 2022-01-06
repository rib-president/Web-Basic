package q.q.q;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.a.a.StudentVo;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// DB 연동
		// 기타 등등 처리
		
		// 출력돼야할 데이터 위치
		
		ArrayList<StudentVo> list = new ArrayList<>();
		list.add(new StudentVo("한조1", 0, 0));
		list.add(new StudentVo("한조2", 0, 0));
		list.add(new StudentVo("한조3", 0, 0));
		list.add(new StudentVo("한조4", 0, 0));
		list.add(new StudentVo("한조5", 0, 0));
		list.add(new StudentVo("한조6", 0, 0));
		list.add(new StudentVo("한조7", 0, 0));
		
		request.setAttribute("studentList", list);
		
		request.getRequestDispatcher("/test1.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
