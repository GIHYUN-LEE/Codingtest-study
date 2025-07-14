package step06.exception;

public class ExceptionLab2 {

		//예외 발생 시 해당 메소드 내에서 처리
		static void m1() {
			try {
				Class.forName("step06.exception.A");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		static void m2()throws ClassNotFoundException {
			Class.forName("step06.exception.A");
			// ... 에외 발생 시 중지되는 영역
			
		//예외 발생 시 호출한 곳으로 예외 처리 위임	
		}
		public static void main(String[] args) {
			m1();
			
			try {
				m2();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
}
