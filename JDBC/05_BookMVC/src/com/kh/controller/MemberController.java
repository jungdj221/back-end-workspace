package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

import config.Serverinfo;

public class MemberController {

	public MemberController(){
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
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	
	
	// 4. 회원등록
	public int registerMember(Member m) throws SQLException {
		Connection conn = getConnect();
		
		
		if(!idCheck(m.getId())) {// idCheck의 값과 등록하고자하는 값이 다르면
			String query = "INSERT INTO tb_member(member_id, member_pwd, member_name) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			int result = ps.executeUpdate();
			closeAll(ps, conn);
			return result;
		}
		return -1;
		
	}
	
	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT member_id FROM tb_member WHERE member_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		String duplicatedId = null;
		if(rs.next()) duplicatedId = rs.getString("member_id"); // 기존의 리스트있는 아이디 하나씩 가져오기
		closeAll(rs, ps, conn);
		
		if(duplicatedId!=null) return true; // 중복비교를 위한 임시 아이디담아두는 곳이 채워져있으면 true
		return false;
	}
	
	// 5. 로그인
	public String login(String id, String pwd) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT member_id, member_pwd, member_name FROM tb_member WHERE member_id=? AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		
		String name = null;
		if(rs.next()) name = rs.getString("member_name");
		closeAll(rs, ps, conn);
		return name;
	}
}
