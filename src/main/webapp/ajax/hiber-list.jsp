<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
</head>
<body>
<button onclick="callWithAjax()">ajax 호출</button>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
<script>
function goPage(hiNum){
	location.href='/ajax/hiber-update.jsp?hiNum=' + hiNum;
}
/*
 * AJAX 
   Async : 비동기
   Javascript : 자바스크립트
   And : 와
   XML : xml
 */

function callWithAjax(){
	$.ajax({
		url : '/ajax-hiber/list',
		success : function(res){
			var html = ''; 
			for(var i=0;i<res.length;i++){
				var hi = res[i];
				html += '<tr onclick="goPage(' + hi.hiNum + ')">';
				html += '<td>' + hi.hiNum + '</td>';
				html += '<td>' + hi.hiId + '</td>';
				html += '<td>' + hi.hiName + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html; 
		}
	});
}
</script>
</body>
</html>