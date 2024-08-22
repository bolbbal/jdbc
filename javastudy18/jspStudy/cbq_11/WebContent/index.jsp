<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원 관리</title>
<style>
* {
	padding: 0;
	margin: 0;
}

header {
	background: #00f;
	padding-top: 12px;
	padding-bottom: 12px;
}

h1 {
	color: #fff;
	text-align: center;
}

a {
	color: #fff;
	display: inline-block;
	padding: 6px 12px;
	text-decoration: none;
}

nav {
	background: #0cf;
}

section {
	background: #ddd;
	height: 500px
}

h2 {
	text-align: center;
}

footer {
	padding: 20px 0;
	background: #0cd;
}

footer p {
	text-align: center;
	color: #fff
}
</style>
</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리 ver 1.0</h1>
	</header>
	<nav>
		<a href="sub1.jsp">회원등록</a> <a href="sub2.jsp">회원목록조회/수정</a> <a
			href="sub3.jsp">회원매출조회</a> <a href="index.jsp">홈으로</a>
	</nav>
	<section>
		<h2>쇼핑몰 회원관리 프로그램</h2>
		<p>쇼핑몰..</p>
		<p>프로그램 작성 순서</p>
		<p>1.</p>
		<p>2.</p>
		<p>3.</p>
		<p>4.</p>
		<p>5.</p>
		<p>6.</p>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy; 2016 All rights reserved. Human
			Resources Development Service of Korea.</p>
	</footer>
</body>
</html>