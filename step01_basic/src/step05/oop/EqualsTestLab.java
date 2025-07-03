/*  학습 내용
 * 1. java.lang.Object 상속 받는 메소드 중 두개의 메소드 재정의
 * 2. String toString(){객체의 위치값 문자열로 반환}
 * -자바에서 표현법으로 객체 생성하는건 문자열이랑 배열
 */

package step05.oop;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 멤버 초기화 생성자

class People{
	
	String id;
	int pw;
	
	public String toString() {
		return "유다연";
	}

/* 객체 타입 비교 연산자 - instanceof
 * People 객체 타입에 한해서 모든 멤버 변수들 값 비교후 데이터인 멤버 변수값이 동일한 경우만 true, 다를경우 false 반환하라
 * Object로 유입된 타입부터 확인 후에 동일한 타입인 경우에 한해서만 멤버 변수값 비교
 */
public boolean equals(Object o) {
	if(o instanceof People) { // people이 보유한 Object 타입의 변수가 호출 불가능한 자식만의 변수 호출
		People p=(People)o;
		if(id.equals(p.id)&&pw==p.pw) {
			return true;
		}
	}else { // 객체 타입이 people이 아닌 경우 false 반환
		return false;
	}
	return false;
 }
}


public class EqualsTestLab {

	public static void main(String[] args) {
		People p1=new People("유재석",30);
		People p2=new People("유재석",30);
		
		System.out.println(p1.equals(p2));
//		System.out.println();
//		System.out.println(p1); //toString()
//		System.out.println(p2);
//		System.out.println(p1.toString());
//		System.out.println(p2.toString());
//		
//		String v="문자열";
//		System.out.println(v);
		
	}

}

