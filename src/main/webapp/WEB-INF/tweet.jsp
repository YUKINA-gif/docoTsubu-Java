<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% User loginUser = (User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tweet</title>
</head>
<body>
<% if(loginUser != null){ %>
	<h1>投稿一覧</h1>
	<p><%= loginUser.getName() %>さん、ログイン中</p>
	<a href="/docoTsubu/logout.jsp">ログアウト</a><br>
	<input type="text">
	<input type="submit" value="つぶやく">
<% } else { %>
	<p>ログインできませんでした</p>
	<a href="/docoTsubu/">TOPへ</a>
<% } %>
</body>
</html>