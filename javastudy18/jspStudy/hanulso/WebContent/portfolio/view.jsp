<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp"%>
<!-- sub contents -->
	<div class="sub_title">
		<h2>포트폴리오</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
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
						<a href="portfolio.html">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="board_view">
			<h2>${view.title }</h2>
			<p class="info"><span class="user">${view.writer }</span> | ${view.regdate } | <i class="fa fa-eye"></i> ${view.viewcount }</p>
			<div class="board_body">
				<p>${view.content }</p>
				<img src="${pageContext.request.contextPath}/upload/${view.imgurl}" alt="">
			</div>
			<div class="prev_next">
				<a href="" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span>이전글제목표시</span>
				</span>
				</a>
				<div class="btn_3wrap">
					<a href="/port/list.do">목록</a> 
					<a href="/port/modify.do?idx="${view.idx}">수정</a> 
					<a href="portfolio_delete.html" onClick="return confirm('삭제하시겠어요?')">삭제</a>
				</div>
				<a href="" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span>다음글제목표시</span>
				</span>
				<i class="fa fa-angle-right"></i></a>
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
<%@ include file = "/footer.jsp"%>