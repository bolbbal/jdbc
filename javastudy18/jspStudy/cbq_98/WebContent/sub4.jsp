<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
	ScoreDao dao = new ScoreDao();
	List<ScoreVo> list = dao.selectClassScore();
%>
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
	text-align: center;
	padding: 2px;
}

tr, th, td {
	border-style: solid;
	border-width: 1px;
	border-color: #888;
}

table {
	margin: 0 auto;
	text-align:center;
	width: 600px;
}
</style>

</head>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)고교성적관리프로그램 ver2019-06</h1>
	</header>
	<nav>
		<a href="sub1.jsp">학생등록</a> 
		<a href="sub2.jsp">성적입력</a> 
		<a href="sub3.jsp">성적조회</a> 
		<a href="sub4.jsp">반별통계</a> 
		<a href="index.jsp">홈으로</a>
	</nav>
	<section>
		<h2>학생성적조회</h2>
		<form name="my" method="post" action="sub2pro.jsp" onsubmit="return check()">
			<table>
				<tr>
					<th>학년</th>
					<th>반</th>
					<th>교사명</th>
					<th>국어총점</th>
					<th>영어총점</th>
					<th>수학총점</th>
					<th>국어평균</th>
					<th>영어평균</th>
					<th>수학평균</th>
				</tr>
				<%
					for (ScoreVo vo : list) {
				%>
				<tr>
					<th><%=vo.getSyear()%></th>
					<th><%=vo.getSclass()%></th>
					<th><%=vo.getTname()%></th>
					<th><%=vo.getTkor()%></th>
					<th><%=vo.getTeng()%></th>
					<th><%=vo.getTmat()%></th>
					<th><%=vo.getAkor()%></th>
					<th><%=vo.getAeng()%></th>
					<th><%=vo.getAmat()%></th>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy;2016 All rights reserve. Human Resources Development Service of Korea</p>
	</footer>
</body>
</html>