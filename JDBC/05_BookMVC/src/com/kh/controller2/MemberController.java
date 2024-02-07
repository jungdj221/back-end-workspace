package com.kh.controller2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberController {
	private MemberDAO dao = new MemberDAO();
	
	public boolean registerMember(String id, String pwd, String name){
		try {
			if(dao.registerMember(id, pwd, name)==1)
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Member login(String id, String pwd){
		Member member;
		try {
			member = dao.login(id, pwd);
			if (member.getStatus().equals("Y")) return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		 
	}
	
	public boolean deleteMember(int no){
		try {
			if(dao.deleteMember(no)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
