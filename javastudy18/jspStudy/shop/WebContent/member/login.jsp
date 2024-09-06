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
					<div class = "membership">
						<h2>Sign Up</h2>
						<form class="form-horizontal">
						  <div class="form-group">
						    <label for="id" class="col-sm-2 control-label">ID</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="id" placeholder="Enter your ID"">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">Password</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" id="password" placeholder="Enter your password">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-success">Login</button>
						      <button type="reset" class="btn btn-warning">ReWrite</button>
						    </div>
						  </div>
						</form>
					</div> <!-- membership end -->
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
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>