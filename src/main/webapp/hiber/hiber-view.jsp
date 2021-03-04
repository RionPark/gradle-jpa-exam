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

<c:if test="${result ne null}">
<script>
	var result = ${result};
	if(result==1){
		alert('삭제되었습니다.');
		location.href='/hiber-info/hiber-list';
	}else{
		alert('삭제가 실패하였습니다.');
	}
</script>
</c:if>
<form method="post" action="/hiber-info/delete">
	<input type="hidden" name="hiNum" value="${hi.hiNum}">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>${hi.hiNum}</th>
		</tr>
		<tr>
			<th>ID</th>
			<th>${hi.hiId}</th>
		</tr>
		<tr>
			<th>이름</th>
			<th>${hi.hiName}</th>
		</tr>
		<tr>
			<th colspan="2"><button type="button" onclick="location.href='/hiber-info/hiber-update?hiNum=${hi.hiNum}'">수정</button> <button>삭제</button></th>
		</tr>
	</table>
</form>
</body>
</html>