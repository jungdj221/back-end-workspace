<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원목록</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
	<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.id}</td>
			<td>${member.password}</td>
			<td>${member.name} </td>
		</tr>
	</c:forEach>

	</table>

	<a href="index.jsp">메인화면으로 돌아가기</a>
</body>
</html>