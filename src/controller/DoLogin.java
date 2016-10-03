package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin") // 서블릿매핑 
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id"); // 사용자가 입력한 id 값을 받아온다.
		String password = request.getParameter("password"); // 사용자가 입력한 password 값을 받아온다.
		
		CustomerService service = (CustomerService) CustomerService.getInstance(); // CustomerService객체 service에 getInstance메소드를 사용하여 static객체 받기
		Customer customer = service.login(id, password); // 사용자가 입력한 id, password 값을 login메소드로 보내서 일치하는 회원이 있으면 customer를 return한다. 
		request.setAttribute("customer", customer); // request객체에 customer를 저장한다.
				
		String page;
		if(customer == null){ //일치하는 회원이 없을 경우 loginFail.jsp로 페이지 지정한다.
			page ="/view/loginFail.jsp";
			request.setAttribute("id", id); // request객체에 사용자가 입력한 id값을 저장한다.
		}
		else {
			page ="/view/loginSuccess.jsp"; // 일치하는 회원이 있을 경우 loginSuccess.jsp로 페이지를 지정한다.
			request.setAttribute("customer", customer); // request객체에 customer객체를 저장한다.
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); // 
		dispatcher.forward(request, response); // 지정한 페이지로 보낸다.
	}

}
