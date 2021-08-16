<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Tweet,java.util.List" %>
<% 
	User loginUser = (User) session.getAttribute("loginUser"); 
	List<Tweet> tweetList = (List<Tweet>)application.getAttribute("tweetList");
	String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<% if(loginUser != null){ %>
	<h1>投稿一覧</h1>
	<p><%= loginUser.getName() %>さん、ログイン中</p>
	<a href="/docoTsubu/Main">更新</a>
	<a href="/docoTsubu/LogOut">ログアウト</a><br>
	<form action="/docoTsubu/Main" method="post">
		<input type="text" name="text">
		<input type="submit" value="つぶやく">
	</form>
	<% if(errorMsg != null) { %>
	<p><%= errorMsg %></p>
	<% } %>
	<% for(Tweet tweet : tweetList) { %>
	<p><%= tweet.getUserName() %>:<%= tweet.getText() %></p>
	<% } %>
<% } else { %>
	<p>ログインできませんでした</p>
	<a href="/docoTsubu/">TOPへ</a>
<% } %>
</body>
</html>