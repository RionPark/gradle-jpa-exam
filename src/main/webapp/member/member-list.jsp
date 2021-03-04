<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<th>회원번호</th>
			<th>회원이름</th>
			<th>회원아이디</th>
			<th>회원나이</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
<button onclick="location.href='/member/member-insert.jsp'">회원등록</button>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/member-info/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			console.log(res);
			var html = '';
			for(var i=0;i<res.length;i++){
				var memberInfo = res[i];
				html += '<tr>';
				html += '<td>' + memberInfo.miNum + '</td>';
				html += '<td>' + memberInfo.miName + '</td>';
				html += '<td>' + memberInfo.miId + '</td>';
				html += '<td>' + memberInfo.miAge + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}
</script>
</body>
</html>