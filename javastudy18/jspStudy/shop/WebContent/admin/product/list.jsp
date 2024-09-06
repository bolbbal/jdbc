<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>admin</title>

    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/admin.css" rel="stylesheet">
    

    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<div class = "container-fluid">
		<div class = "row">
			<div class = "col-md-2">
				<h2>ADMIN</h2>
				<ul class = "list-group">
					<li class = "list-group-item"><a href = "">상품관리</a></li>
					<li class = "list-group-item"><a href = "">리뷰관리</a></li>
					<li class = "list-group-item"><a href = "">질문답변</a></li>
					<li class = "list-group-item"><a href = "">공지사항</a></li>
					<li class = "list-group-item"><a href = "">로그아웃</a></li>
				</ul>
			</div>
			<div class = "col-md-10">
				<h2>상품 검색</h2>
				<form class="form-inline">
				  <div class="form-group">
				    <label for="item">상품명</label>
				    <input type="text" class="form-control" id="item" placeholder="검색상품 입력">
				  </div>
				  <button type="submit" class="btn btn-default">검색</button>
				</form>
				<table class = "table">
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>이미지</th>
						<th>원가</th>
						<th>판매가</th>
						<th>등록일</th>
						<th>사용유무</th>
					</tr>
					<tr>
						<td>1</td>
						<td>좋상</td>
						<td></td>
						<td>50,000</td>
						<td>70,000</td>
						<td>2024-09-06</td>
						<td>미개봉중고</td>
					</tr>
				</table>
				<nav aria-label="...">
				  <ul class="pagination">
				    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				    <li><a href="#">2 <span class="sr-only">(current)</span></a></li>
				    <li><a href="#">3 <span class="sr-only">(current)</span></a></li>
				    <li><a href="#">4 <span class="sr-only">(current)</span></a></li>
				    <li><a href="#">5 <span class="sr-only">(current)</span></a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
 
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
  </body>
</html>