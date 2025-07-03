package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// 간편하게 사용가능

public class Employee {
	private int empno;
	private String ename; 
	private int deptno;
	
//	public Person() {}
//	public Person(String id, int pw) {
//		this.id = id;
//		this.pw = pw;
//	}



}
