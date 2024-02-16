package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 공장 기계 역할. 즉, 틀
public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
