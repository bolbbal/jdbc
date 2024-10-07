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
    
    <c:set var = "num" value="${count-(page.cri.pageNum-1)*15 }"/>
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
    			<c:if test="${list.isEmpty() || list == null} ">
    				<tr>
    					<td colspan = "7">검색결과가 없습니다.</td>
    				</tr>
    			</c:if>
    			<c:forEach var="list" items="${list }">
	    			<tr>
	    				<td>${num }</td>
	    				<td>${list.post_type_idx}</td>
	    				<td class="title"><a href="/posts/view.do?post_idx=${list.post_idx }">${list.title} <c:if test="${list.replycount} != null">[${list.replycount}]</c:if></a></td>
	    				<td>${list.nickname}</td>
	    				<td>
	    					<c:if test = "${list.modifydate == null}">${list.regdate}</c:if>
	    					<c:if test = "${list.modifydate} != null">${list.modifydate}</c:if>
	    				</td>
	    				<td>${list.viewcount}</td>
	    				<td>${list.likecount}</td>
	    			</tr>
	    			<c:set var = "num" value="${num-1 }"/>
    			</c:forEach>
    		</tbody>
    	</table>
	</div> 
	<div class="container text-right">
		<a href="/posts/write.do"><button class="btn btn-default text-right" type="submit">書き</button></a>
	</div>
	<div class="container text-center">
		<nav aria-label="Page navigation" style="display: inline-block">
		  <ul class="pagination">
		  	<c:if test="${page.prev }">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span class="material-symbols-outlined">keyboard_double_arrow_left</span>
		      </a>
		    </li>
		    </c:if>
		    <c:if test="${page.cri.pageNum != 1 }">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span class="material-symbols-outlined">keyboard_arrow_left</span>
		      </a>
		    </li>
		    </c:if>
		    <c:forEach var = "pageNum" begin = "${page.startPage }" end = "${page.endPage}">
		    	<li><a href="?pageNum=${pageNum }">${pageNum }</a></li>
		    </c:forEach>
		    <c:if test="${page.cri.pageNum != page.endPage}">
		    <li>
		      <a href="#" aria-label="Next">
		        <span class="material-symbols-outlined">keyboard_arrow_right</span>
		      </a>
		    </li>
		    </c:if>
		    <c:if test="${page.next}">
		    <li>
		      <a href="#" aria-label="Next">
		        <span class="material-symbols-outlined">keyboard_double_arrow_right</span>
		      </a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
	</div>
	<!-- contents end -->
	
	
<%@ include file="/footer.jsp"%>