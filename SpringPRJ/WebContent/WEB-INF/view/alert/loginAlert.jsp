<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<!DOCTYPE html>
<html>
<% 
String user_id = (String)session.getAttribute("id"); 
String jspRes = CmmUtil.nvl((String)request.getAttribute("res"), "0");
%>
<head>
<meta charset="UTF-8">
<title>AllForYou</title>
</head>
<body>

<% 
if (jspRes.equals("1")){
%>		
	<script>
	alert('<%=user_id%> 님 로그인에 성공하였습니다.')
	document.location.href="/index.do"
	</script>

<% 
} else{
%>
	<script>
	alert('로그인에 실패하였습니다. ID,PW를 다시 확인해주세요.')
	document.location.href="/user/login.do"
	</script>
<%
}
%>
</body>
</html>