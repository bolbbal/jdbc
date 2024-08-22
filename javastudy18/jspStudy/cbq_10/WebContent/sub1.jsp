<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	ShopDao dao = new ShopDao();
int custno = dao.getCustnoAuto();
String today = dao.getToday();
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
	width: 700px; /*표 가로길이*/
}
</style>
<script type="text/javascript">
	function check() {
		//자바스크립트 사용자 함수. 함수는 자바언어에서 메소드와 같음
		if (my.custno.value == "") {
			alert("고객번호를 입력하세요");
			my.custno.focus();
			return false;
		}
		if (my.custname.value == "") {
			alert("고객이름을 입력하세요");
			my.custname.focus();
			return false;
		}
		if (my.phone.value == "") {
			alert("전화번호를 입력하세요");
			my.phone.focus();
			return false;
		}
		if (my.address.value == "") {
			alert("주소를 입력하세요");
			my.address.focus();
			return false;
		}
		if (my.joindate.value == "") {
			alert("가입일자를 입력하세요");
			my.joindate.focus();
			return false;
		}
		if (my.grade.value == "") {
			alert("고객등급을 입력하세요");
			my.grade.focus();
			return false;
		}
		if (my.city.value == "") {
			alert("도시코드를 입력하세요");
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
		<!-- 제목 태그 h1~h6까지 가능 -->
	</header>
	<nav>
		<a href="sub1.jsp">회원등록</a>
		<!-- a태그는 링크를 지정할 때 사용 -->
		<a href="sub2.jsp">회원목록조회/수정</a> <a href="sub3.jsp">회원매출조회</a> <a
			href="index.jsp">홈으로</a>
	</nav>
	<section>
		<h2>홈쇼핑 회원 등록</h2>
		<!-- input 태그는 form 태그로 둘러 싸야 한다.
		name = "" : 폼 명
		method = "" : 서버로 데이터를 전송하는 방식
			get : 데이터가 보임. 소량의 데이터
			post : 데이터가 안보임. 대량의 데이터
		action : 서버로 전송된 데이터를 처리하는 프로그램 -->
		<form name="my" method="post" action="sub1pro.jsp"
			onsubmit="return check();">
			<!-- action 실행하기 전 onsubmit 속성에서 지정해 둔 check() 함수를 실행하고 되돌아오게 함 
			되돌아 온 값이 참이면 action 실행-->

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
					<td><input type="text" name="joindate" value="<%=today%>"></td>
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
						type="submit" value="전송"> <input type="reset" value="다시쓰기"></td>
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