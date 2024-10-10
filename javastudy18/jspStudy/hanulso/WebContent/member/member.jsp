<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp"%>

	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원가입</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
           <form name="member" method="post" action="/mem/memberpro.do" id="member">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" name="name" id="name" class="w300">
                            <p id="namemsg"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="id">아이디<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <input type="text" name="id" id="id" class="w300">
                            <p id="idmsg"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw1">비밀번호<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="pw1" id="pw1" class="w300">
                            <p id="pw1msg"></p>
                            <p class="guideTxt"><span class="tc_point">영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로 작성해 주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw2">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="pw2" id="pw2" class="w300">
                            <p id="pw2msg"></p>
                            <p class="guideTxt"><span class="tc_point">비밀번호 미입력시 기존비밀번호가 유지됩니다.</span></p>
                        </td>
                    </tr>
                    
					<tr>
                        <th><label for="phone">전화번호<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <select name="phone1">
                            	<option value="02">02</option>
                            	<option value="042">042</option>
                            	<option value="052">052</option>
                            	<option value="063">063</option>
                            </select> - 
                            <input type="text" name="phone2" maxlength="4" style="width:105px;"> - 
                            <input type="text" name="phone3" maxlength="4" style="width:105px;">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="email">메일인증<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <input type="email" name="email" id="email" class="w300" placeholder="이메일 입력">
                            <input type="button" id="btn_email" value="메일전송" style="width:10%;" class="btn_round"><br>
                            <p id="emailmsg"></p><br>
                            <input type="text" name="certinumber" id="certinumber" class="w300" placeholder="인증번호 입력">
                    		<input type="button" id="certichk" value="확인" style="width:10%;" class="btn_round">
                            <p id="certimsg"></p>
                        </td>
                    </tr>
               	</tbody>
            </table>
           </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:fn_save();" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
    </div>
	
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
			$("#name").blur(function() {
				if(!$("#name").val()) {
					$("#namemsg").html("<span style='color:#f00;'>이름입력</span>");
				} else {
					$("#namemsg").html("");
				}
			})
			
			$("#id").blur(function() {
				if(!$("#id").val()) {
					$("#idmsg").html("<span style='color:#f00;'>아이디입력</span>");
				} else {
					$("#idmsg").html("");
				}
				$.ajax({
					type:'post',
					url:'/mem/idcheck.do',
					data:{id:$("#id").val()},
					success:function(result) {
						//사용 가능한 id : -1, 사용 불가능 : 1
						if(result == "-1") {
							if($("#id").val() != "") {
								$("#idmsg").html("<span style='color:#0f0;'>사용 가능합니다</span>");
							}
						} else if(result == "1") {
							if($("#id").val() != "") {
								$("#idmsg").html("<span style='color:#f00;'>사용할 수 없습니다.</span>");
								$("#id").focus();
							}
						}
					}, error: function() {
					    alert("통신에러 발생");
					}

				})
			}) //노드.js 리액트.js 뷰.js 앵귤러.js 
			
			$("#pw1").blur(function() {
				if(!$("#pw1").val()) {
					$("#pw1msg").html("<span style='color:#f00;'>비밀번호입력</span>");
				} else {
					$("#pw1msg").html("");
				}
			})
			
			$("#pw2").blur(function() {
				let pw1 = $("#pw1").val();
				let pw2 = $("#pw2").val();
				if(!$("#pw2").val()) {
					$("#pw2msg").html("<span style='color:#f00;'>비밀번호입력</span>");
				} else {
					$("#pw2msg").html("");
				}
				if(pw1 != pw2) {
					$("#pw2msg").html("<span style='color:#f00;'>비밀번호가 같지 않습니다.</span>")
					$("#pw1").focus();
				} else if(pw1 == pw2) {
					$("#pw2msg").html("")
				}
				
			})
			
			$("#btn_email").on("click", function () {
				var email = $("#email").val();
				if(email == "") {
					$("#emailmsg").html("<span style = 'color:#f00;'>이메일 주소를 입력하세요.</span>")
					return false;
				}
				$.ajax({
					type:'post',
					url:'/mem/emailsend.do',
					data:{email:$('#email').val()},
					dataType:'json', //리턴받는 데이터 형식
					success:function(data) {
						alert(data.msg);
					}, error:function() {
						alert("통신 실패");
					}
				})
			})
			
		});
	</script>

<%@ include file = "/footer.jsp"%>