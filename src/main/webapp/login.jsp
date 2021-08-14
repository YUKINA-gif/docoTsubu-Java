<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>ログイン</h1>
	
	<form action="/docoTsubu/Login" method= "post">
		<label>ユーザー名:</label>
		<input type="text" name="name"><br>
		<label>パスワード:</label>
		<input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>