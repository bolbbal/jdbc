<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>赤ちゃんのBlog</title>
<link href = "../css/common.css" rel = "stylesheet">
</head>
<body>
	<div class = "header_box">
		<header class = "top_navigation">
			<nav class = "top_left">
				<ul><!-- 목록상자 -->
					<li class = "first"><a href="/">HOME</a></li>
					<li><a href="">인스타그램</a></li>
					<li><a href="">카카오톡</a></li>
					<li><a href="">페이스북</a></li>
				</ul>
			</nav>
			<nav class = "top_right">
				<ul>
					<li class = "first"><a href="Login">로그인</a></li>
					<li><a href="member">회원가입</a></li>
				</ul>
			</nav>
			<div class = "gnb_group">
				<h1 class="logo">BLOG</h1>
				<nav class = "gnb">
					<ul>
						<li><a href="about">About</a></li>
						<li><a href="blog">Blog</a></li>
						<li><a href="contact">Contact Us</a></li>
					</ul>
				</nav>
			</div>	
		</header>
	</div>
<!-- header -->

<!-- main visual -->
	
	<div class = "container">
		<div class="concat_left">
			<form name = "concat" method = "post" action="">
				<table>
					<tr>
						<td>
							<input type = "text" name = "mail" placeholder="메일주소를 입력하세요">
						</td>
					</tr>
					<tr>
						<td>
							<input type = "text" name = "name" placeholder="이름을 입력하세요">
						</td>
					</tr>
					<tr>
						<td>
							<input type = "text" name = "title" placeholder="제목을 입력하세요">
						</td>
					</tr>
					<tr>
						<td>
							<textarea name = "content" style="height:300px;" placeholder="내용을 입력하세요"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<button type = "submit" style = "txtcenter">send message</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="concat_right">

		</div>
	</div>
	
	
<!-- footer -->
	<footer class = "footer">
		<p>대전광역시 중구 계룡로 825 / 042-242-4412 </p>
		<p>Copyright&copy; / dyddnr25@gmail.com / All Rights Reserved.</p>
	</footer>
</body>
</html>