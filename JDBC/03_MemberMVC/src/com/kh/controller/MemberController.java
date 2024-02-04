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
	
	public MemberController() {
		//Driver 로딩
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD2);
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	
	
	public boolean signUp(Member m) throws SQLException {
		// 회원가입 기능 구현 -> member 테이블에 추가(INSERT)
		//ArrayList<Member> signupList = new ArrayList<>();
		// 로그인 기능 구현이 먼저 되어야 함
		// login 메서드 활용해서 null이 아닐 때만 해당 코드 실행! 아니면 false만 리턴
		Connection conn = getConnect();
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, m.getId());
		ps.setString(2, m.getPassword());
		ps.setString(3, m.getName());
		
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		if(result == 1) return true;
		else return false;
		
		
	}
	
	public String login(String id, String password) throws SQLException {
		// 로그인 기능 구현 -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기(SELECT)
		Connection conn = getConnect();
		String query = "SELECT name FROM member WHERE id = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		
		
		
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		// 비밀번호 바꾸기 기능 구현
		// -> login 메사드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현
		// -> member 테이블에서 id와 password로 새로운 패스워드 변경(UPDATE)
		return false;
	}
	
	public void changeName(String id, String changeName) {
		// 이름 바꾸기 기능 구현
		// -> member 테이블에서 id로 새로운 이름으로 변경(UPDATE)
	}
}
