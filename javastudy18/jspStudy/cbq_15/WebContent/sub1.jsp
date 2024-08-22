<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	ShopDao dao = new ShopDao();
int custno = dao.getCustno();
String joindate = dao.setJoindate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
<style type="text/css">
header {
	background: #00f;
	padding: 8px;
}

h1 {
	color: #fff;
	text-align: center;
}

nav {
	background: #0cf;
	padding: 4px;
}

a {
	color: #fff;
	text-decoration: none;
	padding: 6px 12px;
}

section {
	background: #ccc;
	height: 600px;
	padding: 1px;
}

h2 {
	text-align: center;
}

footer p {
	text-align: center;
	padding: 12px;
	color: #fff;
}

footer {
	background: #0cf;
	padding: 2px;
}

table, th, td {
	border: 1px, solid, #999;
}

table {
	margin: 0 auto;
	width: 600px;
}
</style>
<script type="text/javascript">
	function check() {
		if (my.custno.value == "") {
			alert("회원번호를 입력해주세요.");
			my.custno.focus();
			return false;
		}
		if (my.custname.value == "") {
			alert("고객이름을 입력하세요");
			my.custname.focus();
			return false;
		}
		if (my.phone.value == "") {
			alert("전화번호를 입력해주세요.");
			my.phone.focus();
			return false;
		}
		if (my.address.value == "") {
			alert("주소를 입력해주세요.");
			my.address.focus();
			return false;
		}
		if (my.joindate.value == "") {
			alert("가입일자를 입력해주세요.");
			my.joindate.focus();
			return false;
		}
		if (my.grade.value == "") {
			alert("고객등급을 입력해주세요.");
			my.grade.focus();
			return false;
		}
		if (my.city.value == "") {
			alert("도시코드를 입력해주세요.");
			my.city.focus();
			return false;
		}
		return true;
	}
</script>
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
		<form name="my" method="post" action="sub1pro.jsp"
			onsubmit="return check();">
			<table>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name = "custno" value="<%=custno%>"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name = "custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name = "phone" style="width: 200px"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name = "address" style="width: 250px"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name = "joindate" value = "<%=joindate%>" ></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" name = "grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name = "city"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" value="전 송"> <input type="reset"
						value="되돌리기"></td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy</p>
	</footer>
</body>
</html>