<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>新着</h3>
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
    <div class = "container">
    	<c:forEach var="list" items="${list}">
		    <div class="row post">
			    	<a href="/posts/view.do?idx=${list.idx }">
				  		<div class="col-md-3">
				      		<img src="../images/shutter.png" alt="" class="thumbnail music-thumbnail">
				      	</div>
				      	<div class="col-md-5">
				      		<h3>${list.title}<c:if test="${list.singer != null}">${list.singer }</c:if></h3>
				      		<p>${list.contents }</p>
				      	</div>
				      	<div class="col-md-2">
				      		<img src="../images/maple.png" alt="" class="img-circle member-img">
				      	</div>
				      	<div class="col-md-2 writer">
				      		<p>${list.nickname }</p>
				      		<p>${list.regdate }<br><br><br></p>
				      		<p class="text-right">${list.viewcount} / ${list.likecount }</p>
				      	</div>
				    </a>
			  </div>
		  </c:forEach>
	</div>
	<div class="container text-right">
		<a href="/posts/write.do"><button class="btn btn-default text-right" type="submit">書き込み</button></a>
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
	
<%@ include file="/footer.jsp" %>