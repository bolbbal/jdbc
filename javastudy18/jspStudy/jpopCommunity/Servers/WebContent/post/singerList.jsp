<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>歌手</h3>
    	<div class="nav navbar-nav navbar-right dropdown-style">
			      <div class="dropdown">
					  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					    sort option
					    <span class="caret"></span>
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
    <c:set var="num" value="${count-(page.cri.pageNum-1)*5 }"/>
    <div class = "container">
    	<c:forEach var="list" items="${list}">
	    <div class="row post">
	    	<a href="/posts/view.do?post_idx=${list.post.post_idx }">
		  		<div class="col-md-3">
		      		<img src="${list.suggest.thumnail }" alt="" class="thumbnail music-thumbnail">
		      	</div>
		      	<div class="col-md-5">
		      		<h3>${list.suggest.music} | ${list.suggest.singer}</h3>
		      		<p>${list.suggest.lyrics}</p>
		      	</div>
		      	<div class="col-md-2">
		      		<img src="/upload/${user.userImg != null ? user.userImg : 'noUserImg.png' }" alt="" class="img-circle member-img">
		      	</div>
		      	<div class="col-md-2 writer">
		      		<p>${list.post.nickname}</p>
		      		<p>
		      			<c:if test = "${list.post.modifydate == null}">${list.post.regdate}</c:if>
		      			<c:if test = "${list.post.modifydate != null}">${list.post.modifydate}</c:if>
		      			<br><br><br>
		      		</p>
		      		<p class="text-right">${list.post.viewcount} | ${list.post.likecount}</p>
		      	</div>
		    </a>
		  </div>
		  <c:set var = "num" value="${num-1 }"/>
		</c:forEach>
		  
	</div>
	<div class="container text-right">
		<a href="/posts/write.do"><button class="btn btn-default text-right" type="submit">書き</button></a>
	</div>
	<div class="container text-center">
		<nav aria-label="Page navigation" style="display: inline-block">
		  <ul class="pagination">
		    <c:if test="${page.prev }">
		    <li>
		      <a href="?pageNum=1" aria-label="Previous">
		        <span class="material-symbols-outlined">keyboard_double_arrow_left</span>
		      </a>
		    </li>
		    </c:if>
		    <c:if test="${page.cri.pageNum != 1 }">
		    <li>
		      <a href="?pageNum=${page.cri.pageNum-1 }" aria-label="Previous">
		        <span class="material-symbols-outlined">keyboard_arrow_left</span>
		      </a>
		    </li>
		    </c:if>
		    <c:forEach var = "pageNum" begin = "${page.startPage }" end = "${page.endPage}">
		    	<li><a href="?pageNum=${pageNum }">${pageNum }</a></li>
		    </c:forEach>
		    <c:if test="${page.cri.pageNum != page.endPage}">
		    <li>
		      <a href="?pageNum=${page.cri.pageNum+1 }" aria-label="Next">
		        <span class="material-symbols-outlined">keyboard_arrow_right</span>
		      </a>
		    </li>
		    </c:if>
		    <c:if test="${page.next}">
		    <li>
		      <a href="?pageNum=${page.realEnd }" aria-label="Next">
		        <span class="material-symbols-outlined">keyboard_double_arrow_right</span>
		      </a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
	</div>
	<!-- contents end -->
	
<%@ include file="/footer.jsp" %>
    

    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>