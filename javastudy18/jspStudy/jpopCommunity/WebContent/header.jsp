<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>JPAT</title>
        
    <link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
	<link href="/css/mystyle.css" rel="stylesheet">
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
    						<a href="/"><img src="/images/JPAT.png" alt=""></a>
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
			        <li><a href="/content/list.do">新着 <span class="sr-only">(current)</span></a></li>
			        <li><a href="#">人気</a></li>
			        <li><a href="#">歌</a></li>
			        <li><a href="#">歌手</a></li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
    	</div> <!-- header nav end -->
    </header> <!-- header end -->