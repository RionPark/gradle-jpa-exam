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
		alert('수정이 성공하였습니다.');
		location.href='/hiber-info/hiber-list';
	}else{
		alert('수정이 실패하였습니다.');
	}
</script>
</c:if>
<form method="post" action="/hiber-info/update">
	<input type="text" name="hiNum" placeholder="번호" value="${hi.hiNum}" readonly><br>
	<input type="text" name="hiName" placeholder="이름" value="${hi.hiName}"><br>
	<input type="text" name="hiId" placeholder="아이디" value="${hi.hiId}"><br>
	<button>수정</button>
</form>
</body>
</html>