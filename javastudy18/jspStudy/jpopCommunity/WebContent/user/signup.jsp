<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    
    <!-- contents start -->
    <div class = "container">
    	<div class = "row">
    		<div class = "col-md-2"></div>
    		<div class = "col-md-8">
    			<h3 class = "text-center">新規登録</h3>
    			<form class="form-horizontal signup">
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputEmail3" placeholder="ID" style="display:inline-block;">
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
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Nickname</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputEmail3" placeholder="Nickname" style="display:inline-block;">
				      <button type="button" class="btn btn-default">Check</button>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email address</label>
				    <input type="email" class="form-control" id="inputEmail3" placeholder="Email" style="display:inline-block;">
				    <button type="button" class="btn btn-default">Check</button>
				  </div>
				  <div class="form-group text-center">
				    <div class="text-center">
				      <button type="submit" class="btn btn-default">登録</button>
				      <button type="reset" class="btn btn-default">reset</button>
				    </div>
				  </div>
				</form>
    		</div>
    		<div class = "col-md-2"></div>
		</div>
	</div> <!-- contents end -->
	
<%@ include file="../footer.jsp" %>
    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>