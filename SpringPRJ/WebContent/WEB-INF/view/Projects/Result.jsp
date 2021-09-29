<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
text-align :center;
}
</style>
</head>
<body>
 <form action="/mail/sendMail.do">
<div>
<h3>해당하는 아이디와 임시 비밀번호를 받을 메일주소를 입력하세요</h3>
ID : <input type="email" name ="id"></input>
Email : <input type="email" name ="toMail"></input>
</div>
<br>
<input type="submit"></input>
 </form>
 
</body>
</html>