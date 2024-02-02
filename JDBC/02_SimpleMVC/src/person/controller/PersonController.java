package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Serverinfo;
import person.model.Person;

public class PersonController {
	
	Person p = new Person();
	
	public PersonController() {
		// 드라이버 로딩을 딱 한번만
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("드라이버로딩");
	}
	
	// 고정적으로 반복 -- DB연결, 자원 반납 -> 공통적인 메서드 정의 -> 매서드마다 호출해서 사용
	// DB 연결
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
		System.out.println("DB 연결");
		return conn;
	}
	
	// 5. 자원반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close(); // 쿼리문 연결 반납
		conn.close(); // DB연결 반납
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	// person 테이블에 추가
	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect();
		// 쿼리문 -> PreparedStatement
		String query = "INSERT INTO person VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
	}
	
	// person 테이블에서 데이터 수정
	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();
		
		String query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, address);
		ps.setInt(2, id);

		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
	}
	
	// person 테이블에서 데이터 삭제
	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();
		
		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		
		int result = ps.executeUpdate();
		
		closeAll(ps, conn);
		return result;
	}
	
	// person 테이블에 있는 데이터 전체 보여주기
	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> personList = new ArrayList<>();
		
		while (rs.next()) {
			// 생성자 방식
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String address = rs.getString("address");

			personList.add(new Person(id, name , address));
//			personList.add(new Person(rs.getInt("id"), rs.getString("name") , rs.getString("address")));
			// 이렇게 해도 됨.
			
			// setter 방식
//			Person person = new Person();
//			person.setId(rs.getInt(id));
//			person.setName(rs.getString(name));
//			person.setAddress(rs.getString(address));
//			personList.add(person);
		}
		
		closeAll(rs, ps, conn);
		return personList;
		
	}
	
	// person 테이블에 데이터 한개만 가져오기
	public Person searchPerson(int id) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
	
		ps.setInt(1, id);
		
		Person person = null;
		// 실행
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			person = new Person(rs.getInt("id"), 
								rs.getString("name"),
								rs.getString("address"));
		}
		closeAll(rs, ps, conn);
		return person;
		}

	
	
}
