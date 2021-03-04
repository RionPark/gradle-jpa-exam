<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="miId" placeholder="아이디"><br>
<input type="password" id="miPwd" placeholder="비번"><br>
<input type="number" id="miAge" placeholder="나이"><br>
<input type="text" id="miName" placeholder="이름"><br>
<input type="text" id="miInfo" placeholder="소개"><br>
<button onclick="saveMemberInfo()">회원등록</button>
<script>
function saveMemberInfo(){
	//validation필수!!
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/member-info/insert');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			if(res.result){
				alert('회원등록 성공');
				location.href='/member/member-list.jsp';
			}else{
				alert('회원등록 실패');
			}
		}
	}
	var param = {
			miId : document.querySelector('#miId').value,
			miPwd : document.querySelector('#miPwd').value,
			miAge : document.querySelector('#miAge').value,
			miName : document.querySelector('#miName').value,
			miInfo : document.querySelector('#miInfo').value
	}
	param = JSON.stringify(param);
	xhr.setRequestHeader('content-type','application/json;charset=UTF-8')
	xhr.send(param);
}
</script>
</body>
</html>