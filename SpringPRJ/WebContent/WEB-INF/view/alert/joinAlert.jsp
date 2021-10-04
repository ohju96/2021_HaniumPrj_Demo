<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%
String jspRes = CmmUtil.nvl((String)request.getAttribute("res"), "0");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllForYou</title>
</head>
<body>
<% 
if (jspRes.equals("1")){
%>		
	<script>
	alert('회원가입에 성공하였습니다.')
	document.location.href="/user/login.do"
	</script>

<% 
} else{
%>
	<script>
	alert('회원가입에 실패하였습니다. 정보를 다시 확인해주세요.')
	document.location.href="/user/login.do"
	</script>
<%
}
%>	

</body>
</html>