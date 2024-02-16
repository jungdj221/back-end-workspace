package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class LoginController implements Controller{

	@Override  // 비즈니스 로직 부분
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼값
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = null;

		member = dao.login(id, password);

		if (member != null) {
			// 3. 바인딩 - session // 이 서버가 끝날때까지 session은 남아있음
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		}

		return new ModelAndView("views/login_result.jsp", true);
	}

}
