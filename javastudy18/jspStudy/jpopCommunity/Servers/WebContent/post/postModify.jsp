<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <c:set var = "postModify" value="${modify[0] }"/>
    <c:set var = "suggestModify" value="${modify[1] }"/>
    <div class = "container post-type">
    	<h3>書き</h3>
    </div>
    <div class = "container">
    	<form name="modify" method="post" action="/posts/Modifypro.do" onsubmit="return check()">
    		<input type="hidden" name="post_idx" value="${postModify.post_idx }">
    		<input type="hidden" name="old_post_type" value="${postModify.post_type_idx }">
    		<table class="col-md-12 post-write">
    			<tr>
	                <th>추천</th>
	                <td colspan="3">
	                    <label><input type="radio" name="post_type_idx" value="1" ${postModify.post_type_idx == 1 ? 'selected' : ''} checked onclick="toggleExtraInputs()"> 일반</label>
	                    <label><input type="radio" name="post_type_idx" value="2" ${postModify.post_type_idx == 2 ? 'selected' : ''} onclick="toggleExtraInputs()"> 추천</label>
	                </td>
            	</tr>
    			 <tr>
		    		 	<th>Nickname</th>
		    		 	<td><input type="text" name="nickname" class="writer-info" value="${postModify.nickname }" readonly="readonly"></td>
			    		<th>Password</th>
			    		<td><input type="password" name="password" class="writer-info" value="${postModify.password }" readonly="readonly"></td>
			    		<th></th>
		    	 </tr>	
	    		 <tr>
	    		 	<th>Title</th>
	    		 	<td><input type="text" name="title" class="write-title" value="${postModify.title}"></td>
	    		 </tr>
	    		 <tr>
	    		 	<th>Contents</th>
	    		 	<td><textarea name="contents" class="write-contents">${postModify.contents}</textarea></td>
	    		 </tr>
	    		 <tr>
	    		 	<th>File</th>
	    		 	<td><input type="file" name="imgurl"></td>
	    		 </tr>
	    		 
	            <tr id="extra-inputs" style="display: none;">
	                <th>제목</th>
	                <td colspan="3"><input type="text" name="music" class="recommend-info" value = "${suggestModify.music }"></td>
	            </tr>
	            <tr id="extra-inputs-2" style="display: none;">
	                <th>가수</th>
	                <td colspan="3"><input type="text" name="singer" class="recommend-info" value = "${suggestModify.singer }"></td>
	            </tr>
	            <tr id="extra-inputs-3" style="display: none;">
	                <th>유튜브 링크</th>
	                <td colspan="3"><input type="text" name="youtube_url" class="recommend-info" value = "${suggestModify.youtube_url }"></td>
	            </tr>
	            <tr id="extra-inputs-4" style="display: none;">
	                <th>가사</th>
	                <td colspan="3"><textarea name="lyrics" class="recommend-info">${suggestModify.lyrics}</textarea></td>
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
	function toggleExtraInputs() {
        var recommendedRadio = document.querySelector('input[name="post_type_idx"][value="2"]');
        var extraInputs = document.getElementById('extra-inputs');
        var extraInputs2 = document.getElementById('extra-inputs-2');
        var extraInputs3 = document.getElementById('extra-inputs-3');
        var extraInputs4 = document.getElementById('extra-inputs-4');

        if (recommendedRadio.checked) {
            extraInputs.style.display = 'table-row';
            extraInputs2.style.display = 'table-row';
            extraInputs3.style.display = 'table-row';
            extraInputs4.style.display = 'table-row';
        } else {
            extraInputs.style.display = 'none';
            extraInputs2.style.display = 'none';
            extraInputs3.style.display = 'none';
            extraInputs4.style.display = 'none';
        }
    }
	
	function check() {
	    
	    if (document.post.title.value == "") {
	        alert("제목을 입력하세요.");
	        document.post.title.focus();
	        return false;
	    }
	    if (document.post.contents.value == "") {
	        alert("내용을 입력하세요.");
	        document.post.contents.focus();
	        return false;
	    }

	    alert("글이 등록되었습니다.");
	    return true;  
	}
	</script>
	
<%@ include file="/footer.jsp" %>
