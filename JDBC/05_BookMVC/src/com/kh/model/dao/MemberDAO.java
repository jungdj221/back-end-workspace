package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.vo.Member;

public class MemberDAO {

	public MemberDAO(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		close(ps, conn);
	}
	
	public int registerMember(String id, String pwd, String name) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_member(member_id, member_pwd, member_name) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
	}

	public Member login(String id, String pwd) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_member WHERE member_id=? AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		Member m = new Member();
		if (rs.next()) {
			m.setMemberId(rs.getString("member_id"));
			m.setMemberPwd(rs.getString("member_pwd"));
			m.setMemberName(rs.getString("member_name"));
			m.setMemberNo(rs.getInt("member_no"));
			m.setStatus(rs.getString("status"));
		}
		return m;
		
	}

	// 회원탈퇴
	public int deleteMember(int no) throws SQLException {
		Connection conn = getConnect(); // 회원탈퇴시 Y
		String query = "UPDATE tb_member SET status='Y' WHERE member_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;

	}
}
