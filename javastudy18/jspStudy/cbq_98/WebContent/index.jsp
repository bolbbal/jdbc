<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고교성적관리</title>
<style>
header {
	background: #59c;
	padding: 1px;
}

h1 {
	color: #fff;
	text-align: center;
	padding: 6px
}

nav {
	background: #D8D;
	padding: 1px;
}

a {
	text-decoration: none;
	color: #25C;
	display: inline-block;
	padding: 2px 4px;
}

section {
	padding: 1px;
	background: #CCC;
	height:700px;
}

h2 {
	text-align: center;
	padding: 3px;
}

footer {
	background: #59c;
	padding: 1px;
}
footer p {
	text-align:center;
	padding:2px;
}
</style>
</head>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)고교성적관리프로그램 ver2019-06</h1>
	</header>
	<nav>
		<a href="sub1.jsp">학생등록</a> <a href="sub2.jsp">성적입력</a> <a
			href="sub3.jsp">성적조회</a> <a href="sub4.jsp">반별통계</a> <a
			href="index.jsp">홈으로</a>
	</nav>
	<section>
		<h2>과정평가형 자격 CBQ</h2>
		<p>국가직무능력표준(NCS:National Competency Standards)으로 설계된 교육훈련과정을 이수하고
			내.외부평가를 거쳐 취득하는 국가기술자격입니다</p>
		<p>산업현장 중심의 교육평가로 더 커지는 능력 !</p>
		<p>알고 있는 것에 할 수 있다는 것을 더하는</p>
		<p>과정평가형 자격은</p>
		<p>현장 중심형 인재육성을 지원합니다.</p>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy;2016 All rights reserve. Human
			Resources Development Service of Korea</p>
	</footer>
</body>
</html>