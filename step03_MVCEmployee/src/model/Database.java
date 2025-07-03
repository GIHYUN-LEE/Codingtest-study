/* 용도
 * - Person 데이터를 제공하는 Database 기능의 클래스
 * - client가 요청전에 이미 데이터는 구축되어야 하는 상황
 * - 기능 : 데이터 초기화(db 관점에선 insert) / 모든 데이터 반환(db 관점에선 select)
 */

package model;

import model.domain.Employee;

public class Database {
	private static Employee[] p = new Employee[3];  //배열의 경우 크기를 지정해서 메모리를 할당해줘야함 크기커서 NULL 나오면 에러뜸
	
	static { //다르게 선언할 수 있음
		p[0] = new Employee(1,"이기현",154);
		p[1] = new Employee(2,"신준수",89);
		p[2] = new Employee(3,"신기범",456);
		
		}

	Employee[] getEmployees() {
		return p;   
	}
}