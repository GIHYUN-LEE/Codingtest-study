/* 학습내용
 * 1. 변수 선언 및 호출
 * 2. 메소드 구현 및 호출
 * 3. 로직
 *   - 내 짝꿍 주요 키워드 : 데이터
 *   - 누구야 널보니 이 키워드가 떠올라 라는 메시지 출력 : 기능
 */



package step01;

public class Person {

	public static void main(String[] args) { // 시작을 위한 메소드
		// 변수 선언 및 초기화
		// *파이선 : image = "댄서"; - 타입 제시 x
		// *자바스크립트 : image = "댄서"; - 타입 제시 x
		// *RDBMS의 SQL
		//  - image varchar2 형식으로 선언
		//  - image 컬럼에 저장 가능한 데이터는 문자열만
		
		String image = "댄서";
		// String : 내장되어있는 문자열	
		
		System.out.println("널 보니 이 키워드("+image+")가 떠올라");
		
		// println() : 출력의 의미
		// System.out : 프로그램이 실행되는 시스템의 콘솔창을 의미로 JDK 내부에 내장된 라이브러리
		
	}

}
