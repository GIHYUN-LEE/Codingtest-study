/* 학습 내용
 * 1. 예외 상황 연출 후 컴파일예외인건지 실행 예외인건지 구분 
 * 2.
 * 3. 
 * 외부클래스에서 클래스명으로 호출하려면 static 사용
 */


package step06.exception;

public class ExceptionLab {

	public static void main(String[] args) {
	//	System.out.println(10/0); // 컴파일은 됐으나 실행 불가 java.lang.ArithmeticException
		int []i= {1,2,3};
		System.out.println(i[2]); // java.lang.ArrayIndexOutOfBoundsException , 예외 발생 시 유효한 index값으로 수정
		
		// byte code를 메모리에 로딩하는 기능의 메소드 : Class.forName()
		/* 메소드 실행 시 발생 가능한 경우의 수
		 * 1. 존재하는 클래스의 경우 정상 로딩
		 * 2. 오타 등으로 미존재하는 클래스 로딩 시 미정상 오류 예상
		 * .. 고려해서 메소드 개발자가 제시
		 * 미 존재할 경우 ClassNouFoundException
		 * 
		 * 문제 발생시 : 시스템 동작 catch 실행후 유지
		 */
		try {
			Class.forName("step06.exception.A"); //경로에 A 클래스 동적실행? + 에러가 생기면 바로 catch로 감
		} catch (ClassNotFoundException e) { //클래스에 없는 예외 
           // 예외 발생 시 실행되는 블록
			e.printStackTrace(); // 예외 발생 history 추적 및 출력
		}
		System.out.println("실행되나?");
	}
}

class A { //db 연동 코드에서 db접속을 위한 driver 로딩 코드로 사용 예정
	static {
		System.out.println("A.class라는 byte code가 메모리에 저장시 자동 실행되는 블록");
	}
}
