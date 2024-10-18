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
			</button>
			<span id="likeCount">${post.likecount}</span>
			<button type="button" class="btn btn-default" id="hate">
				<span class="material-symbols-outlined">thumb_down</span>
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
	 
	 <!-- comment -->
	<div class="container">
		<div class="reply">
           <p class="reply-count">
              Comments: 5
           </p>
           </div>
           <div class="reply-input">
           	  <c:if test="${not empty user}">
	    		<input type="hidden" name="nickname" class="writer-info" value="${user.userNickname }">
	    		<input type="hidden" name="password" class="writer-info" value="${user.userPw }">
	    	  </c:if>
	    	  
	    	  <c:if test="${empty user }">
		    		<tr>
		                <th>Nickname</th>
		                <td><input type="text" name="nickname" class="writer-info"></td>
		                <th>Password</th>
		                <td><input type="password" name="password" class="writer-info"></td>
		            </tr>
		            <br>
		            <br>
	    	  </c:if>
	    	  <br>
              	<textarea name="comment" class="reply-contents"></textarea>
              	<button id="btn_comment" class="reply-button" onclick="cmtWrite()">댓글등록</button> 
                 
           </div>
           <div>
               <ul>
               	 
                  <li style="padding:12px 0;"><span>ㄴ</span> 닉네임 | 날짜</li>
                  <li>내용</li>
                  
               </ul>
            </div>
	</div>
	<script>
		function cmtWrite() {
			if($(".nickname").val() == "") {
				alert("닉네임을 적어주세요.");
				return false;
			}
			if($(".password").val == "") {
				alert("비밀번호를 적어주세요.");
				return false;
			}
			
			let replyData = {
					post_idx : "<c:out value='${post.post_idx}'/>",
					nickname : $(".nickname").val(),
					password : $(".password").val(),
					comment : $(".comment").val(),
			}
			
			$.ajax({
				type : "post",
				url : "/reply/commentSave.do",
				data : replyData,
				dateType : "json",
				success : function(data) {
					alert(data.result);
				}, error : function() {
					alert("통신에러");
				}
			})
		}
		
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
					$("#likeCount").text(data.hatecount);
				}
			})
		})
	</script>
<%@ include file="/footer.jsp" %>