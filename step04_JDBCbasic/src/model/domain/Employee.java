/*
 * 1. data 표현용 클래스(Value Object[VO])
 * 2. 화면단, controller단, model(biz)단 주고 받는 객체
 * 3. 명명규칙
 * 		Employee.java / EmployeeDTO.java / EmployeeVO.java
 * 		EmployeeBean.java
 * 4. 참고
 * 		bean 용어에 대한 히스토리
 * 		구 sun에서 멤버변수, 기본 생성자, 생성자, getter, setter,
 * 		toString() 이 형식으로 구성된 클래스를 java bean이라 했음
 * 
 * 
 */
package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // 모든 멤버 변수값을 겨합해서 하나의 문자열로 반환(재정의)
public class Employee {
	private int empno;
	private String ename;
	private int deptno;
}