package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼값
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);

		dao.register(member);
		return new ModelAndView("index.jsp", true);
	}

}
