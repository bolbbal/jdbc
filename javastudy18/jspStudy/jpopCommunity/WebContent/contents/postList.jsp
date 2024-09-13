<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>JPAT</title>
        
    <link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
	<link href="../css/mystyle.css" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
	
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <header id = "header">
    	<div class = "header-index">
    		<div class = "container">
    			<div class = "row">
    				<div class = "col-md-3">
    					<div class="logo">
    						<a href="index.jsp"><img src="../images/JPAT.png" alt=""></a>
    					</div>
    				</div>
    				<div class = "col-md-6 site-search text-center">
    					<form class="navbar-form" role="search">
						  <div class="form-group">
						    <input type="text" class="form-control" placeholder="Search">
						  </div>
						  <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
						</form>
    				</div>
    				<div class = "col-md-3 member text-right">
    					<a href="#" class = "login"><span class="material-symbols-outlined" title="ログイン">login</span></a>
    					<a href="#" class = "signup"><span class="material-symbols-outlined" title="新規登録">person_add</span></a>
    				</div>
    			</div>
    		</div>
    	</div> <!-- header top end-->
    	
    	<!-- header nav start -->
    	<div class = "container">
    		<nav class="navbar navbar-default">
			  <div class="container" style="margin:10px 0;">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse navbar-left" id="bs-example-navbar-collapse-1" style="float: left; justify-content: flex-start;">
			      <ul class="nav navbar-nav">
			        <li><a href="#">新着 <span class="sr-only">(current)</span></a></li>
			        <li><a href="#">人気</a></li>
			        <li><a href="#">歌</a></li>
			        <li><a href="#">歌手</a></li>
			      </ul>
			    </div>
			    <div class="nav navbar-nav navbar-right">
			      <div class="dropdown">
					  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					    sort option
					    <span class="caret"></span>
					  </button>
					  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					    <li><a href="#">view asc</a></li>
					    <li><a href="#">view desc</a></li>
					    <li role="separator" class="divider"></li>
					    <li><a href="#">like asc</a></li>
					    <li><a href="#">like desc</a></li>
					    <li role="separator" class="divider"></li>
					    <li><a href="#">date asc</a></li>
					    <li><a href="#">date desc</a></li>
					  </ul>
					</div>
			      </div>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			
    	</div> <!-- header nav end -->
    </header> <!-- header end -->
    
    <!-- contents start -->
    <div class = "container">
	    <div class="row post">
	    	<a href="#">
		  		<div class="col-md-3">
		      		<img src="../images/shutter.png" alt="" class="thumbnail music-thumbnail">
		      	</div>
		      	<div class="col-md-5">
		      		<h3>Shutter | 優里</h3>
		      		<p>君と見るずだった花火が<br>
		      		夜の隙間を埋めてく<br>
		      		感傷にひたっちまうから<br>
		      		Twitterは閉じた</p>
		      	</div>
		      	<div class="col-md-2">
		      		<img src="../images/maple.png" alt="" class="img-circle member-img">
		      	</div>
		      	<div class="col-md-2 writer">
		      		<p>maplelove</p>
		      		<p>2024-09.08<br><br><br></p>
		      		<p class="text-right">173 / 7</p>
		      	</div>
		    </a>
		  </div>
		  <div class="row post">
	    	<a href="#">
		  		<div class="col-md-3">
		      		<img src="../images/115man.png" alt="" class="thumbnail music-thumbnail">
		      	</div>
		      	<div class="col-md-5">
		      		<h3>115万キロのｈフィルム | Official髭男dism</h3>
		      		<p>これから歌う曲の内容は<br>
		      		僕の頭の中のこと<br>
		      		主演はもちろん君で<br>
		      		僕は助演で監督でカメラマン</p>
		      	</div>
		      	<div class="col-md-2 singer-img" style="display:inline-block;">
		      		<img src="" alt="" class="img-circle member-img">
		      	</div>
		      	<div class="col-md-2 writer">
		      		<p>ww</p>
		      		<p>2024-09.08<br><br><br></p>
		      		<p class="text-right">219 / 8</p>
		      	</div>
		    </a>
		  </div>
		  <div class="row post">
	    	<a href="#">
		  		<div class="col-md-3">
		      		<img src="../images/tsukimisou.png" alt="" class="thumbnail music-thumbnail">
		      	</div>
		      	<div class="col-md-5">
		      		<h3>ツキミソウ | Novelbright</h3>
		      		<p>出会いと別れ繰り返す度<br>
		      		心をすり減らす<br>
		      		記憶をかき分けた先に<br>
		      		滲んだ思い出が待つ</p>
		      	</div>
		      	<div class="col-md-2 singer-img" style="display:inline-block;">
		      		<img src="../images/dog.png" alt="" class="img-circle member-img">
		      	</div>
		      	<div class="col-md-2 writer">
		      		<p>赤ちゃん</p>
		      		<p>2024-09.07<br><br><br></p>
		      		<p class="text-right">253 / 11</p>
		      	</div>
		    </a>
		  </div>
	</div> <!-- contents end -->
	
	<!-- footer start -->
	<footer>
		<div class="container-fluid footer">
			<div class="container text-center">
				<p></p>
				<a href="#">About</a>
				<a href="#">Concat</a>
				<a href="#" style="border: none;">미정</a>
				<p style="padding-top:10px;">コンテンツの無断複写、転載を禁じます。</p>
				<p>Copyright&copy;2024 JPAT. All rights reserved.
			</div>
		</div>
	</footer> <!-- footer end -->
    

    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>