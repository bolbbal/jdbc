<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
<!-- contents start -->
<div class="container post-type">
    <h3>書き</h3>
</div>
<div class="container">
    <form name="post" method="post" action="/posts/writepro.do" onsubmit="return check()">
        <table class="col-md-12 post-write">
        	<tr>
                <th>추천</th>
                <td colspan="3">
                    <label><input type="radio" name="post_type_idx" value="1" checked onclick="toggleExtraInputs()"> 일반</label>
                    <label><input type="radio" name="post_type_idx" value="2" onclick="toggleExtraInputs()"> 추천</label>
                </td>
            </tr>
            <tr>
                <th>Nickname</th>
                <td><input type="text" name="nickname" class="writer-info"></td>
                <th>Password</th>
                <td><input type="password" name="password" class="writer-info"></td>
                <th></th>
            </tr>
            <tr>
                <th>Title</th>
                <td colspan="3"><input type="text" name="title" class="write-title"></td>
                <input type="hidden" name="singer">
            </tr>
            <tr>
                <th>Contents</th>
                <td colspan="3"><textarea name="contents" class="write-contents"></textarea></td>
            </tr>
            <tr>
                <th>Image</th>
                <td><input type="file" name="image"></td>
            </tr>
            
            <tr id="song-title" style="display: none;">
                <th>제목</th>
                <td colspan="3"><input type="text" name="song_title" class="recommend-info"></td>
            </tr>
            <tr id="singer" style="display: none;">
                <th>가수</th>
                <td colspan="3"><input type="text" name="singer" class="recommend-info"></td>
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
        var songTitle = document.getElementById('song-title');
        var singer = document.getElementById('singer');

        if (recommendedRadio.checked) {
        	songTitle.style.display = 'table-row';
        	singer.style.display = 'table-row';
        } else {
        	songTitle.style.display = 'none';
        	singer.style.display = 'none';
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
		
        alert("글이 등록되었습니다.");
        return true;
    }
</script>

<%@ include file="/footer.jsp" %>

</body>
</html>
