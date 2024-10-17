<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <c:set var = "post" value = "${list[0]}"/>
    <c:set var = "suggest" value = "${list[1]}"/>
    <input type="hidden" id="post_idx" value="${post.post_idx }">
    <div class = "container">
    	<div class = "container post-title">
    		<h3>${post.title}</h3>
    		<div class="text-left writer-date">
    			<span>${post.nickname}</span><span> | ${post.regdate}</span>
    		</div>
    		<div class="text-right popular">
    			<span class="material-symbols-outlined">visibility</span><span>${post.viewcount} | </span>
    			<span class="material-symbols-outlined">favorite</span><span id="likeCount">${post.likecount} | </span>
    			<span class="material-symbols-outlined">chat_bubble</span><span id="replyCount">${post.replycount}</span>
    		</div>
    	</div>
		<div class = "container text-left post-detail">
			<p>
				${post.contents}
			</p>
			<c:if test="${post.imgurl != null }">
				<img src="/upload/${post.imgurl}" alt="">
			</c:if>
		</div>
		<c:if test="${suggest != null }">
			<div class = "container video">
				<div class="embed-responsive embed-responsive-16by9">
					<iframe width="560" height="315" src="${suggest.youtube_url }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
				</div>
			</div>
			<div class = "container text-center post-detail">
				<h5>${suggest.music} | ${suggest.singer }</h5>
				<p>${suggest.lyrics}</p>
			</div>
		</c:if>
		<div class = "container text-center post-like">
			
			<button type="button" class="btn btn-default" id="like">
				<span class="material-symbols-outlined">thumb_up</span>
				<span id="likeCount">${post.likecount}</span>
			</button>
			<button type="button" class="btn btn-default" id="hate">
				<span class="material-symbols-outlined">thumb_down</span>
				<span id="hateCount">${post.hatecount}</span>
			</button>
		</div>
		<div class="form-group">
			<div class="text-left">
				<a href="/posts/list.do"><button type="button" class="btn btn-default">목록</button></a>
			</div>
			<div class="text-right">
				<a href="/posts/modify.do?post_idx=${post.post_idx}"><button type="button" class="btn btn-default">수청</button></a>
				<a href="/posts/delete.do"><button type="button" class="btn btn-default">삭제</button></a>
				<a href="/posts/write.do"><button type="button" class="btn btn-default">書き</button></a>
			</div>
		</div>
	</div>
	 <!-- contents end -->
	<script>
		var post_idx = $("#post_idx").val();
		
		$("#like").on("click", function() {
			$.ajax({
				type:"post",
				url:"/posts/like.do",
				data:{"post_idx":post_idx},
				dataType:"json",
				success:function(data) {
					$("#likeCount").text(data.likecount);
				}
			})
		})
		
		$("#hate").on("click", function() {
			$.ajax({
				type:"post",
				url:"/posts/hate.do",
				data:{"post_idx":post_idx},
				dataType:"json",
				success:function(data) {
					$("#hateCount").text(data.hatecount);
				}
			})
		})
	</script>
<%@ include file="/footer.jsp" %>