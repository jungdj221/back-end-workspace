package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";
	
	public static void main(String[] args) {

		
		
		try {
			// 1. 드라이버로딩
			Class.forName(DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결성공!");
			
			// 3. 쿼리준비 - insert
			String query = "INSERT INTO employee_copy(emp_id, emp_name, emp_no) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. 쿼리문 실행
			ps.setInt(1, 700);
			ps.setString(2, "정동준");
			ps.setString(3, "000000-0000000");
			
			System.out.println(ps.executeUpdate() + "명 추가");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결실패");
			e.printStackTrace();
		}
		
	
		
	}

}
