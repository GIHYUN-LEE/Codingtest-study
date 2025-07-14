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
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.Test;
import model.domain.Employee;
import util.DBUtill;
public class EmployeeDAO {
	
	private static EmployeeDAO model = new EmployeeDAO();
	
//	private EployeeDA0() {}
	
	public static EmployeeDAO getModel() {
		return model;
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
			
			
			pstmt=conn.prepareStatement("select * from employee where deptno=?");
			pstmt.setInt(1,deptno);  // 첫번째 물음표에 deptno값 대입을 의미
			rs=pstmt.executeQuery("select * from employee");
			
			
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
	
	public static ArrayList<Employee> getDeptnoEmployee(int i) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Employee> all = null;
		
		
		try {
			conn = DBUtill.getConnection();
			pstmt = conn.????();
			rs =pstmt.executeQuery("select * from employee");
			
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