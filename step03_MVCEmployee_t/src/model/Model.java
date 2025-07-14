/*  추가 학습 내용
 *  1. Model은 Database로부터 CRUD 작업
 *  2. 검색 로직
 *     검색한 자료가 존재할 경우 정상 반환
 *     검색한 자료가 미 존재 시 예외 발생(연출)
 * 
 */


package model;

import model.domain.Employee;

public class Model {
	private Database db = new Database();
	
	private static Model model = new Model();
	
	private Model() {} 
	
	public static Model getModel() {
		return model;
	}
		
	public Employee[] getEmployees() throws Exception {
		Employee[] emps = db.getEmployees();
		
//		if(emps.length!=0) {
//			return emps;
//		}else {
//			// 사용자가 직접 관련 메세지로 예외 발생
//			throw new Exception("직원 정보가 없습니다.(예외상황)");               //예외처리 1
//		}
//		
		if(emps.length==0) {
			// 문자열을 Exception 클래스의 message라는 변수 초기화, 객체 생성
			// getMessage()로 데이터 활용
			// throw 생성한 Exception 객체를 thow 의미
			throw new Exception("직원 정보가 없습니다.(예외상황)"); //"직원 정보가 없습니다가 controller의 e로 넘어감       //예외처리 2
		} return emps;
		
	}
	
	//특정 부서에 속한 사원들만 검색해서 반환
	public Employee[] getSameDeptEmployees(int deptno) throws Exception {  //throws 있는 메서드에 이름쪽에 무조건 throws Exception 써줘야함
	    // 모든 직원 정보 획득
		Employee[] emps = db.getEmployees();
		
		//해당 부서에 속한 직원 정보만 저장하기 위한 배열을 생성하기 위해서
		//직원수 count
		int count = 0;
		for(Employee emp : emps) {
			if(emp.getDeptno() == deptno) { // == : 기본데이터의 경우 동등비교연산자
				count++;				
			}
		}// 해당 부서에 속한 직원 수 파악
		
		//특정 부서에 소속된 직원이 미 존재할 경우 명시적인 예외 발생
		if (count == 0) {
			throw new Exception(deptno + "부서에 소속된 사원이 미 존재합니다.");
		}
		int index = 0;
		Employee[] sameDeptno = new Employee[count];  // 직원수 만큼 배열 생성
		for(Employee emp : emps) {
			if(emp.getDeptno() == deptno) {
				sameDeptno[index] = emp;   //부서번호가 동일한 직원 객체 배열에 저장				
				index++;
			}
		}
		return sameDeptno;  //해당 직원만 저장된 배열 반환
	}
}
