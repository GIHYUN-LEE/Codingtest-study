//html파일로 변환
package view;

import controller.Controller;

public class StartView {

	
	public static void main(String[] args) {
		System.out.println("*** step01 : 모든 사원 검색");
		Controller.getEmployees();
		
		/* 추가 로직
		 * - 존재하는 부서 번호에 소속된 직원들만 검색
		 * - 직원들 미존재시 미존재 메세지 출력 
		 */
//		System.out.println("*** step02 : 특정 부서 사원만 검색");
//		System.out.println("----- 10번 부서에 소속된 사원들");
//		Controller.getDeptnoEmployee(10);
		
		
//		
//		System.out.println("----- 100번 부서에 소속된 사원들");
//		Controller.getDeptnoEmployee(100);
		
		
//		System.out.println("***step03:client가 브라우저로 입력한 데이터로 저장");
		
		/* empno, ename, deptno:
		 * empno는 중복 불허(PK) / deptno dept table의 deptno 참조(FK)
		 * 
		 * 발생 가능한 경우의 수 -> 요게 중요
		 * 1. 사용자가 미입력 후 가입 버튼만 클릭 : " "로 서버로 전송
		 * 2. 입력은 했으나 PK 중복 : sql 실행 시 DB에서 에러 발생 - 이 경우 자바에서 SQLException으로 인지
		 * 3. 입력은 했으나 deptno가 없는 부서 : sql 실행 시 DB에서 에러 발생 - 이 경우 자바에서 SQLException으로 인지
		 * 4. 개발자가 sql문장 오류 : sql 실행 시 DB에서 에러 발생 - 이 경우 자바에서 SQLException으로 인지
		 * 5. 운영 측면에서 서버 자체의 문제 : 404, 500 번호로 발생
		 * 6. 접속 폭주 : Connection Plling 적용 미적용 ..? 
		 * 7. 유해한 경로로 요청이 올 수 있음
		 * 
		 */
//		Controller.insertOracle(11,"신준수",10);
		
		System.out.println("***step04 : 사번으로 부서이동");
		Controller.updateDeptnoEmployee(11,30);
	}

}