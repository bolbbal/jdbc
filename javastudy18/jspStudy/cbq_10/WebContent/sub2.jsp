<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	ShopDao dao = new ShopDao();
	List<ShopVo> list = dao.getMemberList();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>
<!--  웹문서 타입 : html5 -->
<html>
<!--  웹문서 시작 태그 -->

<head>
<!--  문서 머릿글 -->
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
<style>
/* 내부 스타일 시트 변경 방법 
	모든 태그는 여백을 가지고 있는데 모든 태그를 바깥 여백과 안쪽 여백을 0으로 초기화 시킨다.
	*/
* {
	margin: 0;
	padding: 0
} /* *은 모든 태그를 의미*/
header {
	background: #fff7c9;
	/*padding-top: 16px;
	padding-bottom: 16px*/
	padding: 16px 0 16px 0;
	/* 숫자 4개 : 상 우 하 좌*/
} /* 00f : 빨강, 초록, 파랑 3색을 의미*/
h1 {
	color: #fff;
	text-align: center;
} /* fff : 흰색, 000 : 검정색 */
a {
	color: #fff;
	text-decoration: none;
	display: inline-block;
	/*padding-top: 6px;
	padding-bottom: 6px;
	padding-left: 12px;
	padding-right: 12px;*/
	padding: 6px 12px;
}

nav {
	background: #f1e3b1;
}

h2 {
	text-align: center;
	padding: 16px 0;
}

section {
	background: #ffffff;
	height: 500px;
}

footer {
	background: #fff7c9;
}

/*하위 선택자 : footer 밑의 p만 css를 적용하고 싶음*/
footer>p {
	text-align: center;
	color: #fff;
	padding: 40px 0;
}

table, th, td {
	border: 1px solid #ccc; /*선 두께, 선 종류, 선 색깔*/
}

table {
	margin: 0 auto; /* 표 전체 가운데 정렬 */
	width: 1000px; /*표 가로길이*/
}

td {
	text-align : center;
}
</style>
</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리 ver 1.0</h1>
		<!-- 제목 태그 h1~h6까지 가능 -->
	</header>
	<nav>
		<a href="sub1.jsp">회원등록</a>
		<!-- a태그는 링크를 지정할 때 사용 -->
		<a href="sub2.jsp">회원목록조회/수정</a> <a href="sub3.jsp">회원매출조회</a> <a
			href="index.jsp">홈으로</a>
	</nav>
	<section>
		<h2>회원목록조회/수정</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
				for (ShopVo vo : list) {
			%>
			<tr>
				<td><%=vo.getCustno()%></td>
				<td><%=vo.getCustname()%></td>
				<td><%=vo.getPhone()%></td>
				<td><%=vo.getAddress()%></td>
				<td><%=vo.getJoindate().substring(0,10)%></td>
				<td><%=vo.getGrade()%></td>
				<td><%=vo.getCity()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy; 2016 All rights reserved. Human
			Resources Development Service of Korea.</p>
	</footer>
</body>
</html>