<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="hiName"><br>
<input type="text" id="hiId"><br>
<button onclick="updateWithAjax()">수정</button>
<button onclick="deleteWithAjax()">삭제</button>
<script>
function updateWithAjax(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/ajax-hiber/update');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			if(res.result){
				alert('수정 완료');
				location.href='/ajax/hiber-list.jsp';
			}else{
				alert('수정 실패');
			}
		}
	}
	xhr.setRequestHeader('Content-Type','application/json;charset=UTF-8');
	var param = {
			hiNum : ${param.hiNum},
			hiName : document.querySelector('#hiName').value,
			hiId : document.querySelector('#hiId').value
	}
	param = JSON.stringify(param);
	xhr.send(param);
}
function deleteWithAjax(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/ajax-hiber/delete');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			if(res.result){
				alert('삭제 완료');
				location.href='/ajax/hiber-list.jsp';
			}else{
				alert('삭제 실패');
			}
		}
	}
	xhr.setRequestHeader('Content-Type','application/json;charset=UTF-8');
	var param = {
			hiNum : ${param.hiNum}
	}
	param = JSON.stringify(param);
	xhr.send(param);
}
window.onload = function(){
	var hiNum = ${param.hiNum};
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax-hiber/view?hiNum=' + hiNum);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			document.querySelector('#hiName').value = res.hiName;
			document.querySelector('#hiId').value = res.hiId;
		}
	}
	xhr.send();
}
</script>
</body>
</html>