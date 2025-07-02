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

public class Person {
	private String id;
	private int pw;  //데이터가 저장되는 틀의 느낌
	
//	public Person() {}
//	public Person(String id, int pw) {
//		this.id = id;
//		this.pw = pw;
//	}



}
