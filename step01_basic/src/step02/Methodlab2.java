package step02;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Person2{
	String name;
	int age;
	
//	public String getName() { //getter-getname() 불가, 왜? 추후 jsp tag가 자동 호출하는 메소드
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}             -> 전체 드래그 ctrl 슬래쉬
}
public class Methodlab2 {
//?
	static Person2 getPerson2(){
		return new Person2();
	}
	
	static void setPerson2(Person2 p) {
		p.name="고경완";
		System.out.println(p.name);
		//Person2 객체의 name값에 친구 이름 입력, 출력
	}
	
	public static void main(String[] args) {
		// getPerson2() -> setPerson2 호출해보기
		// 새로운 Person2 객체 생성 후 setPerson2 호출 후 이름값 수정하기
		Person2 p=new Person2();  //35줄 삭제하고 Person2 p=new 
		getPerson2();
		setPerson2(p);
		
		Person2 n=new Person2();
		n.setName("정준호");
		setPerson2(n);
		
		
		
		
	}

}
