/* 학습내용
 * 1. 생성자 - 객체 생성 필수 요소
 * 2. 생성자가 실행되다는 의미
 * 	- 멤버변수들을 사용가능하게 실체화(메모리 확보) 
 */

package step03.array;


class A{
	String message="새로운 시작"; // A(){ System.out.prinln("A 생성자");}로 객체가 생성됐는지 확인가능
} // 실행 종료 시 message 변수 생성, 완벽한 A 객체 생성 주소값 부여

class B{
	A a =new A();
}

class C{
	B b = new B();
}

public class Dotlab {
	public void test() {
		C c =new C();
		/* 생성된 개체수 = 4개(String-A-B-C)
		 * 더 이상의 객체 생성없이 message 변수값 출력
		 * message 변수가 참조하는 String 객체의 길이 출력
		 * message 변수가 참조하는 index 1번째의 문자 출력
		 */
		
		System.out.println(c.b.a.message);
		System.out.println(c.b.a.message.length());
		System.out.println(c.b.a.message.charAt(1));
	}

}
