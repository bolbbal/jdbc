<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>新着</h3>
    	<div class="nav navbar-nav navbar-right dropdown-style">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					sort option<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li><a href="#">view asc</a></li>
					<li><a href="#">view desc</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">like asc</a></li>
					<li><a href="#">like desc</a></li>
					<li role="separator" class="divider"></li>
				 	<li><a href="#">date asc</a></li>
					<li><a href="#">date desc</a></li>
				</ul>
			</div>
		</div>
    </div>
    
    <div class = "container">
    	<table class = "post-list">
    		<colgroup>
    			<col width = "5%">
    			<col width = "5%">
    			<col width = "*">
    			<col width = "10%">
    			<col width = "10%">
    			<col width = "5%">
    			<col width = "5%">
    		</colgroup>
    		<thead>
    			<tr>
    				<th>번호</th>
    				<th>타입</th>
    				<th>제목</th>
    				<th>작성자</th>
    				<th>작성일</th>
    				<th>조회</th>
    				<th>추천</th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>2</td>
    				<td>일반</td>
    				<td class="title"><a href="/posts/view.do">글 제목을 누르면 내용이 보여요</a></td>
    				<td>관리자</td>
    				<td>24.09.27</td>
    				<td>0</td>
    				<td>0</td>
    			</tr>
    			<tr>
    				<td>1</td>
    				<td>추천</td>
    				<td><a href="/postDetail.jsp">노래 추천이에요</a></td>
    				<td>maplelove</td>
    				<td>24.09.27</td>
    				<td>0</td>
    				<td>0</td>
    			</tr>
    		</tbody>
    	</table>
	</div> 
	<div class="container text-right">
		<a href="/posts/write.do"><button class="btn btn-default text-right" type="submit">書き</button></a>
	</div>
	<div class="container text-center">
		<nav aria-label="Page navigation" style="display: inline-block">
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
	<!-- contents end -->
	
	
<%@ include file="/footer.jsp"%>