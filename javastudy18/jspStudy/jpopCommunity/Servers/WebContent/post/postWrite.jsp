<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
<!-- contents start -->
<div class="container post-type">
    <h3>書き</h3>
</div>
<div class="container">
    <form name="post" method="post" enctype = "multipart/form-data" action="/posts/writepro.do" onsubmit="return check()">
    	<input type="hidden" name="thumnail">
        <table class="col-md-12 post-write">
        	<tr>
                <th>추천</th>
                <td colspan="3">
                    <label><input type="radio" name="post_type_idx" value="1" checked onclick="toggleExtraInputs()"> 일반</label>
                    <label><input type="radio" name="post_type_idx" value="2" onclick="toggleExtraInputs()"> 추천</label>
                </td>
            </tr>
            <c:if test="${not empty user}">
	    		
    		</c:if>
    		<c:if test="${empty user }">
	    		<tr>
	                <th>Nickname</th>
	                <td><input type="text" name="nickname" class="writer-info"></td>
	                <th>Password</th>
	                <td><input type="password" name="password" class="writer-info"></td>
	                <th></th>
	            </tr>
    		</c:if>
            
            <tr>
                <th>Title</th>
                <td colspan="3"><input type="text" name="title" class="write-title"></td>
            </tr>
            <tr>
                <th>Contents</th>
                <td colspan="3"><textarea name="contents" class="write-contents"></textarea></td>
            </tr>
            <tr>
                <th>File</th>
                <td><input type="file" name="imgurl"></td>
            </tr>
            
            <tr id="extra-inputs" style="display: none;">
                <th>제목</th>
                <td colspan="3"><input type="text" name="music" class="recommend-info"></td>
            </tr>
            <tr id="extra-inputs-2" style="display: none;">
                <th>가수</th>
                <td colspan="3"><input type="text" name="singer" class="recommend-info"></td>
            </tr>
            <tr id="extra-inputs-3" style="display: none;">
                <th>유튜브 링크</th>
                <td colspan="3"><input type="text" name="youtube_url" class="recommend-info" ></td>
            </tr>
            <tr id="extra-inputs-4" style="display: none;">
                <th>가사</th>
                <td colspan="3"><textarea name="lyrics" class="recommend-info"></textarea></td>
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
    // 라디오 버튼 상태에 따라 추가 입력 필드 표시
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
      
        if (post.nickname.value == "") {
            alert("닉네임을 입력하세요.");
            post.nickname.focus();
            return false;
        }
        
        if (post.password.value == "") {
            alert("비밀번호를 입력하세요.");
            post.password.focus();
            return false;
        }
        
        if (post.post_type_idx.value == 2) {
        	
        	let youtubeUrl = post.youtube_url.value;
        	console.log(youtubeUrl);
        	youtubeUrl = youtubeUrl.replace("https://youtu.be/", '');
        	youtubeUrl = youtubeUrl.replace("https://www.youtube.com/embed/", '');
        	youtubeUrl = youtubeUrl.replace("https://www.youtube.com/watch?v=", '');
        	
        	let thumnailUrl = youtubeUrl.split('&')[0];
        	console.log(youtubeUrl);
        	post.thumnail.value = "https://img.youtube.com/vi/" + thumnailUrl + "/mqdefault.jpg";
        	post.youtube_url.value = "https://www.youtube.com/embed/" + thumnailUrl;
        	
        	if(post.music.value == "") {
        		alert("노래 제목을 입력하세요.");
        		post.music.focus();
        		return false;
        	}
        	if(post.singer.value == "") {
        		alert("가수 이름을 입력하세요.");
        		post.music.focus();
        		return false;
        	}
        	if(post.youtube_url.value == "") {
        		alert("유튜브 링크를 입력하세요.");
        		post.youtube_url.focus();
        		return false;
        	}
        	if(post.lyrics.value == "") {
        		alert("가사를 입력하세요.");
        		post.lyrics.focus();
        		return false;
        	}
        	
        }

        if (post.title.value == "") {
            alert("제목을 입력하세요.");
            post.title.focus();
            return false;
        }
        
        if (post.contents.value == "") {
            alert("내용을 입력하세요.");
            post.contents.focus();
            return false;
        }
        
        return true;
        
    }
</script>

<%@ include file="/footer.jsp" %>
