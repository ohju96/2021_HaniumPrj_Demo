<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>

body {
text-align :center;
}
</style>
</head>
<body>
	<h1> 비밀번호 찾기 </h1>
	등록하신 아이디를 입력해주세요 
	<form action ="/Projects/Search.do">
	<br>
	<div>
	ID : <input type="email" name=toMail></input>
	</div>
	<br>
	<input type="submit" value="찾기"></input>
	</form>
</body>
</html>