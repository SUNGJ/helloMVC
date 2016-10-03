package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	
	private Map<String, Customer> customers; // key와 value를 저장하는 Map형의 자료구조인  customers생성
	
	//singleton 객체가 하나만 존재하여 공유하기 위한 방식
	private static final CustomerService instance = new CustomerService(); // 변경되지 않고 단 하나만 존재하는 CustomerService객체 생성
	
	private CustomerService() {
		customers = new HashMap<String, Customer>();
	} // HashMap 객체 생성한다.
	
	public static CustomerService getInstance() {
		return instance;
	} // 공유하기 위한 객체 리턴
	
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	} // customers에 id와 Customer객체 저장
	
	public Customer findCustomer(String id){
		if(id != null)
			return(customers.get(id.toLowerCase())); // customers 중 사용자가 입력한 id와 같은 id를 가진 객체리턴
		else 
			return null; //만약 받은 아이디 값이 null이라면 null값 리턴
	}
	
	public Customer login(String id, String password) {
		// TODO Auto-generated method stub
		Customer customer = findCustomer(id.toLowerCase()); // findCustomer메소드를 이용하여  리턴 된 객체를 받는다.
		if(customer != null){
			if(password.equals(customer.getPassword())){  
				return customer; // 리턴 된 객체와 password 값이 같으면 customer를 리턴한다.
			}
			else return null; // 만약 리턴 된 객체와 password 값이 다르면 null값을 리턴한다.
		}
		else return null; // 일치하는 객체가 없다면 null값을 리턴한다.
	}
}
