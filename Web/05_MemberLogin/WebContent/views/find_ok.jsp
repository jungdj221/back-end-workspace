
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
	Member info = (Member) request.getAttribute("member");
	%>
	<h1>회원 검색 결과</h1>
	<ul>
		<li>아이디 : <%= info.getId()%></li>
		<li>비밀번호 : <%= info.getPassword() %></li>
		<li>유저명 : <%= info.getName() %></li>		
	</ul>
	<a href="index.jsp">메인화면으로 돌아가기</a>
	
	
</body> 
</html>