<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container">
    	<div class = "container post-title">
    		<h3>${view.getTitle()}<c:if test="${view.getSinger() != null}"><c:out value = " | ${view.getSinger()}"/></c:if></h3>
    		<div class="text-left writer-date">
    			<span>${view.getNickname() }</span><span> | ${view.getRegdate() }</span>
    		</div>
    		<div class="text-right popular">
    			<span class="material-symbols-outlined">visibility</span><span>${view.getViewcount() } | </span>
    			<span class="material-symbols-outlined">favorite</span><span>${view.getLikecount()} | </span>
    			<span class="material-symbols-outlined">chat_bubble</span><span>${view.getReplycount() }</span>
    		</div>
    	</div>
		<div class = "container video">
			<div class="embed-responsive embed-responsive-16by9">
				<p>iframe 통한 유튜브</p>
				<br><br>
			</div>
		</div>
		<div class = "container text-center post-detail">
			<p>
				${view.getContents() }
			</p>
		</div>
		<div class = "container text-center post-like">
			<button type="button" class="btn btn-default">
				<span class="material-symbols-outlined">thumb_up</span><span>${view.getLikecount()}</span>
			</button>
			<button type="button" class="btn btn-default">
				<span class="material-symbols-outlined">thumb_down</span><span>${view.getHatecount()}</span>
			</button>
		</div>
		<div class="form-group">
			<div class="text-left">
				<a href="/posts/list.do"><button type="button" class="btn btn-default">목록</button></a>
			</div>
			<div class="text-right">
				<a href="/posts/modify.do?idx=${view.getIdx() }"><button type="button" class="btn btn-default">수청</button></a>
				<a href="/posts/delete.do"><button type="button" class="btn btn-default">삭제</button></a>
				<a href="/posts/write.do"><button type="button" class="btn btn-default">書き</button></a>
			</div>
		</div>
	</div>
	 <!-- contents end -->
	
<%@ include file="/footer.jsp" %>
    

    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>