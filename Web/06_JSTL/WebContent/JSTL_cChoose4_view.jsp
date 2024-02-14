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
<!-- 주석이 c:choose 안에 있을 경우 오류날 수 있음 -->
<!-- eq 랑 == 는 같은 뜻 -->
	<c:choose >
		<c:when test="${param.num eq '1'}">
			안녕하세요
		</c:when>
		<c:when test="${param.num eq '2'}">
			처음뵙겠습니다.
		</c:when>
		<c:otherwise>
			모르는 사람입니다. 비둘기
		</c:otherwise>
	</c:choose>
</body>
</html>