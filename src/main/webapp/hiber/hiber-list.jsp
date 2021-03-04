<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>ID</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="hi">
		<tr onclick="location.href='/hiber-info/hiber-view?hiNum=${hi.hiNum}'" style="cursor:pointer">
			<td>${hi.hiNum}</td>
			<td>${hi.hiId}</td>
			<td>${hi.hiName}</td>
		</tr>
	</c:forEach>
	</tbody>	
</table>
</body>
</html>