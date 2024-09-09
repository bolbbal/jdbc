<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>JPAT</title>
        
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
	<link href="css/mystyle.css" rel="stylesheet">
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
    						<a href="index.jsp"><img src="images/JPAT.png" alt=""></a>
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
    					<a href="#" class = "login"><span class="material-symbols-outlined">login</span></a>
    					<a href="#" class = "signup"><span class="material-symbols-outlined">person_add</span></a>
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
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float: left; justify-content: flex-start;">
			      <ul class="nav navbar-nav">
			        <li><a href="contents/post.jsp">新着 <span class="sr-only">(current)</span></a></li>
			        <li><a href="#">人気</a></li>
			        <li><a href="#">歌</a></li>
			        <li><a href="#">歌手</a></li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
    	</div> <!-- header nav end -->
    </header> <!-- header end -->
    
    <!-- main visual start -->
    <div class = "container-fluid main-visual">
    	<div class = "container">
    		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="images/slide1.jpg" alt="">
			      <div class="carousel-caption">
			       
			      </div>
			    </div>
			    <div class="item">
			      <img src="images/slide2.jpg" alt="">
			      <div class="carousel-caption">
			       
			      </div>
			    </div>
			    <div class="item">
			      <img src="images/slide3.jpg" alt="">
			      <div class="carousel-caption">
			       
			      </div>
			    </div>
			    <div class="item">
			      <img src="images/slide4.jpg" alt="">
			      <div class="carousel-caption">
			       
			      </div>
			    </div>
			    <div class="item">
			      <img src="images/slide5.jpg" alt="">
			      <div class="carousel-caption">
			       
			      </div>
			    </div>
			  </div>
			
			  <!-- Controls -->
			  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
    	</div>
    </div> <!-- main visual end -->
    
    <!-- contents start -->
    <div class = "container contents">
	    <div class="row">
	    	<div class = "col-md-8">
		    	<div class = "container-fluid new">
		    		<h4>新しいポスト</h4>
				  <div class="col-md-6">
				    <div class="thumbnail">
				    	<a href="#" class="movepost list-group-item">
					      <img src="images/bansanka.png" alt="">
					      <div class="caption">
					        <h3>晩餐歌</h3>
					        <h3>tuki.</h3>
					        <p>
					        
					        <br>
					        <br></p>
					        <p class = "text-right">2024-09-08 赤ちゃん 227 5</p>
					      </div>
				      	</a>
				    </div>
				  </div>
				  <div class="col-md-6">
				    <div class="thumbnail">
				    	<a href="#" class="movepost list-group-item">
					      <img src="images/bokunokoto.png" alt="">
					      <div class="caption">
					        <h3>僕のこと</h3>
					        <h3>Mrs. GREEN APPLE</h3>
					        <p>
					        
					        <br>
					        <br></p>
					        <p class = "text-right">2024-09-08 Jesmon 187 7</p>
					      </div>
				      	</a>
				    </div>
				  </div>
				  <div class="text-right moveall">
					<a href="contents/post.jsp" >概要欄 ></a>
				  </div>
			  </div>
		  </div>
		  <div class="col-md-4">
		    <div class="list-group popular">
				<h3 class = "list-group-item text-center">今まで多い探された歌手</h3>
				<a href="#" class="list-group-item"><img src = "images/greenapple.png" alt="" class = "img-circle singer-img">Mrs. GREEN APPLE</a>
				<a href="#" class="list-group-item"><img src = "images/tuki.png" alt="" class = "img-circle singer-img">tuki.</a>
				<a href="#" class="list-group-item"><img src = "images/kinggnu.png" alt="" class = "img-circle singer-img">King Gnu</a>
			</div>
		  </div>
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
    

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>