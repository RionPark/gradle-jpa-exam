<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="hiName" placeholder="이름"><br>
	<input type="text" id="hiId" placeholder="ID"><br>
	<button onclick="saveWithAjax()">저장</button>
<script>
window.onload = function(){
	document.querySelector('#hiName').focus();
}
function saveWithAjax(){
	var hiName = document.querySelector('#hiName');
	if(hiName.value.trim().length<2){
		alert('이름은 2글자 이상입니다.');
		hiName.focus();
		return;
	}
	var hiId = document.querySelector('#hiId');
	if(hiId.value.trim().length<4){
		alert('아이디는 4글자 이상입니다.');
		hiId.focus();
		return;
	}
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/ajax-hiber/insert');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			if(res.result>0){
				alert('저장이 완료되었습니다.');
				location.href = '/ajax/hiber-list.jsp';
			}else{
				alert('저장이 실패하였습니다.');
			}
		}
	}
	xhr.setRequestHeader('Content-Type','application/json;charset=UTF-8');
	var param = {
			hiName : hiName.value,
			hiId : hiId.value
	}
	param = JSON.stringify(param);
	xhr.send(param);
}
</script>
</body>
</html>