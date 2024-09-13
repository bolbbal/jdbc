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
    	<div class = "row">
    		<div class = "col-md-2"></div>
    		<div class = "col-md-8">
    			<h3 class = "text-center">新規登録</h3>
    			<form class="form-horizontal">
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputEmail3" placeholder="ID" style="width:88%; display:inline-block;">
				      <button type="button" class="btn btn-default">Check</button>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">Password Check</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="inputPassword3" placeholder="Password Check">
				    </div>
				  </div>
				  <div class="form-group text-center">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">登録</button>
				      <button type="reset" class="btn btn-default">reset</button>
				    </div>
				  </div>
				</form>
    		</div>
    		<div class = "col-md-2"></div>
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