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
<title>Insert title here</title>
<!-- 컨트롤러에서 바로 삭제된 페이지 jps를 띄우지지 않고 알러트 jsp로 보내서 알람을 띄우준 뒤 보내준다. -->
</head>
<body>
<% 
if (jspRes.equals("1")){
%>		
	<script>
	alert('댓글이 삭제되었습니다.')
	document.location.href="/community/boardlist.do"
	</script>

<% 
} else{
%>
	<script>
	alert('삭제 요청에 실패하였습니다. 관리자에게 문의해주세요')
	document.location.href="/community/boardlist.do"
	</script>
<%
}
%>	
</body>
</html>