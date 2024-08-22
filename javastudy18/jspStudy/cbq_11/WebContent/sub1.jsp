<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	ShopDao dao = new ShopDao();
int custno = dao.getCustno();
%>
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
	padding: 20px;
}

footer {
	padding: 20px 0;
	background: #0cd;
}

footer p {
	text-align: center;
	color: #fff
}

table, th, td {
	border: 1px, solid, #ccc;
}

table {
	margin: 0 auto;
	width: 700px;
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
		<h2>홈쇼핑 회원 등록</h2>
		<form name="my" method="post" action="sub1pro.jsp">
			<table>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="<%=custno%>"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" style="width: 200px"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" style="width: 250px"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" value="전송"><input type="reset" value="다시쓰기"></td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy; 2016 All rights reserved. Human
			Resources Development Service of Korea.</p>
	</footer>
</body>
</html>