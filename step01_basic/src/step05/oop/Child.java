/* 학습 내용
 * 1. 단순 상속 문법 습득
 * 2. 메소드 재정의
 */


package step05.oop;

class Parent extends Object{ //extends object가 컴파일하면 자동으로 생성됨
	String name;
	int age;
	
	Parent(){
		super(); // 13~15는 컴파일하면 자동으로 생성됨 , parameter가 동일한 부모 생성자 호출, 부모 객체 우선 생성 의미
		System.out.println("부모");
	}// 종료시점에 모든 멤버변수가 heap 메모리에 parent 영역 내부에 초기화된다.
	
	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

public class Child extends Parent { //child가 parent의 모든걸 쓸수 있음
	String job;
	
	public Child() {
		super();					//자동으로 생기는 라인
		System.out.println("자식");
		
    }
	void printAll() {
	    super.printAll(); //부모 메소드 body
		System.out.println(job);
	}

	public static void main(String[] args) {
		// c1 변수타입 = 자식 타입 
		Child c1=new Child(); // 자식-슈퍼-부모-슈퍼-object-부모-자식 | new쓰면 Child 객체 새로 생성
		c1.name="df";
		c1.age=3;
		c1.job="sdf";
		
		Parent p1=new Child(); //p1 변수타입 = 부모 타입, 자식만의 멤버변수에 접근이 불가하며 해결하려면 자식 레밸로 변수 타입을 변환한다. | new쓰면 child 새로 생성
		p1.name="d";
		p1.age=10;
//		p1.job="ee"; 부모타입이라 자식타입에 접근 불가
		Child c2=(Child)p1; // p1이 자식의 주소를 참조
		c2.job="eee";
		
		c2.name="유관순";
		System.out.println(p1.name);
		
		// c2 변수에 c1이 참조했던 객체를 대입하고 name 변수값에 이순신 이름 저장하기
		c2=c1;
		c2.name="이순신";
		System.out.println(c2.name+" "+c1.name);
	}
}

