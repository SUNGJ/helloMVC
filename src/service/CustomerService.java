package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	
	private Map<String, Customer> customers; // key�� value�� �����ϴ� Map���� �ڷᱸ����  customers����
	
	//singleton ��ü�� �ϳ��� �����Ͽ� �����ϱ� ���� ���
	private static final CustomerService instance = new CustomerService(); // ������� �ʰ� �� �ϳ��� �����ϴ� CustomerService��ü ����
	
	private CustomerService() {
		customers = new HashMap<String, Customer>();
	} // HashMap ��ü �����Ѵ�.
	
	public static CustomerService getInstance() {
		return instance;
	} // �����ϱ� ���� ��ü ����
	
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	} // customers�� id�� Customer��ü ����
	
	public Customer findCustomer(String id){
		if(id != null)
			return(customers.get(id.toLowerCase())); // customers �� ����ڰ� �Է��� id�� ���� id�� ���� ��ü����
		else 
			return null; //���� ���� ���̵� ���� null�̶�� null�� ����
	}
	
	public Customer login(String id, String password) {
		// TODO Auto-generated method stub
		Customer customer = findCustomer(id.toLowerCase()); // findCustomer�޼ҵ带 �̿��Ͽ�  ���� �� ��ü�� �޴´�.
		if(customer != null){
			if(password.equals(customer.getPassword())){  
				return customer; // ���� �� ��ü�� password ���� ������ customer�� �����Ѵ�.
			}
			else return null; // ���� ���� �� ��ü�� password ���� �ٸ��� null���� �����Ѵ�.
		}
		else return null; // ��ġ�ϴ� ��ü�� ���ٸ� null���� �����Ѵ�.
	}
}
