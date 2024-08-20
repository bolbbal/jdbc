<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	background: #00f;
	/*padding-top: 16px;
	padding-bottom: 16px*/
	padding:16px 0 16px 0;
	/* 숫자 4개 : 상 우 하 좌*/
} /* 00f : 빨강, 초록, 파랑 3색을 의미*/
h1 {
	color: #fff;
	text-align: center;
} /* fff : 흰색, 000 : 검정색 */
a {
	color: #fff;
	text-decoration: none;
	display:inline-block;
	/*padding-top: 6px;
	padding-bottom: 6px;
	padding-left: 12px;
	padding-right: 12px;*/
	padding:6px 12px;
}

nav {
	background: #0cf;
	
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
</body>
</html>