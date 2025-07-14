package step01.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtill;

public class JDBCDept2PropertiesLab {
	
	public static void selectOracle() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtill.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept");
			
			while( rs.next() ) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) 
									+ " " + rs.getString(3));
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally { 
			DBUtill.close(conn, stmt, rs);
		}
		
	}

	public static void selectMySQL() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtill.getConnection();
			
			stmt = conn.createStatement();			
			rs = stmt.executeQuery("select * from dept");
			
			while( rs.next() ) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) 
									+ " " + rs.getString(3));
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {  
			DBUtill.close(conn, stmt, rs);
		}
		
	}

	public static void insertMySQL() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtill.getConnection();
			
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("insert into dept values (60, '교육부', '상암')");
			System.out.println(result + "행 저장");
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {  
			DBUtill.close(conn, stmt);
		}
	}
	public static void insertOracle() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtill.getConnection();
			
			stmt = conn.createStatement();
			int result 
			= stmt.executeUpdate("insert into dept values (61, '교육부', '상암')");
			System.out.println(result + "행 저장");
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {  
			DBUtill.close(conn, stmt);
		}
	}
	
	public static void main(String[] args) {
		//insertMySQL();  //pk중복 안 되는 데이터로 test 하셔야 합니다.
//		selectMySQL();
		
		selectOracle();
//		insertOracle();
//		System.out.println("저장 후 *****");
//		selectOracle();
	}

}