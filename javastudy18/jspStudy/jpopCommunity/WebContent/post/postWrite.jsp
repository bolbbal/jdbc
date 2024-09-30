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
                    <label><input type="radio" name="recommendation" value="normal" checked onclick="toggleExtraInputs()"> 일반</label>
                    <label><input type="radio" name="recommendation" value="recommended" onclick="toggleExtraInputs()"> 추천</label>
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
                <th>File</th>
                <td><input type="file" name="file"></td>
            </tr>
            
            <tr id="extra-inputs" style="display: none;">
                <th>제목</th>
                <td colspan="3"><input type="text" name="extra1" class="recommend-info" placeholder="추가 입력 1"></td>
            </tr>
            <tr id="extra-inputs-2" style="display: none;">
                <th>가수</th>
                <td colspan="3"><input type="text" name="extra2" class="recommend-info" placeholder="추가 입력 2"></td>
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
        var recommendedRadio = document.querySelector('input[name="recommendation"][value="recommended"]');
        var extraInputs = document.getElementById('extra-inputs');
        var extraInputs2 = document.getElementById('extra-inputs-2');

        if (recommendedRadio.checked) {
            extraInputs.style.display = 'table-row';
            extraInputs2.style.display = 'table-row';
        } else {
            extraInputs.style.display = 'none';
            extraInputs2.style.display = 'none';
        }
    }

    // 기존 check 함수
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

</body>
</html>
