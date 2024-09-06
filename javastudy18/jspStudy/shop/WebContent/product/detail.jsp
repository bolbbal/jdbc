<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>shopping</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
	
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
	<link href="../css/mystyle.css" rel="stylesheet">
   
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <header id = "header">
    	<div class = "header-top">
    		<div class="container">
    			<div class="row htop">
    				<div class="col-md-6">
    					<a href="tel:10-9999-9999"><span class = "glyphicon glyphicon-earphone"></span>
    					+82 10-9999-9999</a>
    					<a href="mailto:info@domain.com"><span class = "glyphicon glyphicon-envelope"></span>
    					info@domain.com</a>
    				</div>
    				<div class="col-md-6 text-right">
    					<a href="https://www.facebook.com"><i class = "icon-facebook"></i></a>
    					<a href="https://www.instagram.com"><i class = "icon-twitter"></i></a>
    					<a href="https://www.google.com"><i class = "icon-google-plus"></i></a>
    				</div>
    			</div>
			</div>
    	</div> <!-- header top end-->
    	
    	<div class = "header-middle">
    		<div class = "container">
    			<div class = "row">
    				<div class = "col-md-4">
    					<div class="logo pull-left">
    						<a href="../index.jsp"><img src="../images/hololiveLogo.png" alt=""></a>
    					</div>
    				</div>
    				<div class = "col-md-8">
    					<div class="shop-menu">
    						 <ul class="nav navbar-nav navbar-right">
						        <li><a href="#">회원가입</a></li>
						        <li><a href="#">로그인</a></li>
						        <li><a href="#">장바구니</a></li>
						        <li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">더보기 <span class="caret"></span></a>
						          <ul class="dropdown-menu">
						            <li><a href="#">상품후기</a></li>
						            <li><a href="#">Q&A</a></li>
						            <li><a href="#">이벤트</a></li>
						            <li role="separator" class="divider"></li>
						            <li><a href="#">관리자</a></li>
						          </ul>
						        </li>
						      </ul>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div> <!-- header middle end-->
    	
    	<div class = "header-bottom">
    		<div class = "container">
    			<div class = "row">
    				<div class = "col-md-9">
    					<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						    	<span class="sr-only">Toggle navigation</span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
							</button>
						</div>
						<div class = "mainmenu pull-left">
							<ul class="nav navbar-nav">
						        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
						        <li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Product <span class="caret"></span></a>
						          <ul class="dropdown-menu">
						            <li><a href="#">Man</a></li>
						            <li><a href="#">Woman</a></li>
						            <li><a href="#">Shoes</a></li>
						            <li role="separator" class="divider"></li>
						            <li><a href="#">Popular</a></li>
						            <li role="separator" class="divider"></li>
						            <li><a href="#">New</a></li>
						          </ul>
						        </li>
						        <li><a href="#">Concat</a></li>
							</ul>
						</div>
    				</div>
    				<div class = "col-md-3">
    				
    				</div>
    			</div>
    		</div>
    	</div> <!-- header bottom end-->
    </header>
     
    <!-- contents -->
	
	<div class = "container-fluid">
		<div class = "container">
			<div class = "row main">
				<div class = "col-md-3 main-left" style="padding-top:32px">
					<h2>HOLOLIVE</h2>
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
							    <h4 class="panel-title">
							    	<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							        	3기생
							        </a>
							    </h4>
						    </div>
						    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							    <div class="panel-body">
								   	<ul>
								   		<li><a href="">宝鐘マリン</a></li>
								   		<li><a href="">兎田ぺこら</a></li>
								   		<li><a href="">不知火フレア</a></li>
								   		<li><a href="">白銀ノエル</a></li>
								   	</ul>
							    </div>
						  	</div>
						  	<div class="panel panel-default">
							    <div class="panel-heading" role="tab" id="headingTwo">
								    <h4 class="panel-title">
									    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
									    	6기생
									    </a>
								    </h4>
							    </div>
						    	<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
						      		<div class="panel-body">
							        	<ul>
									   		<li><a href="">沙花叉クロヱ</a></li>
									   		<li><a href="">ラプラス・ダークネス</a></li>
									   		<li><a href="">鷹嶺ルイ</a></li>
									   		<li><a href="">博衣こより</a></li>
									   		<li><a href="">風真いろは</a></li>
									   	</ul>
						      		</div>
						    	</div>
						  </div>
						  <div class="panel panel-default">
							  <div class="panel-heading" role="tab" id="headingThree">
								  <h4 class="panel-title">
									  <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
									  	REGLOSS
									  </a>
								  </h4>
							  </div>
							  <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
								  <div class="panel-body">
									  <ul>
										  <li><a href="">音乃瀬奏</a></li>
										  <li><a href="">火威青</a></li>
										  <li><a href="">一条莉々華</a></li>
										  <li><a href="">儒烏風停らでん</a></li>
										  <li><a href="">轟はじめ</a></li>
									  </ul>
								  </div>
							  </div>
						  </div>
						</div>
					</div>
				</div>
				
				<div class = "col-md-9" style="padding-top:20px">
					<div class = "product-right">
						<div class = "row">
							<div class = "col-md-5">
								<img alt="" src="../images/m_012.jpg" class = "imgw100">
							</div>
							<div class = "col-md-7">
								<h3>좋은 상품</h3>
								<p class = "price">1,870￥</p>
								<p><a data-toggle="modal" data-target="#myModal"><i class = "icon-truck"></i>배송비 300￥ (50,000원 이상 무료) | 우체국 택배 <i class = "icon-chevron-right"></i></a></p>
								<p>모레 9/6(금) 도착 예정</p>
								<p>제주지역 4,000원, 도서산간지역 6,000원</p>
								<div>
									<button class = "minus" type = "button">-</button>
										<input type="text" name = "quantity" value="1" class = "quantity" readonly="readonly">
									<button class = "plus" type = "button">+</button>
								</div>
								<div class = "total"></div>
								<div>
									<button type="button" class = "btn cart">장바구니</button>
									<button type="button" class = "btn buy">구매하기</button>
								</div>
							</div>
						</div>
					</div>
					<!-- tab -->
					<div class = "container-fluid">

					  <!-- Nav tabs -->
					  <ul class="nav nav-tabs nav-justified" role="tablist">
					    <li role="presentation" class="active"><a href="#detail" aria-controls="home" role="tab" data-toggle="tab">상품정보</a></li>
					    <li role="presentation"><a href="#review" aria-controls="review" role="tab" data-toggle="tab">상품후기</a></li>
					    <li role="presentation"><a href="#qa" aria-controls="qa" role="tab" data-toggle="tab">질문답변</a></li>
					    <li role="presentation"><a href="#info" aria-controls="info" role="tab" data-toggle="tab">판매자정보</a></li>
					  </ul>
					
					  <!-- Tab panes -->
					  <div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="detail">
					    	<img alt="" src="../images/toreta.jpg">
					    </div>
					    <div role="tabpanel" class="tab-pane" id="review">
					    	<div class = "row">
					    		<div class = "col-md-2">
					    			<img src="../images/m_011.jpg" alt="" style="width:100px; height:100px; border-radius:50px;">
					    		</div>
					    		<div class = "col-md-10">
					    			<h4>kanade <span class = "text-right">2024.08.19</span></h4>
					    			<p>★★★★★5</p>
					    			<p>● 500ml 1펫 당 83 kcal<br>
										● 많이 달지 않고<br>
										저자극의 산뜻하고 깔끔한 맛이네요.<br>
										● 운동으로 흘리는 땀으로 배출되는<br>
										전해질과 수분을 함께 보충할 수 있습니다.<br>
										● 원래는 포카리만 쭉- 사먹었는데요.<br>
										토레타가 칼로리도 더 낮고<br>
										당류도 덜 포함되어있고<br>
										가격도 좀 더 저렴하길래<br>
										맛은 비슷할 거 같아서<br>
										한번 사봤습니다.<br>
										● 사는 시점에<br>
										여기저기 검색해보고<br>
										가장 저렴한 곳에서 구매하는데<br>
										여기가 가장 저렴했어요.<br>
										● 적은 용량 보다 500ml 펫이 단위당단가가 저렴하고<br>
										남으면 뚜껑 닫아서 냉장실 보관했다가<br>
										다음날 먹어도 되니까<br>
										전 500ml 펫이 젤 낫더라구요 !!<br>
										● 다음에 또 재구매할게요.</p>
					    		</div>
					    	</div>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="qa">
					    	<table class="table">
					    		<tr>
					    			<th>문의유형</th>
					    			<th>문의/답변</th>
					    			<th>작성자</th>
					    			<th>작성일</th>
					    		</tr>
					    		<tr>
					    			<td>상품</td>
					    			<td><span style="">답변완료</span>이게 맞나요?</td>
					    			<td>koyori</td>
					    			<td>2024.09.05</td>
					    		</tr>
							</table>
							<button type = "button">상품 문의하기</button>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="info">
					    	<table class="prdc_detail_table"><caption>판매자정보 테이블</caption><colgroup><col style="width: 18%;"><col style="width: 32%;"><col style="width: 18%;"><col style="width: 32%;"></colgroup><tbody><tr><th scope="row">판매자</th><td>슈팅배송</td><th scope="row">상호명/대표자</th><td>십일번가 주식회사 | 하형일, 안정은</td></tr><tr><th scope="row">사업자구분</th><td>법인사업자 </td><th scope="row">사업자등록번호</th><td>815-81-01244</td></tr><tr><th scope="row">통신판매업신고</th><td>제2018-서울중구-1445호</td><th scope="row">고객문의 대표번호</th><td>1599-3883 (유료)</td></tr><tr><th scope="row">E-Mail</th><td colspan="3">customerservice@11st.co.kr</td></tr><tr><th scope="row">영업소재지</th><td colspan="3">서울특별시 중구 한강대로 416 (남대문로5가, 서울스퀘어) 십일번가(주)</td></tr></tbody></table>
					    </div>
					  </div>
					
					</div>
				</div> <!-- 9 end -->
			</div>
		</div>
	</div> <!-- contents end -->
	
	<!-- footer -->
	<footer class = "container-fluid footer">
		<div class = "container">
			<div class = "row">
				<div class = "col-md-2">
					<img alt="" src="../images/hololiveLogo.png">
					<p>にんじん<p>
				</div>
				<div class = "col-md-10">
					<div class = "col-md-3">
						<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3242.301379237097!2d139.7382977788783!3d35.64494566133498!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x601889682a7243eb%3A0x9e8ab24bd894e12b!2sCover%20Corp.!5e0!3m2!1sko!2skr!4v1725513787736!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
						<p>오시는 길</p>
					</div>
					<div class = "col-md-3">
						<a href="https://www.youtube.com/@hololive"><img alt="" src="../images/youtube.png"></a>
						<p>YOUTUBE</p>
					</div>
					<div class = "col-md-3">
						<img src="../images/m_005.jpg" alt="">
						<p>회사소개</p>
					</div>
					<div class = "col-md-3">
						<img src="../images/yagoo.png" alt="">
						<p>야고</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">배송 안내</h4>
      </div>
      <div class="modal-body">
		<h4>배송비 안내</h4>
		<p>도서산간 추가 배송비</p>
		<p>제주지역 3,000원, 도서산간지역 3,000원</p>
		
		<h5>슈팅배송도착 예정일</h5>
		<ul>
		<li>슈팅배송은 밤 12시까지 주문해도 내일 도착하는 서비스입니다. (토요일 주문은 월요일 도착, 도서산간/제주의 경우 약 3일 소요)</li>
		<li>물류 및 택배사 사정으로 인해 실제 도착일은 안내된 도착예정일과 다를 수 있습니다. 배송 지연 시 고객센터(1599-3883)로 연락주시면 빠르게 배송될 수 있도록 도와드리겠습니다.</li>
		</ul>
		<h5>우주패스무료반품/교환</h5>
		<ul>
		<li>반품/교환 신청 시 우주패스 가입자인 경우 무료반품/교환 혜택이 적용됩니다. (단, 냉장/냉동 상품의 경우 단순 변심으로 인한 반품/교환 시 혜택 적용이 제한될 수 있으며, 생수 상품은 교환 불가합니다.)</li>
		<li>무료반품/교환 혜택은 택배 송장을 기준으로 각 1회만 적용 됩니다.</li>
		<li>포장을 제거하지 않은 미사용 상품에 한해 무료반품/교환이 가능합니다.</li>
		<li>배송완료일부터 7일 이내 무료반품/교환 신청이 가능합니다.</li>
		</ul>
      </div>
    </div>
  </div>
</div>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <script>
    	var total = function(n) {
    		var price = 1870;
    		//$뒤엔 클래스 아이디 하위선택자 이름을 사용
    		var amount = $(".quantity").attr("value");
    		var amount = parseInt(amount);
    		var amount = amount + n;
    		if (amount < 1) {
    			amount = 1;
    			alert("최소 수량은 1개 입니다");
    		}
    		
    		var tot = price * amount;
    		
    		$(".quantity").attr("value", amount);
    		
    		//정규 표현식
    		var regexp = /\B(?=(\d{3})+(?!\d))/g;
    		var tot = tot.toString().replace(regexp,',');
    		//숫자 3자리씩 , 로 바꾸시오
    		
    		$(".total").html(tot+"원 ("+amount+")개");
    	}
    	
    	total(0);
    	
    	$(".plus").on("click", function() {
    		total(1);
    	})
    	
    	$(".minus").on("click", function() {
    		total(-1);
    	})
    </script>
  </body>
</html>