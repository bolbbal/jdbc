<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>書き込み</h3>
    </div>
    <div class = "container">
    	<form name="post" method="post" action="/posts/writepro.do" onsubmit="return check()"> 
    		<table class="col-md-12 post-write">
    			 <tr class="row">
		    		 	<th class="col-md-2">Nickname</th>
		    		 	<td class="col-md-3"><input type="text" name="writer" class="form-control"></td>
			    		<th class="col-md-2">Password</th>
			    		<td class="col-md-3"><input type="password" name="password" class="form-control"></td>
			    		<th class="col-md-2"></th>
		    	 </tr>	
	    		 <tr class="row">
	    		 	<th class="col-md-2">Title</th>
	    		 	<td class="col-md-10"><input type="text" name="title" class="form-control"></td>
	    		 	<input type="hidden" name="singer">
	    		 </tr>
	    		 <tr class="row">
	    		 	<th class="col-md-2">Contents</th>
	    		 	<td class="col-md-10"><textarea name="contents" class="form-control post-write-contents"></textarea></td>
	    		 </tr>
	    		 <tr class="row">
	    		 	<th class="col-md-2">File</th>
	    		 	<td class="col-md-10"><input type="file" name="file" class="form-control"></td>
	    		 </tr>
    		 </table>
    		 <div class="form-group text-center">
				    <div class="text-center">
				      <button type="submit" class="btn btn-default">書き込み</button>
				      <button type="reset" class="btn btn-default">reset</button>
				      <button type="button" class="btn btn-default" onClick="location.href='/posts/list.do';">목록</button>
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