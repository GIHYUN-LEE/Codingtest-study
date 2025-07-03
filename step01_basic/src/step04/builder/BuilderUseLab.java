package step04.builder;

import lombok.Builder;
import lombok.NonNull;

@Builder
class Customer{
	@NonNull
	String id; // 객체 생성시 반드시 ID값은 명시적인 초기화 필수(@NONNULL - 적용할 변수 위에 애노테이션)사용
	int pw;

	String job;
	//Customer(){} //생성자를 직접 명시한 것으로 생성되는 객체가 보유한 모든 멤버 변수값이 기본값으로 초기화된다.
	// id(String), pw(int), job(String), build() : 메소드
	// s가 붙으면 static - 객체 생성없이 class 생성할때 유용함
	
}

public class BuilderUseLab {

	public static void main(String[] args) {
		
		Customer c0=Customer.builder().pw(32).id("하이").build();
		System.out.println(c0.id);
		
		
		
		
		
		// id 변수값만 tester로 초기화하는 객체 생성
		// Customer c1=Customer.builder().id("tester").build();
		// Customer
		// Customer.builder() : CustomerBuilder 객체
		// Customer.builder().id("tester") : CustomerBuilder 클래스 내부의 메소드, 반환값은 Customer 객체
		
		Customer c1=Customer.builder().id("tester").build();
		System.out.println(c1.id+" "+c1.job);
		
		// id, pw 변수값만 초기화하는 객체 생성
		Customer c2=Customer.builder().id("이기현").build();
		Customer c3=Customer.builder().pw(8333).build();
		System.out.println(c2.id+" "+c3.pw);
		
		// id, pw, job 변수값만 초기화 하는 객체 생성  이렇게 말고 한번에 써도 됨 반환값이 CustomerBuilder라서
		Customer c4=Customer.builder().id("testo").build();
		Customer c5=Customer.builder().pw(846).build();
		Customer c6=Customer.builder().job("it dev").build();
		System.out.println(c4.id+" "+c5.pw+" "+c6.job);
		
		// id, job 변수값만 초기화하는 객체 생성
		
		
	}

}
