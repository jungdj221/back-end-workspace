
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
	
	<h1>회원 검색 결과</h1>
	<ul>
		<li>아이디 : ${member.id}</li>
		<li>비밀번호 : ${member.password}</li>
		<li>유저명 : ${member.name}</li>		
	</ul>
	<a href="index.jsp">메인화면으로 돌아가기</a>
	
	
</body>
</html>