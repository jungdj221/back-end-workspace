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


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		

		//Member member = new Member(name);
		
		// DAO
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.searchMember(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// 바인딩
		request.setAttribute("info", member);
		
		// 네비게이션 - 보내야 할 바인딩 정보가 있으면 Dispatcher
		// 만약에 멤버 정보가 없으면 추가
		if(member !=null) {
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
		
		
	}

}
