<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str = "123";
request.setAttribute("str", "나나");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
el태그를 사용한 request의 str : ${str}<br>
request.getParameter의 param : <%=request.getParameter("test")%><br>
el태그를 사용한 param의 test : ${param.test} <br>
el태그를 사용한 request의 test : ${test}
</body>
</html>