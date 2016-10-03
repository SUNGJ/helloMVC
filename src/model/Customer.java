package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// lombok을 사용하여 편리하게 Getter, Setter, Constructor를 만들어 준다.

public class Customer {

	
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;	
	// 멤버변수
}
