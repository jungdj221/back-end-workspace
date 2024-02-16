<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	Member info =(Member) session.getAttribute("member");
		if(info!=null){%>
			<h1>로그인정보</h1>
			<ul>
				<li> 아이디 : <%= info.getId() %></li> 
				<li> 비밀번호 : <%= info.getPassword() %></li> 
				<li> 이름 : <%= info.getName() %></li> 
			</ul>
			<a href="/index.jsp">첫 페이지로 이동</a>
			
		<% }else{%>
			<h2>아이디나 비밀번호가 잘못되었습니다.</h2>
			<a href="Login.html">로그인 페이지로 이동</a>
		<%}%>
	
	 
	
	
</body>
</html>