/* 모든 DAO 클래스들이 공통으로 사용하는 클래스임
 * - DAO 권장 설계 : 테이블 당 1대1 개발
 * - DBUtill 생성자도 private으로 객체 생성 금지 설정 권장
 * 
 * 24시간 365일 실행되는 서버의 실행 코드라 간주
 * - 요청 수와 무관하게 최초 단 한번만 1회성으로 공유 자원 초기화 하는 공통 코드로 간주
 * - db의 driver 로징 로직
 * - 시스템 다운 방지를 위한 리소스 최적화
 *   : Connection 수는 절대 제한(유한 자원)
 *   - web server 내부에서 설정으로 db server 시스템 동시 접속수 제어 예정
 *   - connection pool 기법 (CP)
 *   - Connection 제공, 회수하는 주체 필요(javax.sql.DataSource가 할 예정)
 *   
 *   결론
 *   	- driver 로딩 한번만 실행 보장
 *   	- Connection 객체 반환하는 로직
 *   	- DB 설정 정보는 별도의 key로 db 접속 정보 매핑해서 properties 파일로 분리
 *   		: key는 절대 중복되어서는 안된다.
 *   - 참고 
 *   	: 설정 정보를 코드에서 분리하는 우너조가 JDBC라고 간주
 *   	- Spring 에서 default 설정 파일
 *   
 */


package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.sql.Statement;

//properties 파일에서 key로 value만 쏙쏙 뽑는 기능
import java.util.Properties;



public class DBUtill {
	// key로 value값 활용시에만 사용하는 API
	private static Properties dbInfo  = new Properties();
	
	private DBUtill() {} //DBUtill의 생성자를 private으로 막아서 인스턴스 생성 막음
	
	Connection conn = null; // DB연결 정보
	ResultSet rs = null; // 실행 결과 저장
	Statement stmt = null; // 쿼리 실행

	static { // static 블럭 클래스 로드 시 한번 실행
				
		try {
			dbInfo.load(new FileInputStream("dbinfo.properties"));
			/* FileInputStream : db info의 프로퍼티를 스트림으로 읽음
			 * load : 파일 내용을 프로퍼티의 키-값 구조로 파싱
			 */
			Class.forName(dbInfo.getProperty("jdbc.driver")); // 드라이버를 JVM에 로드
			
		}catch(Exception e){ // 예외 종류 명시안하면 모든 예외
			e.printStackTrace();
		}
	}

	
	
	public static Connection getConnection() throws SQLException { //throws SQLException은 예외처리를 호출한 곳으로 책임전가
		return  DriverManager.getConnection(dbInfo.getProperty("jdbc.url"),dbInfo.getProperty("jdbc.id") ,dbInfo.getProperty("jdbc.pw") );
		// DB 연결을 생성해서 반환하는 개체
	}
	/* 자원 반환 필수 (query)
	 * - 자원을 해제하지 않으면 커넥션 풀 고갈 등 성능과 안정성이 떨어진다.
	 * - 해제 순서 : resultset -> statement -> connection 순서로 닫는다
	 * - connection, statement, resultset 의 경우는 조회쿼리(select)
	 * - connection, statement는 insert, update, delete 
	 * 
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {    
				rs.close();
				rs = null;
			}

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//자원 반환 필수(Insert, update/ delete)
	
	//자원 반환 필수 (query)
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println();
	}
}