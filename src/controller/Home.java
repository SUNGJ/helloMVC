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
@WebServlet("/home") // ������������ ������Ʈ ���� �� URL �����ϰ� localhost:8080/���ϸ����� ������ �Ѵ�.
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
	
		String action = request.getParameter("action"); // action�� ���� �����Ѵ�.
	
		String page = null; 
		
		if(action.equals("login")) //action�� ���� login�̸� loginForm.jsp�� �����Ѵ�.
			page = "/view/loginForm.jsp"; 
		else if(action.equals("register")) // action�� ���� register�̸� registerForm.jsp�� �����Ѵ�.
			page = "/view/registerForm.jsp";
		else
			page = "/view/error.jsp"; // �� �� �ƴϸ� error.jsp�� �����Ѵ�.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response); // ������ �������� �ҷ��´�.
	}

}
