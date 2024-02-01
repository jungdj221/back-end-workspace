package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.Serverinfo;

public class DBConnectionTest4 {

	
	
	public static void main(String[] args) {

		
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			
			
			// 1. 드라이버로딩
			Class.forName(Serverinfo.DRIVER_NAME);
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
			System.out.println("DB 연결성공!");
			
			// 3. 쿼리준비 - DELETE
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. 쿼리문 실행
			ps.setInt(1, 900);
			
			System.out.println(ps.executeUpdate() + "명 삭제");
			
			
		} catch (Exception e ) {
			e.printStackTrace();
		} 
	
		
	}

}

/*
 * 오늘 쓴 쿼리문
 * 
CREATE TABLE employee_copy
SELECT * FROM employee; 

INSERT INTO employee_copy(emp_id, emp_name, emp_no)
VALUES(900, "테스트", "000000-0000000");

SELECT * FROM employee_copy;

UPDATE employee_copy SET emp_name = "테스트 02" WHERE emp_id = 900;
SET AUTOCOMMIT = 1;

DELETE FROM employee_copy WHERE emp_id = 900;
 * */



