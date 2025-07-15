
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.EmployeeDAO;
import model.domain.Employee;
import view.FailView;
import view.SuccessView;

public class Controller {
	private static final EmployeeDAO model = EmployeeDAO.getModel();

	public static void getEmployees() {
		ArrayList<Employee> datas = null; // 로컬 변수는 멤버 변수와 달리 자동 초기화 불가,
		// 선언과 동시에 기본값으로 초기화 권장

		try {
			datas = model.getEmployees();
			SuccessView.print("사원들 정보입니다.", datas);
		} catch (Exception e) {
			e.printStackTrace();// 개발자 관점에서 내부 구조 확인요
			// throw new Exception("직원 정봑 없습니다.(예외상황)");
			FailView.print("사원이 미존재합니다.");//
		}

	}
	// select * from employee where deptno=?
	/*
	 * 정상 검색 - 데이터가 있는 경우 - 데이터가 없는 경우 비정상 검색 - FailView.java
	 * 
	 * view -> controller -> DAO -> DB -> Controller -> View
	 * 
	 * sql 문장 실행 API 1. Statement - sql 문장에서 ' ' 정확하게 표현 2. PreparedStatement - 매우
	 * 중요 - db 연동 framework의 기본 기술 - 데이터값 표현시 ''등 불필요 무조건 ?로 표기 후 setXxx()값 대입 -
	 * 실행속도가 좋음
	 */

	public static void getDeptnoEmployee(int deptno) {
		ArrayList<Employee> datas = null;

		try {
			datas = EmployeeDAO.getDeptnoEmployee(deptno);
			if (datas.size() != 0) {
				SuccessView.print(deptno + " 부서에 속한 사원들 정보입니다.", datas);
			} else {
				SuccessView.printMsg(deptno + "에 속한 직원은 현 시점에는 존재하지 않습니다.");
			}
		} catch (Exception e) { // db 접속등의 문제 발생시 실행
			e.printStackTrace();
			FailView.print(deptno + "번호의 부서 검색을 재 요청해 주세요");
		}

	}

	public static void insertOracle(int empno, String ename, int deptno) { // 예외처리를 컨트롤러에서 한당?
		if (empno != 0 && ename != null && ename.length() != 0) {
			try {
				boolean result = model.insertOracle(new Employee(empno, ename, deptno));
				if (result) {
					SuccessView.printMsg(ename + "님 가입 성공");
				} else {
					SuccessView.printMsg(ename + "님 잠시후 다시 가입 요청");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("id값 중복 여부 확인드려요");
			}
		} else {
			SuccessView.printMsg("메인 화면입니다. 입력 데이터 재확인 부탁드려요");
		}

	}

	public static void updateDeptnoEmployee(int empno, int newDeptno) {
		if(empno!=0&&newDeptno!=0) {
			try {
				EmployeeDAO.updateOracle(empno,newDeptno);
				SuccessView.printMsg(empno+"님 부서 이동 성공");
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("잠시후 재시도 부탁드려요");
			}
		}else {
			SuccessView.printMsg("메인 화면입니다. 업데이트하려는 정보 재확인 하세요");
		}
	}
}