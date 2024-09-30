<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
    
    <!-- main visual start -->
   <div class="container main-visual">
    <div class="carousel-wrapper">
	  <a class="left carousel-control" href="#" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
	  
	  <div class="carousel">
	    <div class="carousel-item left-far" data-index="3">Card 4</div>
	    <div class="carousel-item left" data-index="4">Card 5</div>
	    <div class="carousel-item selected" data-index="0">Card 1</div>
	    <div class="carousel-item right" data-index="1">Card 2</div>
	    <div class="carousel-item right-far" data-index="2">Card 3</div>
	  </div>
	  
	  <a class="right carousel-control" href="#" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
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
					      <img src="/images/bansanka.png" alt="">
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
					      <img src="/images/bokunokoto.png" alt="">
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
					<a href="/posts/list.do" >概要欄 ></a>
				  </div>
			  </div>
		  </div>
		  <div class="col-md-4">
		    <div class="list-group popular">
				<h3 class = "list-group-item text-center">今まで多い探された歌手</h3>
				<a href="#" class="list-group-item"><img src = "/images/greenapple.png" alt="" class = "img-circle singer-img">Mrs. GREEN APPLE</a>
				<a href="#" class="list-group-item"><img src = "/images/tuki.png" alt="" class = "img-circle singer-img">tuki.</a>
				<a href="#" class="list-group-item"><img src = "/images/kinggnu.png" alt="" class = "img-circle singer-img">King Gnu</a>
			</div>
		  </div>
		</div>
	</div> <!-- contents end -->
	<script>
		$(document).ready(function () {
		  let currentIndex = 0; // 초기 강조 카드 인덱스 (Card 1)
		  const totalItems = 5;
		
		  function updateCarousel(newIndex) {
		    const items = $(".carousel-item");
		    currentIndex = (newIndex + totalItems) % totalItems;
		
		    items.removeClass("selected left right left-far right-far");
		
		    // 업데이트된 인덱스를 기준으로 클래스 할당
		    items.each(function () {
		      const index = parseInt($(this).attr("data-index"));
		
		      if (index === currentIndex) {
		        $(this).addClass("selected");
		      } else if (index === (currentIndex + 1) % totalItems) {
		        $(this).addClass("right");
		      } else if (index === (currentIndex + 2) % totalItems) {
		        $(this).addClass("right-far");
		      } else if (index === (currentIndex - 1 + totalItems) % totalItems) {
		        $(this).addClass("left");
		      } else if (index === (currentIndex - 2 + totalItems) % totalItems) {
		        $(this).addClass("left-far");
		      }
		    });
		  }
		
		  $(".carousel-control.left").click(function (e) {
		    e.preventDefault();
		    updateCarousel(currentIndex - 1); // 왼쪽 클릭 시 이전 카드로 이동
		  });
		
		  $(".carousel-control.right").click(function (e) {
		    e.preventDefault();
		    updateCarousel(currentIndex + 1); // 오른쪽 클릭 시 다음 카드로 이동
		  });
		
		  updateCarousel(currentIndex); // 초기 상태 업데이트
		});
	</script>
<%@ include file="/footer.jsp" %>