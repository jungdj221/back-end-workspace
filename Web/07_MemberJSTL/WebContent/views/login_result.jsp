<%@page import="com.kh.model.vo.Member"%>
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
<%-- sessionScope.member도 마찬가지로 request가 없으므로 우선순위 걱정 없기에 그냥 not empty써도 됨. --%>
	<c:choose>
		<c:when test="${not empty member}">
			<h1>로그인정보</h1>
			<ul>
				<li>아이디 : ${member.id}</li>
				<li>비밀번호 : ${member.password}</li>
				<li>이름 : ${member.name}</li>
			</ul>
			<a href="/index.jsp">첫 페이지로 이동</a>
		</c:when>
		<c:otherwise>
			<h2>아이디나 비밀번호가 잘못되었습니다.</h2>
			<a href="Login.html">로그인 페이지로 이동</a>
		</c:otherwise>
	</c:choose>
</body>
</html>