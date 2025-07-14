/* 학습내용 : 코드 정제 전 단순학습
 * 1. dept의 CRUD
 * 2. 코드 개발 단계
 *    - driver 로딩
 *    -> 접속(connection)
 *    -> SQL문장생성(Statement)
 *    -> SQL 문장 실행(executeQuery) or executeUpdate)
 *    -> 결과 활용
 *    -> 접속 해제(close, 자원반환)
 */
package step01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeptLab {
	// select 모든 dept 검색
	
	
	public static void selectOracle() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		// driver 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver 로딩 정상");
			// connection : DB종류, IP, ID/PW
			/*
			 * driver를 관리하는 API 자체가 존재 - DriverManager web server - web browser 통신 (http)
			 * java - RDBMS 통신 (jdbc)
			 *
			 */

			// 순수 자바로 해당 ip에서 실행중인 oracle db중에서 별칭인 xe에 접속
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(conn);
			// connection : DB종류, IP, ID/PW
			/*
			 * driver를 관리하는 API 자체가 존재 - DriverManager web server - web browser 통신 (http)
			 * java - RDBMS 통신 (jdbc)
			 *
			 */
			// statement
			stmt = conn.createStatement();
			System.out.println(stmt);

			// sql문장 실행 및 결과 활용

			rs = stmt.executeQuery("select * from dept");
			System.out.println(rs);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

		} catch (Exception e) { // 상위타입으로 선언, 하위타입 모두 가능한 catch
			e.printStackTrace();
		} finally {// 예외 발생 여부와 무관하게 100% 실행
			/*
			 * DB 연동 자원은 코드로 해제 필수 자원 해제 순서 - ResultSet -> Statement -> connection 순으로 해제
			 */
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 자원반환

	}

	public static void selectMySQL() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		// driver 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver 로딩 정상");
			String url = "jdbc:mysql://127.0.0.1:3306/fisa";
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println(conn);
			stmt = conn.createStatement();
			System.out.println(stmt);

			rs = stmt.executeQuery("select * from dept");
			System.out.println(rs);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

		} catch (Exception e) { // 상위타입으로 선언, 하위타입 모두 가능한 catch
			e.printStackTrace();
		} finally {// 예외 발생 여부와 무관하게 100% 실행
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

	}

	/*
	 * insert-접속, sql 문장 구성해서 실행 -> 자원반환 insert into dept values(60,'교육부','상암') ->
	 * 1행 저장 int executeUpdate("i/u/d"){} -> 저장된 행수 반환
	 */
	public static void insertMySQL() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/fisa";
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("insert into dept values(60,'교육부','상암')");
			System.out.println(result + "행 저장");

		} catch (Exception e) { // 상위타입으로 선언, 하위타입 모두 가능한 catch
			e.printStackTrace();
		} finally {// 예외 발생 여부와 무관하게 100% 실행
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

	}

	public static void insertOracle() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("insert into dept values(60,'교육부','상암')");
			System.out.println(result + "행 저장");

		} catch (Exception e) { // 상위타입으로 선언, 하위타입 모두 가능한 catch
			e.printStackTrace();
		} finally {// 예외 발생 여부와 무관하게 100% 실행
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

	}

	public static void main(String[] args) {
//		insertMySQL(); //pk 중복 안되는 데이터로 test
//		selectMySQL();
		selectOracle();
		insertOracle();
	}
}
// alt+shift+r 리네이밍
// 한영키