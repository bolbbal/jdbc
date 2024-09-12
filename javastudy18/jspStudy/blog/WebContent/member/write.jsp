<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

	<div class="sub_title">
		<h2>Blog</h2>
	</div>
	
	<div class = "container" style = "width : 600px">
		<div class = "write_inner">
			<form name = "member" method="post" enctype = "multipart/form-data" action="member">
			<!-- 첨부파일 처리는 enctype="multipart/form-data" 반드시 있어야함 -->
				<table class = "blog_table">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id" style="width:70%">
							<button type="button">중복확인</button></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type = "text" name="pw"></td>
					</tr>
					<tr>
						<th>패스워드확인</th>
						<td><input type = "text" name="pw_check"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type = "text" name="name"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type = "text" name="tel"></td>
					</tr>
					<tr>
						<th>메일주소</th>
						<td><input type = "text" name="mail"></td>
					</tr>
					<tr>
						<th>사진등록</th>
						<td><input type = "file" name = "my_picture"></td>
					</tr>
					<tr>
						<th>인증키</th>
						<td><input type = "text" name="auth" style="width:50%">
							<button type = "button">발송</button>
							<button type = "button">확인</button>
						</td>
					</tr>
					<tr>
						<td colspan="2" class = "txtcenter">
							<button type="submit">save</button>
							<button type="reset">reset</button>
							<!-- input type = "reset" 태그로 사용 가능 -->
							<button type="button" onclick = "javascript:location.href='/'">cancel</button>
							<!-- onclick 은 자바스크립트 속성 중 하나로 버튼 클릭 시 '/blog/index.jsp' 로 이동 -->
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div> <!-- container end -->
<%@ include file="/footer.jsp"%>