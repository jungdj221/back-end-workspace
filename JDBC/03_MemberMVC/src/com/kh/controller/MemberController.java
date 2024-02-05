package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Member;

import config.Serverinfo;

public class MemberController {
	Member m = new Member();
	
	// 드라이버 로딩은 생성자 생성할때 딱 한번만
	public MemberController() {
		//Driver 로딩
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
		return conn;
		// return DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD)
		// 통으로 return 하고 나중에 getConnect를 호출해도 됨.
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	
	
	public boolean signUp(Member m) throws SQLException {
		Connection conn = getConnect();
		// 회원가입 기능 구현 -> member 테이블에 추가(INSERT)
		// -> 아이디가 기존에 있는지 체크 여부
		//ArrayList<Member> signupList = new ArrayList<>();
		// 로그인 기능 구현이 먼저 되어야 함
		// login 메서드 활용해서 null이 아닐 때만 해당 코드 실행! 아니면 false만 리턴
		
		if(!idCheck(m.getId())) {
			
			String query = "INSERT INTO member VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			
			ps.executeUpdate(); // 얘가 있어야 query문이 실행됨.
			closeAll(ps, conn);
			return true;
		}
		return false;
		
		
	}
	
	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT id FROM member WHERE id=?";
		PreparedStatement ps = getConnect().prepareStatement(query);
		
		ps.setString(1, id);
	
		ResultSet rs = ps.executeQuery();
	
		String checkId = null;
		if(rs.next()) checkId = rs.getString("id");
		closeAll(rs, ps, conn);
		
		if(checkId!=null) return true;
		return false;
	}
	
	public String login(String id, String password) throws SQLException {
		// 로그인 기능 구현 -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기(SELECT)
		Connection conn = getConnect();
		String query = "SELECT name FROM member WHERE id = ? AND password = ?";
		PreparedStatement ps = getConnect().prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		String name = null;
		if(rs.next()) name = rs.getString("name");
		closeAll(rs, ps ,conn);
		return name;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		// 비밀번호 바꾸기 기능 구현
		// -> login 메사드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현
		// -> member 테이블에서 id와 password로 새로운 패스워드 변경(UPDATE)
		Connection conn = getConnect();
		PreparedStatement ps = null;
		boolean result = false;
		if(login(id, oldPw)!=null) {
			String query = "UPDATE member SET password = ? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPw);
			ps.setString(2, id);
			ps.executeUpdate();
			result = true;
		}
		closeAll(ps, conn);
		return result;
	}
	
	public void changeName(String id, String changeName) throws SQLException {
		// 이름 바꾸기 기능 구현
		// -> member 테이블에서 id로 새로운 이름으로 변경(UPDATE)
		Connection conn = getConnect();
		String query = "UPDATE member SET name=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, changeName);
		ps.setString(2, id);
		ps.executeUpdate();
		closeAll(ps, conn);
	}
}
