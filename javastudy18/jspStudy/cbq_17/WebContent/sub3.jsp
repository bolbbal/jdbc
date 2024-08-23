<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	ShopDao dao = new ShopDao();
List<ShopVo> list = new ArrayList<ShopVo>();
list = dao.selectMemberPrice();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원 관리</title>
<style>
header {
	background: #48a;
	padding: 1px;
}

h1 {
	color: #fff;
	text-align: center;
	padding: 12px;
}

nav {
	background: #379;
	padding: 1px;
}

a {
	color: #fff;
	text-decoration: none;
	display: inline-block;
	padding: 6px;
}

h2 {
	text-align: center;
	padding: 6px;
}

section {
	background: #eee;
	padding: 1px;
	height: 700px;
}

footer p {
	text-align: center;
	color: #fff;
}

footer {
	background: #379;
	padding: 1px;
}

table, th, td {
	border: 1px, solid, #777;
}

table {
	margin: 0 auto;
	width: 600px;
	text-align: center;
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
		<h2>회원목록조회/수정</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
				for (ShopVo vo : list) {
			%>
			<tr>
				<td><%=vo.getCustno()%></td>
				<td><%=vo.getCustname()%></td>
				<td><%=vo.getGrade()%></td>
				<td><%=vo.getPrice()%></td>
			</tr>
			<%
				}
			%>
		</table>
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy</p>
	</footer>
</body>
</html>