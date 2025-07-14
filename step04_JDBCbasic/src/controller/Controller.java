
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.EmployeeDAO;
import model.domain.Employee;
import view.FailView;
import view.SuccessView;

public class Controller {
	private static final EmployeeDAO model = EmployeeDAO.getModel();

	public static void getEmployees() {
		ArrayList<Employee> datas = null;
		try {
			datas = model.getEmployees();
			SuccessView.print("사원들 정보입니다.", datas);

		} catch (Exception e) {
			e.printStackTrace();
			FailView.print(e.getMessage()); // controller는 분기점이라서 빠르게 처리해줘야함

		}

	}

	// select*from employee where deptno=?
	/*
	 * 정상 검색 - 데이터가 있는 경우 - 데이터가 없는 경우 비정상 검색 - FailView.java 흐름 : view ->
	 * controller -> DAO -> DB -> DAO -> Controller -> View
	 * 
	 * sql 문장 실행 API - statement : sql 문장에 ' ' 정확하게 표현 - preparedstatement db 연동
	 * framework의 기본 기술, 데이터값 표현 시 ''등 불필요 무조건 ? 로 표기 후 setXxx()값 대입, 실행속도가 좋음
	 */
	public static void getDeptnoEmployee(int deptno) {
		ArrayList<Employee> datas=null;
		try {
			datas=EmployeeDAO.getDeptnoEmployee(deptno);
			if(datas.size()!=0) {
			SuccessView.print(deptno+"부서에 속한 사람들입니다.",datas);
			}else {
				SuccessView.printMsg(deptno+"에 속한 직원은 현 시점엔 미존재");
			}

		} catch (Exception e) { //db 접속등의 문제 발생 시 실행
			e.printStackTrace();
			FailView.print(deptno+" 번호의 부서 검색을 재요청 해주세요");
		}
	}

}
