/*  StartView(브라우저) -> Controller -> Model - .. > Controller
 *  → 정상 : SuccessView or 비정상 : FailView
 * 
 */


package controller;


import model.Model;
import model.domain.Employee;
import view.FailView;
import view.SuccessView;


public class Controller {
	
	private static Model model = Model.getModel();	
	//private static Model model = Model.getModel(); 23line 대신 작성 / 메소드 호출을 가급적 최소하해서 성능을 고려한다. spring의 멤버에 @Autowrite 등등 연관
	
	//모든 검색 메소드
	//데이터 정상 비정상 검증 : null 값으로 간단하게 진행
	public static void getEmployees() {
		Employee[] data=model.getEmployee();
		
		for(Employee e : data)
			System.out.println("사번 : "+e.getEmpno()+" "+"사원이름 : "+e.getEname()+" "+"부서번호 : "+e.getDeptno());
		}
	
   //직원들 정보 다 검색하는 로직 추가 해보기
		
	}

