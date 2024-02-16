package com.kh.controller;

import com.kh.controller.component.FindMemberController;
import com.kh.controller.component.LoginController;
import com.kh.controller.component.LogoutController;
import com.kh.controller.component.RegisterController;
import com.kh.controller.component.allMemberController;

// Controller의 공장 역할
public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	// 싱글톤 패턴 - 특정 클래스의 객체가 오직 한 개만 존재하도록 하기 위해서
	private HandlerMapping() {}
	public static HandlerMapping getInstance(){
		return handler;
	};
	
	
	// controller 생성
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if(command.equals("login.do")) {
			controller = new LoginController();
		} else if(command.equals("allShow.do")) {
			controller = new allMemberController();
		} else if(command.equals("search.do")) {
			controller = new FindMemberController();
		} else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}
		
		return controller;
	}
	
}
