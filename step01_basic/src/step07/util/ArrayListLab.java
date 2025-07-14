package step07.util;

import java.util.ArrayList;
import org.junit.Test;

public class ArrayListLab {
	
	/* wrapper class
	 * - 기본타입(8)과 객체 타입 관련 클래스(8)들 학습
	 * - int vs Integer / byte vs Byte ...
	 * - jdk.1.5부터 생성
	 * - autoboxing : 기본값을 자동으로 객체화
	 * - unboxing : 객체를 기본으로 변환
	 * 
	 */
	
	 @Test
	 public void m3() {
		 /* 제네릭 : jdk1.5 메카니즘
		  * -강제적인 타입 제한
		  * -장점 : 코드 간결성 추구, 내부 실행속도 향상, 원하는 타입으로 데이터 관리, 형변환이 불필요함
		  * - <타입제한> 표기 사용
		  * 
		  */
		 
		 ArrayList<String> a1 = new ArrayList<>(); // 뒤에는 <>넣어도되고 안넣어도됨 , String 타입으로 저장하겠다고 제한함
		 a1.add("String");
		 System.out.println(a1.toString()); 
		 System.out.println(a1.get(0));  
		 
		 System.out.println(a1.get(0).charAt(0));
		 
	 }
	 
	 
	@Test
	public void m2() {
		//unboxing
		//생성된 객체의 3값을 int로 뽑아서 i에 대입
		int i = new Integer(3);  // 내부적으로 코드가 (new Integer(3)).intValue()
		
		//autoboxing
		Integer i2 = 3; // new Integer(3)으로 객체 생성 후 i2에 대입
	}
	
	
	
	

 //@Test //void 반환 메소드여야함
 public void m1() {
	 // 초기치 10개의 메모리가 있는 객체 생성
	 // 11번째로 넘어가면 자동으로 10개씩 추가 생성
	 // 배열과 비슷한 객체
	 // 모든타입 저장이 가능함 = object
	 // public Object get(int index);
	 
	 ArrayList a1 = new ArrayList();
	 a1.add("String");
	 a1.add(new Integer(3)); //1번째
	 a1.add(7);
	 System.out.println(a1.toString()); // toString이 뭐지? 
	 System.out.println(a1.get(1));
	 a1.remove(1);
	 System.out.println(a1.get(1));  //7 (빈 곳에 채워짐 == 동적메모리)
	 
	 // 0번쨰 데이터의 첫번째 철자 뽑기
	 System.out.println(((String) a1.get(0)).charAt(0));
	 
 }

}
