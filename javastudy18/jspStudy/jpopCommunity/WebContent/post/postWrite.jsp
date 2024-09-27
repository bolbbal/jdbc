<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>書き</h3>
    </div>
    <div class = "container">
    	<form name="post" method="post" action="/posts/writepro.do" onsubmit="return check()">
    		<table class="col-md-12 post-write">
    			 <tr>
		    		 	<th>Nickname</th>
		    		 	<td><input type="text" name="nickname" class="writer-info"></td>
			    		<th>Password</th>
			    		<td><input type="password" name="password" class="writer-info"></td>
			    		<th></th>
		    	 </tr>	
	    		 <tr>
	    		 	<th>Title</th>
	    		 	<td><input type="text" name="title" class="write-title" placeholder="노래 추천시 노래제목|가수 형식으로 작성"></td>
	    		 	<input type="hidden" name="singer">
	    		 </tr>
	    		 <tr>
	    		 	<th>Contents</th>
	    		 	<td><textarea name="contents" class="write-contents"></textarea></td>
	    		 </tr>
	    		 <tr>
	    		 	<th>File</th>
	    		 	<td><input type="file" name="file"></td>
	    		 </tr>
    		 </table>
    		 <div class="form-group text-right">
				    <div class="text-right">
				      <button type="button" class="btn btn-default" onClick="location.href='/posts/list.do';">취소</button>
				      <button type="submit" class="btn btn-default">書き</button>
				    </div>
			 </div>
    	</form>
	</div> <!-- contents end -->
	<script>
	function check() {
	    var titleField = document.getElementsByName('title')[0].value;
	    var parts = titleField.split('|');

	    if (parts.length === 2) {
	        var title = parts[0].trim();
	        var singer = parts[1].trim();
	        document.getElementsByName('title')[0].value = title;  // title 값을 설정
	        document.getElementsByName('singer')[0].value = singer;  // singer 값을 설정
	    }

	    if (document.post.nickname.value === "") {
	        alert("닉네임을 입력하세요.");
	        document.post.nickname.focus();
	        return false;
	    }
	    if (document.post.password.value === "") {
	        alert("비밀번호를 입력하세요.");
	        document.post.password.focus();
	        return false;
	    }
	    if (document.post.title.value === "") {
	        alert("제목을 입력하세요.");
	        document.post.title.focus();
	        return false;
	    }
	    if (document.post.contents.value === "") {
	        alert("내용을 입력하세요.");
	        document.post.contents.focus();
	        return false;
	    }
		
	    alert("글이 등록되었습니다.");
	    return true;  // 폼 제출 허용
	}
	</script>
<%@ include file="/footer.jsp" %>
    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>