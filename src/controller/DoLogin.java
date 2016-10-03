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
@WebServlet("/doLogin") // �������� 
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
		
		String id = request.getParameter("id"); // ����ڰ� �Է��� id ���� �޾ƿ´�.
		String password = request.getParameter("password"); // ����ڰ� �Է��� password ���� �޾ƿ´�.
		
		CustomerService service = (CustomerService) CustomerService.getInstance(); // CustomerService��ü service�� getInstance�޼ҵ带 ����Ͽ� static��ü �ޱ�
		Customer customer = service.login(id, password); // ����ڰ� �Է��� id, password ���� login�޼ҵ�� ������ ��ġ�ϴ� ȸ���� ������ customer�� return�Ѵ�. 
		request.setAttribute("customer", customer); // request��ü�� customer�� �����Ѵ�.
				
		String page;
		if(customer == null){ //��ġ�ϴ� ȸ���� ���� ��� loginFail.jsp�� ������ �����Ѵ�.
			page ="/view/loginFail.jsp";
			request.setAttribute("id", id); // request��ü�� ����ڰ� �Է��� id���� �����Ѵ�.
		}
		else {
			page ="/view/loginSuccess.jsp"; // ��ġ�ϴ� ȸ���� ���� ��� loginSuccess.jsp�� �������� �����Ѵ�.
			request.setAttribute("customer", customer); // request��ü�� customer��ü�� �����Ѵ�.
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); // 
		dispatcher.forward(request, response); // ������ �������� ������.
	}

}
