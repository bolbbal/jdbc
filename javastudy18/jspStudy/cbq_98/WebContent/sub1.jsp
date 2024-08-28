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
<link href="css/common.css" rel = "stylesheet">
<script type="text/javascript">
	function check() {
		if (my.syear.value == "") {
			alert("학년정보가 입력되지 않았습니다!");
			my.syear.focus();
			return false;
		}
		if (my.sclass.value == "") {
			alert("반정보가 입력되지 않았습니다!");
			my.sclass.focus();
			return false;
		}
		if (my.sno.value == "") {
			alert("번호정보가 입력되지 않았습니다!");
			my.sno.focus();
			return false;
		}
		if (my.sname.value == "") {
			alert("이름이 입력되지 않았습니다!");
			my.sname.focus();
			return false;
		}
		if (my.birth.value == "") {
			alert("생년월일이 입력되지 않았습니다!");
			my.birth.focus();
			return false;
		}
		if (my.gender[0].checked=="" && my.gender[1].checked=="") {
			alert("성별을 선택하세요!");
			my.gender[0].focus();
			return false;
		}
		if (my.member.value == "") {
			alert("회원명을 선택하세요!");
			my.member.focus();
			return false;
		}
		/*
		var genders = document.getElementsByName("gender");
		if(!genders[0].checked && !genders[1].checked) {
			alert("성별선택");
			genders[0].focus();
			return false;
		}
		*/
		if (my.tel1.value == "") {
			alert("전화번호가 입력되지 않았습니다!");
			my.tel1.focus();
			return false;
		}
		if (my.tel2.value == "") {
			alert("전화번호가 입력되지 않았습니다!");
			my.tel2.focus();
			return false;
		}
		if (my.tel3.value == "") {
			alert("전화번호가 입력되지 않았습니다!");
			my.tel3.focus();
			return false;
		}
		
		alert("학생등록이 정상적으로 등록되었습니다");
		return true;

	}
	
	/*function membercheck(member) {
		//alert(member);
		//my.memberno.value = member;
		const membersel = document.getElementById("member"); //변경할 수 없는 membersel 선언
		const memberno = document.getElementById("memberno");
		memberno.value = member;
		
	}*/
		
</script>
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
		<h2 id = "title2">학생등록</h2>
		<form name="my" method="post" action="sub1pro.jsp" onsubmit="return check()">
			<table class = "table-center">
				<tr class = "border1">
					<th class = "border1">학년</th>
					<td class = "border1"><input type="text" name="syear">(예)1</td>
				</tr>
				<tr class = "border1">
					<th class = "border1">반</th>
					<td class = "border1"><input type="text" name="sclass">(예)01</td>
				</tr>
				<tr class = "border1">
					<th class = "border1">번호</th>
					<td class = "border1"><input type="text" name="sno">(예)01</td>
				</tr>
				<tr class = "border1">
					<th class = "border1">이름</th>
					<td class = "border1"><input type="text" name="sname" style="width: 230px"></td>
				</tr>
				<tr class = "border1">
					<th class = "border1">생년월일</th>
					<td class = "border1"><input type="text" name="birth" style="width: 230px">(예)20190301</td>
				</tr>
				<tr class = "border1">
					<th class = "border1">성별</th>
					<td class = "border1"><input type="radio" name="gender" value="M">남성
						<input type="radio" name="gender" value="F">여성</td>
				</tr>
				<tr class = "border1">
					<th class = "border1">전화번호</th>
					<td class = "border1"><input type="text" name="tel1" style="width: 70px">-
						<input type="text" name="tel2" style="width: 70px">-
						<input type="text" name="tel3" style="width: 70px"></td>
				</tr>
				<tr class = "border1">
					<th class = "border1">회원명</th>
					<td class = "border1">
						<!-- <select name = "member" id = "member" onchange = "membercheck(this.value)">
							<option value = "">선택</option>
							<option value = "1101">홍길동</option>
							<option value = "1102">이순신</option>
							<option value = "1103">세종대왕</option>
						</select> -->
						<select name = "member" id = "member">
							<option value = "">선택</option>
							<option value = "1101">홍길동</option>
							<option value = "1102">이순신</option>
							<option value = "1103">세종대왕</option>
						</select> 
					</td>
				</tr>
				<tr class = "border1">
					<th class = "border1">회원번호</th>
					<td class = "border1"><input type = "text" name = "memberno" id = "memberno" value = ""></td>
				</tr>
				<tr class = "border1">
					<td colspan="2" style="text-align: center;" class = "border1">
					<input type="submit" value="학생등록" class = "btn-submit">
					<input type="reset" value="다시쓰기" onclick="alert('정보를 지우고 처음부터 다시 입력합니다!')" class = "btn-reset"></td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright&copy;2016 All rights reserve. Human
			Resources Development Service of Korea</p>
	</footer>
	<script type="text/javascript">
		const membersel = document.getElementById("member"); //변경할 수 없는 membersel 선언
		const memberno = document.getElementById("memberno");
		membersel.addEventListener('change', function() { //thread 처리
			memberno.value = membersel.value;
		});
	</script>
</body>
</html>