/* 학습내용
 * 1. 배열 문법 및 응용하기
 * 2. main메소드 없이도 실행을 위한 단위 test framework
 *    ㆍjUnit
 *    ㆍ사용방법 : library를 project에 등록(maven, gradle)
 *    ㆍ코드상에서 @Test 방식으로 설정
 * 3. 참고
 *    ㆍ멤버변수 : class{}내부에 선언, 객체 생성 시 생성
 *              생성시 기본값으로 자동 초기화
 *    ㆍ로컬변수 : 자동 초기화 진행되지 않음           
 */

package step03.array;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

class Person{
	String name;
	int age;
}


public class ArrayLab {

	// int[] 문법 습득
	public void m1(){
		int []i= {1,2,3};
		  /* i가 참조하는 int[]생성
		   * 배열의 크디는 3
		   * 배열의 데이터 구분을 위한 고유한 index 부여
		   * index는 0부터 부여
		   * 0번째1 / 1번째 2 저장
		   */
		System.out.println(i.length);
		System.out.println(i[1]);
	}
	
	//Person 객체 3개 저장 가능한 Person 배열
	// 배열 반환
	public Person[] m2(){
		Person[]p= {new Person("유재석",1),
				    new Person("신동엽",11),
				    new Person("GD",21)};
		return p; 
		}
	
	//Person 배열을 받아서 이름만 출력
	/*반복문, length 변수
	 * for / for each문 사용
	*/
	
	public void personPrint(Person[] data) {
		/* step01-정통 for
		 * for(int index=0; index<data.length;index++){
		 * 		System.out.prinln(data[index].name);
		 * }
		 * data : Person[] 객체 참조
		 * data[index] : Person 객체
		 * data[index].name : String 객체
		 * 
		 * 
		 * for each(배열, list에 적용)
		 */

		for(Person p :data) {
			System.out.println(p.name);
		}
	
		System.out.println("call 확인");
	}

	public void test() {
//		Person[] p =m2();
//		personPrint(p);  아래 66line이랑 같음
		
//		personPrint(m2());
		
		/* System : java.lang 내부의 class
		 * System.out : System 내부의 변수
		 *              static 키워드가 선언된 변수
		 *              public static PrintStream의 out 변수
		 * System.out.println() : 이 메소드는 PrintStream에
		 * 
		 */
		
	}
}
	
	
//	@Test // 클래스 안에 선언해야함
//	public void m1() {
//		String s=null;
//		System.out.println(s.length()); //Null pointer exception
		
