<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container">
    	<div class = "row">
    		<div class = "col-md-2"></div>
    		<div class = "col-md-8">
    			<h3 class = "text-center">회원정보 수정</h3>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" name="password" id="password" placeholder="Password">
				      <p id="passwordMsg"></p>
				    </div>
				  </div>
				  <div class="form-group text-center">
				    <div class="text-center">
				      <button type="submit" id="submit" class="btn btn-default">登録</button>
				    </div>
				  </div>
				
    		</div>
    		<div class = "col-md-2"></div>
		</div>
	</div> <!-- contents end -->
	<script>
		$(function() {
			
			$("#submit").on("click", function() {
				
				if(!$("#password").val()) {
					$("#passwordMsg").html("<span style='color:#f00;'>비밀번호입력</span>");
					$("#password").focus();
					return;
				}
				
				$.ajax({
					type:'post',
					url:'/users/myPageTermspro.do',
					data:{
						'password':$("#password").val()				
						},
					dataType:'json',
					success:function(data) {
						if(data.result == "success") {
							location.href="/users/myPage.do";
						} else if(data.result == "no") {
							return;
						}
					}, error:function() {
						alert("통신 에러");
					}
				})
			})
		});
	</script>
<%@ include file="/footer.jsp" %>
