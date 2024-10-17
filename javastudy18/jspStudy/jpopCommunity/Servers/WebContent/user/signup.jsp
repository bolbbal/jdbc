<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- contents start -->
    <div class = "container">
    	<div class = "row">
    		<div class = "col-md-2"></div>
    		<div class = "col-md-8">
    			<h3 class = "text-center">新規登録</h3>
    			
				  <div class="form-group">
				    <label for="id" class="col-sm-4 control-label">ID</label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control signUp" name="id" id="id" placeholder="ID">
				      <p id="idMsg"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-4 control-label">Password</label>
				    <div class="col-sm-8">
				      <input type="password" class="form-control signUp" name="password" id="password" placeholder="Password">
				      <p id="passwordMsg"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="passwordChk" class="col-sm-4 control-label">Password Check</label>
				    <div class="col-sm-8">
				      <input type="password" class="form-control signUp" name="passwordChk" id="passwordChk" placeholder="Password Check">
				      <p id="passwordChkMsg"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="nickname" class="col-sm-4 control-label">Nickname</label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control signUp" name="nickname" id="nickname" placeholder="Nickname">
				      <p id="nicknameMsg"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="email" class="col-sm-4 control-label">Email address</label>
				    <div class="col-sm-8">
					    <input type="email" class="form-control signUp" name="email" id="email" placeholder="Email">
					    <button class="btn btn-default" name="emailSend" id="emailSend">Submit</button>
					    <p id="emailMsg"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="certiNumber" class="col-sm-4 control-label">Certification</label>
				    <div class="col-sm-8">
					    <input type="text" class="form-control signUp" name="certiNumber" id="certiNumber" placeholder="Certification Number">
					    <button class="btn btn-default" name="certiChk" id="certiChk">Submit</button>
					    <p id="certiMsg"></p>
				    </div>
				  </div>
				  <div class="form-group text-center">
				    <div class="text-center">
				      <button type="submit" class="btn btn-default" name="submit" id="submit">登録</button>
				      <button class="btn btn-default" name="cansel" id="cansel">reset</button>
				    </div>
				  </div>
				
    		</div>
    		<div class = "col-md-2"></div>
		</div>
	</div> <!-- contents end -->
	
	<script>
		$(function() {
			
			var idChk = 0;
			var passwordChk = 0;
			var nicknameChk = 0;
			var emailChk = 0;
			
			$("#id").blur(function() {
				if(!$("#id").val()) {
					$("#idMsg").html("<span style='color:#f00;'>아이디입력</span>");
				} else {
					$("#idMsg").html("");
				}
				$.ajax({
					type:'post',
					url:'/users/idCheck.do',
					data:{id:$("#id").val()},
					dataType:'json',
					success:function(data) {
						if(data.result == "possible") {
							if($("#id").val() != "") {
								$("#idMsg").html("<span style='color:#0f0;'>사용 가능</sapn>");
								idChk = 1;
							} 
						} else if(data.result == "impossible") {
							if($("#id").val() != "") {
								$("#idMsg").html("<span style='color:#f00;'>사용 불가능</sapn>");
							}
						}
					}, error: function() {
						alert("통신에러");
					}
				})
			})
			
			$("#password").blur(function() {
				if(!$("#password").val()) {
					$("#passwordMsg").html("<span style='color:#f00;'>비밀번호입력</span>");
				} else {
					$("#passwordMsg").html("");
				}
			})
			
			$("#passwordChk").blur(function() {
				
				let pw = $("#password").val();
				let pwChk = $("#passwordChk").val();
				
				if(!$("#passwordChk").val()) {
					$("#passwordChkMsg").html("<span style='color:#f00;'>비밀번호입력</span>");
				} else {
					$("#passwordChkMsg").html("");
				}
				
				if(pw != pwChk) {
					$("#passwordChkMsg").html("<span style='color:#f00;'>비밀번호가 같지 않습니다.</span>");
				} else if(pw == pwChk) {
					$("#passwordChkMsg").html("");
					passwordChk = 1;
				}
				
			})
			
			$("#nickname").blur(function() {
				if(!$("#nickname").val()) {
					$("#nicknameMsg").html("<span style='color:#f00;'>닉네임입력</span>");
				} else {
					$("#nicknameMsg").html("");
				}
				$.ajax({
					type:'post',
					url:'/users/nicknameCheck.do',
					data:{nickname:$("#nickname").val()},
					dataType:'json',
					success:function(data) {
						if(data.result == "possible") {
							if($("#nickname").val() != "") {
								$("#nicknameMsg").html("<span style='color:#0f0;'>사용 가능</sapn>");
								nicknameChk = 1;
							} 
						} else if(data.result == "impossible") {
							if($("#nickname").val() != "") {
								$("#nicknameMsg").html("<span style='color:#f00;'>사용 불가능</sapn>");
							}
						}
					}, error: function() {
						alert("통신에러");
					}
				})
			})
			
			$("#email").blur(function () {
				if(!$("#email").val()) {
					$("#emailMsg").html("<span style = 'color:#f00;'>이메일 주소를 입력하세요.</span>");
				} else {
					$("#emailMsg").html("");
				}
				$.ajax({
					type:'post',
					url:'/users/emailCheck.do',
					data:{email:$('#email').val()},
					dataType:'json', //리턴받는 데이터 형식
					success:function(data) {
						if(data.result == "possible") {
							if($("#email").val() != "") {
								$("#emailMsg").html("<span style='color:#0f0;'>사용 가능</sapn>");
								emailChk = 1;
							} 
						} else if(data.result == "impossible") {
							if($("#email").val() != "") {
								$("#emailMsg").html("<span style='color:#f00;'>사용 불가능</sapn>");
							}
						}
					}, error: function() {
						alert("통신에러");
					}
				})
			})
			
			var authenticationKey = 0;
			var certiChk = 0;
			
			$("#emailSend").on("click", function(event) {
				event.preventDefault();
				if(!$("#email").val()) {
					return false;
				}
				$.ajax({
					type:'post',
					url:'/users/sendEmail.do',
					data:{email:$("#email").val()},
					dataType:'json',
					success:function(data) {
						authenticationKey = data.authenticationKey;
					}, error:function() {
						alert("통신에러");
					}
				})
				
			})
			
			$("#certiChk").on("click", function(event) {
				event.preventDefault();
				var certiNumber = $("#certiNumber").val();
				if($("#certiNumber") == "") {
					$("#certiMsg").html("<span style='color:#f00;'>인증번호를 입력하세요.</span>");
					return false;
				}
				
				if(authenticationKey == certiNumber) {
					$("#certiMsg").html("<span style='color:#0f0;'>인증번호가 일치합니다.</span>");
					certiChk = 1;
				} else {
					$("#certiMsg").html("<span style='color:#f00;'>인증번호가 일치하지 않습니다.</span>");
				}
				
			})
			
			$("#submit").on("click", function() {
				
			    var id = $("#id").val();
			    var password = $("#password").val();
			    var nickname = $("#nickname").val();
			    var email = $("#email").val();
			    
			    if($("#id").val() == "" || idChk != 1) {
			    	$("#idMsg").html("<span style='color:#f00;'>사용가능한 아이디를 입력해주세요.</sapn>");
			    	$("#id").focus();
			    	return false;
			    }
			    if($("#password").val() == "" || $("#passwordChk").val() == "" || passwordChk != 1) {
			    	$("#passwordChkMsg").html("<span style='color:#f00;'>동일한 비밀번호를 입력해주세요.</sapn>");
			    	$("#passwordChk").focus();
			    	return false;
			    }
			    if($("#nickname").val() == "" || nicknameChk != 1) {
			    	$("#nicknameMsg").html("<span style='color:#f00;'>사용가능한 닉네임을 입력해주세요.</sapn>");
			    	$("#nickname").focus();
			    	return false;
			    }
			    if($("#email").val() == "" || emailChk != 1) {
			    	$("#emailMsg").html("<span style='color:#f00;'>사용가능한 이메일을 입력해주세요.</sapn>");
			    	$("#email").focus();
			    	return false;
			    }
			    
				if(certiChk == 0) {
					alert("메일인증 번호 확인은 필수입니다.");
					return false;
				} else {
					$.ajax({
						type:"post",
						data:{"id" : id,
							"password" : password,
							"nickname" : nickname,
							"email" : email
							},
						url:"/users/access.do",
						dataType:"json",
						success:function(data) {
							alert(data.msg);
							location.href="/";
						}, error:function() {
							alert("통신 에러");
						}
					})
				}
			})
			
		}); //jquery end
	</script>
<%@ include file="/footer.jsp" %>
