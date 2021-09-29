<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
body {
text-align :center;
}
</style>
</head>
<body>
<h1> JOIN </h1>
<form action="/Projects/insert.do">
<div>
ID :<input type="email" name="id"></input>
</div>
<br>
<div>
PW :<input type="password" name="pwd"></input>
</div>
<br>
<div>
NAME :<input type="text" name="name"></input>
</div>
<br>
<input type="submit" value="가입하기"></input>
</form>
</body>
</html>