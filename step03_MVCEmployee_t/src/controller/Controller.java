
package controller;

import model.Model;
import model.domain.Employee;
import view.FailView;
import view.SuccessView;

public class Controller {
	private static final Model model = Model.getModel();
	
	//step01 - 예외 학습 전 
	public static void getEmployees(){
		//로컬 변수는 멤버 변수와 달리 자동 초기화 불가
		//선언과 동시에 기본값으로 초기화 권장
		Employee[] datas = null;
		try {
			datas= model.getEmployees();
			SuccessView.print("사원들 정보입니다.", datas);
			
		}catch (Exception e) {
			e.printStackTrace();
			FailView.print(e.getMessage());                   //controller는 분기점이라서 빠르게 처리해줘야함
			
		}
				
	}
	
	//Controller의 특정 부서에 속한 사원만 검색 메소드
	public static void getDeptnoEmployee(int deptno) {
		
		Employee[] datas = null;
		
		try{
			datas=model.getSameDeptEmployees(deptno);
			SuccessView.print(deptno + "부서의 사원들 정보입니다.", datas);
		} catch (Exception e) {
			e.printStackTrace(); //코드를 짜는 사람이 확인용으로 사용(첫번째에 에러지점에 확인)
			FailView.print(e.getMessage());
		}
		
	}
	
}
