<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>

body {
text-align :center;
}
</style>
</head>
<body>

<h1>LOGIN</h1>
<form action="/Projects/index.do">
<div>
ID : <input type="email" name ="id"></input>
</div>
<br>
<div>
PW : <input type="password" name ="pwd"></input>
</div>
<br>
<div>
<input type="submit" value="Login"></input>
</div>
</form>
<br>
<form action="/Projects/Join.do">
<div>
<input type="submit" value="Join"></input>
</div>
<br>
</form>
<form action="/Projects/Forgot.do">
<div>

<input type="submit" value="PW/FORGOT"></input>
</div>
</form>
</body>
</html>