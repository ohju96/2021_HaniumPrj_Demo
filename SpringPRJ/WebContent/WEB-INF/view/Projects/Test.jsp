<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="static poly.util.CmmUtil.nvl" %>
<%  
 String name = nvl((String)request.getAttribute("name"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
 <% for(int i=0; i<3; i++) { %>
 
 <% for(int b=0; b<4; b++) { %>
 <td> <%=i %> 행 <%=b %>열 </td>
 <% if( b == 3){ %>
 </tr>
 <%} %>
 <%} %>
 <%} %>
 </table>
안녕하세요 <%= name %>님
 
</body>
</html>