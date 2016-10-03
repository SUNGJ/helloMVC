package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home") // 서블릿매핑으로 프로젝트 실행 시 URL 간단하게 localhost:8080/파일명으로 나오게 한다.
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action"); // action의 값을 저장한다.
	
		String page = null; 
		
		if(action.equals("login")) //action의 값이 login이면 loginForm.jsp로 지정한다.
			page = "/view/loginForm.jsp"; 
		else if(action.equals("register")) // action의 값이 register이면 registerForm.jsp로 지정한다.
			page = "/view/registerForm.jsp";
		else
			page = "/view/error.jsp"; // 둘 다 아니면 error.jsp로 지정한다.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response); // 지정된 페이지를 불러온다.
	}

}
