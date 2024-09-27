 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!-- sub contents -->
	<div class="sub_title">
		<h2>포트폴리오</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../about/gratings.html">기업소개</a>
						<a href="../portfolio/portfolio.html">포트폴리오</a>
						<a href="../notice/notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/port/list.jsp">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<c:set var="num" value="${count - (page.cri.pageNum-1)*5 }"/>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span>${count}</span>건</p>
		</div>
		<div class="search_group">
			<form name="myform" action="">
				<select name="type" class="select">
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="search" class="search_word">
				<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<ul class="basic_board">
			<c:forEach var="list" items="${list }">
				<fmt:parseDate var="regdate" value="${list.regdate }" pattern="yyyy-MM-dd"/>
				<li>
					<span class="date"><em><fmt:formatDate value="${regdate }" pattern="dd"/></em><fmt:formatDate value="${regdate }" pattern="yyyy.MM"/></span>
					<div class="text_wrap">
						<div class="img_wrap">
							<img src="${pageContext.request.contextPath}/upload/${list.imgurl != null ? list.imgurl : 'noImage.png' }" alt="">
						</div>
						<span class="info">
							<span class="blue_text">No. ${num}</span>
							<i class="bar"></i>
							<i class="fa fa-eye"></i> ${list.viewcount }
						</span>
						<p class="title">
							<a href="/port/view.do?idx=${list.idx }">${list.title}</a>
						</p>
						<span class="text">
							${list.content }
						</span>
					</div>
				</li>
				<c:set var="num" value="${num-1 }"/>
			</c:forEach>
		</ul>
		<div class="paging">
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
			<a href="/port/write.do" class="btn_write">글쓰기</a>
		</div>
	  </div>
	</div>
	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
<%@ include file="/footer.jsp"%>