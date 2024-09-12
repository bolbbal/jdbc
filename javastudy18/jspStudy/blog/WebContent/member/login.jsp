<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp" %>

	<div class="sub_title">
		<h2>Blog</h2>
	</div>
	
	<div class = "container" style = "width : 600px">
		<div class = "write_inner">
			<form name = "member" method="post" action="">
				<table class = "blog_table">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type = "text" name="pw"></td>
					</tr>
					<tr>
						<td colspan="2" class = "txtcenter">
							<button type="button">login</button>
							<button type="button" onclick = "javascript:location.href='/'">cancel</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div> <!-- container end -->
<%@ include file = "/footer.jsp" %>