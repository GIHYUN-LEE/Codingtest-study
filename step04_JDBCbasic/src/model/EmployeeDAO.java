/*
 * employee table과 1:1 매핑되는 DB연동 전담 클래스
 * crud
 * Data Access Object[DA0] pattern
 * 
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.domain.Employee;
import util.DBUtill;
import view.FailView;
import view.SuccessView;

public class EmployeeDAO {
	
	private static EmployeeDAO model = new EmployeeDAO();
	
//	private EmployeeDAO() {} 
	
	public static EmployeeDAO getModel() {
		return model;
	}
	
	
	/* 브라우저에 입력한 데이터 -> controller -> DAO -> DB
	 * 방법1 : int empno, String ename, int deptno 데이터 전송해서 저장
	 * 방법2 : int empno, String ename, int deptno 데이터 받아서 Employee 객체 생성 후 DAO에게 insert
	 * 
	 * Spring의 자동 완성 기능
	 * - 사용자가 브라우저로 입력하는 데이터를 Controller의 메소드에서 받을 때,
	 *   : Employee 객체 처럼 자동 객체화 수행 : 42번줄
	 */
	
	
//	public static void insertOracle(Employee emp) {}
	public static boolean insertOracle(Employee emp) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBUtill.getConnection();
			pstmt=conn.prepareStatement("insert into employee values(?,?,?)");
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setInt(3, emp.getDeptno());
			
			int result=pstmt.executeUpdate();
			
			if(result==1) {
				return true;
			}
		} finally { // finally는 무조건 실행
			DBUtill.close(conn, pstmt);
		}
		return false;
	}
	
	public static boolean updateOracle(int deptno, int empno) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBUtill.getConnection();
			pstmt=conn.prepareStatement("update employee set deptno=? where empno=?");
			
			pstmt.setInt(1, deptno);
			pstmt.setInt(2, empno);
			
			int result=pstmt.executeUpdate();
			
			if(result==1) {
				return true;
			}
		} finally { // finally는 무조건 실행
			DBUtill.close(conn, pstmt);
		}
		return false;
	}
	
	
	
	/*
	 * 모든 직원 정보 반환
	 * - 가변적인 직원수
	 * - 직원별 1:1 Employee 객체 생성
	 * - 모든 직원인 모든 Employee 객체를 한번에 반환 : ArraryList? 배열?
	 * - select * from employee 
	 * 		empno/ename/deptno
	 */
		
	public ArrayList<Employee> getEmployees() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Employee> all = null;
		
		
		try {
			conn = DBUtill.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");
			
			all = new ArrayList<>();//10개씩 메모리 증가하는 동적 메모리 todtjd
			
			
			while(rs.next()) {
				all.add(new Employee(rs.getInt("empno"), rs.getString("ename"),rs.getInt("deptno")));
			
			}
			
		}finally {
			DBUtill.close(conn, stmt, rs);
		}
		return all;
		
	}
	
	@Test // public 생성자 필요 ,private 생성자 주석 처리했음
	public void test(){
		try {
		System.out.println(getEmployees());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//특정 부서에 속한 사원들만 검색해서 반환
//	public Employee[] getSameDeptEmployees(int deptno) throws Exception {//trows 코드가 내부에 있다면 무조건 명시행한다.!!!
//		//모든 직원 정보 획득
//		Employee[] emps = db.getEmployees();
//		
//		//해당 부서에 속한 직원 정보만 저장하기 위한 배열을 생성하기 위해서 직원수 count
//		int count = 0;
//		for(Employee emp : emps) {
//			if(emp.getDeptno() == deptno) {//==: 기본 데이터의 경우 동등 비교 연산자
//				count++;				
//			}
//		}//해당 부서에 속한 직원 수 파악
//		
//		
//		//직원이 부서에 소속된 직원이 존재하지 않을경우 명시적으로 에외 발생
//		//deptno + "부서에 소속된 사원이 미 존재합니다."
//		if(count==0) {
//			throw new Exception(deptno + "부서에 소속된 사원이 미 존재합니다.");		
//		}
//		
//		int index = 0;
//		Employee[] sameDeptno = new Employee[count];//직원수 만큼 배열 생성
//		//
//		for(Employee emp : emps) {
//			if(emp.getDeptno() == deptno) {
//				sameDeptno[index] = emp; //부서 번호가 동일한 직원객체 배열에 저장
//				index++;
//			}
//		}
//		return sameDeptno; //해당 직원만 저장된 배열 반환
//	}
//}

	
	public static ArrayList<Employee> getDeptnoEmployee(int deptno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Employee> all = null;
		
		
		try {
			conn = DBUtill.getConnection();
			
			//select만 가능한 객체 생성
			pstmt = conn.prepareStatement("select * from employee where deptno=?");
			pstmt.setInt(1, deptno);  //첫번째 물음표에 deptno값 대입 의미
			rs = pstmt.executeQuery(); // 실제 DB에 select 수행
			
			all = new ArrayList<>();//10개씩 메모리 증가하는 동적 메모리 todtjd
			
			
			while(rs.next()) {
				all.add(new Employee(rs.getInt("empno"), rs.getString("ename"),rs.getInt("deptno")));
			
			}
			
		}finally {
			DBUtill.close(conn, pstmt, rs);
		}
		return all;
	}
	
	
	
	
}