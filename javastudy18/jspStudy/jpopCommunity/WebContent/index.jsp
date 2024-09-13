<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
    
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
					<a href="contents/postList.jsp" >概要欄 ></a>
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
<%@ include file="footer.jsp" %>