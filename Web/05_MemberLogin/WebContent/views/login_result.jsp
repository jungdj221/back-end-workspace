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
	Member info =(Member) request.getAttribute("info");
	%>
	<h1><%=info.getName() %>님 환영합니다.</h1>
</body>
</html>