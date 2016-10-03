package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); 
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		// 사용자가 입력한 정보를 받아온다.
		
		CustomerService service = (CustomerService) CustomerService.getInstance(); // CustomerService 객체인 service에 getInstance를 사용해서 객체를 받는다.
		
		Customer customer = new Customer(id,password,name,gender,email); // 사용자가 입력한 정보에 따른 customer 객체를 만든다.
		service.addCustomer(customer); // customer를 service에 저장한다.
		request.setAttribute("customer", customer); // request객체에 customer 저장한다.
		
		
		String page;

		page ="/view/registerSuccess.jsp"; // registerSuccess.jsp로 페이지를 지정한다. 
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response); // 지정된 페이지로 보낸다.
		
		
		
	}
}
