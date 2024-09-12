<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp"%>

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
						<td class = "txtcenter">
							<button type = "submit" class = "btn-primary">send message</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="concat_right">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3214.401584973043!2d127.40505177532795!3d36.32681589424202!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x356549343c3c3cf1%3A0x9d6af658336f953a!2z7KCc7J207JeQ7Iqk7JeY7J247J6s6rCc67Cc7JuQKOyjvCk!5e0!3m2!1sko!2skr!4v1725341285836!5m2!1sko!2skr" width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
	</div>
	
<%@ include file = "/footer.jsp"%>