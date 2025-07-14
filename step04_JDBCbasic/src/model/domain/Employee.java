/* DATA Transfer Object pattern(DTO 패턴)
 * 1. 데이터 표현용 클래스(Value Object[VO])
 * 2. 화면단, 컨트롤러단, 모델단 주고 받는 객체
 * 3. 명명규칙
 * 		Employee.java / EmployeeDTO.java / EmployeeVO.java
 * 4. 참고
 * 	   bean 용어에 대한 히스토리
 * 	   구sun에서 멤머변수, 기본생성자, 생성자, 게터세터, toString() 이 형식으로 구성된 클래스를 java bean이라고 함
 */


package model.domain;

import java.sql.PreparedStatement;

import controller.Connection;
import controller.ResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
	private int empno;
	private String ename;
	private int deptno;
}

public static void getDeptnoEmployee(int i) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	try {
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}


