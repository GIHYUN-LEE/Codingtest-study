
package step01;

public class Person3 {

	int a=3;
	
	void m1() {
		System.out.println("m1()");
	}
	
	public static void main(String[] args) {
		// p1 - 객체 관리변수(객체 참조 변수)
		// p1과 p2는 다름
		Person3 p1=new Person3();
		Person3 p2=new Person3();
		
		System.out.println(p1.a);
		p1.m1();
		
		System.out.println(p1==p2); // 주소값 비교

	}

}
