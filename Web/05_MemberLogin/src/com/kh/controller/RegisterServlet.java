package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);
		
		// 바인딩
		int result = 0;
		try {
			result = dao.register(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//request.setAttribute("name", name);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
