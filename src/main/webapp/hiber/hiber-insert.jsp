<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
신규저장 : hiber-insert.jsp
리스트 : hiber-list.jsp
뷰화면 : hiber-view.jsp
수정화면 : hiber-update.jsp
삭제화면 : 삭제화면은 따로 필요 없고 뷰화면에 삭제 버튼 있으면됩니다.

 -->
<form method="post" action="/hiber-info">
	<input type="text" name="hiNum" placeholder="번호"><br>
	<input type="text" name="hiName" placeholder="이름"><br>
	<input type="text" name="hiId" placeholder="아이디"><br>
	<button>저장</button>
</form>
</body>
</html>