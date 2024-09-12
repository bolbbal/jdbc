<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp"%>

	<div class="sub_title">
		<h2>Blog</h2>
	</div>
	
	<div class = "container">
		<div class = "write_inner">
			<form name = "blog" method="post" enctype = "multipart/form-data" action="blogwrite">
			<!-- 첨부파일 처리는 enctype="multipart/form-data" 반드시 있어야함 -->
				<table class = "blog_table">
					<tr>
						<th>title</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>contents</th>
						<td><textarea name="contents" style = "height:200px"></textarea></td>
					</tr>
					<tr>
						<th>attach</th>
						<td><input type = "file" name = "photo"></td>
					</tr>
					<tr>
						<td colspan="2" class = "txtcenter">
							<button type="submit">save</button>
							<button type="reset">reset</button>
							<button type="button">list</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div> <!-- container end -->
	
	
	
<%@ include file = "/footer.jsp"%>