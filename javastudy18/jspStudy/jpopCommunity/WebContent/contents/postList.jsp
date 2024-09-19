<%@ include file="../header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>新着</h3>
    	<div class="nav navbar-nav navbar-right dropdown-style">
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
    </div>
    <div class = "container">
	    <div class="row post">
	    	<a href="/content/detail.do">
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
	</div>
	<div class="container text-center">
		<nav aria-label="Page navigation">
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
	<!-- contents end -->
	
<%@ include file="../footer.jsp" %>
    

    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>