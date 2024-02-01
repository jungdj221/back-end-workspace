package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.Serverinfo;

public class DBConnectionTest3 {

	
	
	public static void main(String[] args) {

		
		
		try {
			// 1. 드라이버로딩
			Class.forName(Serverinfo.DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
			System.out.println("DB 연결성공!");
			
			// 3. 쿼리준비 - UPDATE
			String query = "UPDATE employee_copy SET emp_name = ? WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. 쿼리문 실행
			ps.setString(1, "비둘기");
			ps.setInt(2, 700);
			
			System.out.println(ps.executeUpdate() + "명 수정");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결실패");
			e.printStackTrace();
		}
		
	
		
	}

}
