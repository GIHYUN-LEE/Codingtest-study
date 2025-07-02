/* 용도
 * - Person 데이터를 제공하는 Database 기능의 클래스
 * - client가 요청전에 이미 데이터는 구축되어야 하는 상황
 * - 기능 : 데이터 초기화(db 관점에선 insert) / 모든 데이터 반환(db 관점에선 select)
 */

package model;

import model.domain.Person;

public class Database {
	private static Person p;  // 실체화되는 시점 : 객체 생성 시점, 선언만 하고 초기화는 나중에 해도됨
	                          // class를 public으로 열고 객체 안을 private으로 가리는 편임
	
	static {
		p=new Person("tester",11); //static은 byte code가 메모리에 로딩될때 읽혀지는 시점에 실행 -> main에 가기전에 실행된다? 제일 빨리 실행된다?
	}
	
	//검색 로직이라 가정하세요
	Person getPersons() {   // Person(=반환형식) getPersons(=함수명)
		return p;
	}
}
