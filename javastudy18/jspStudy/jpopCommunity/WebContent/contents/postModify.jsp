<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    
    <!-- contents start -->
    <div class = "container post-type">
    	<h3>新着 - 書き</h3>
    </div>
    <div class = "container">
    	<form>
    		<table class="col-md-12 post-write">
    			 <tr class="row">
		    		 	<th class="col-md-2">Nickname</th>
		    		 	<td class="col-md-3"><input type="text" name="writer" class="form-control"></td>
			    		<th class="col-md-2">Password</th>
			    		<td class="col-md-3"><input type="password" name="password" class="form-control"></td>
			    		<th class="col-md-2"></th>
		    	 </tr>	
	    		 <tr class="row">
	    		 	<th class="col-md-2">Title</th>
	    		 	<td class="col-md-10"><input type="text" name="title" class="form-control"></td>
	    		 </tr>
	    		 <tr class="row">
	    		 	<th class="col-md-2">Contents</th>
	    		 	<td class="col-md-10"><textarea name="contents" class="form-control post-write-contents"></textarea></td>
	    		 </tr>
	    		 <tr class="row">
	    		 	<th class="col-md-2">File</th>
	    		 	<td class="col-md-10"><input type="file" name="file" class="form-control"></td>
	    		 </tr>
    		 </table>
    		 <div class="form-group text-center">
				    <div class="text-center">
				      <button type="submit" class="btn btn-default">書き</button>
				      <button type="reset" class="btn btn-default">reset</button>
				      <button type="button" class="btn btn-default" onClick="location.href='/content/list.do';">목록</button>
				    </div>
				  </div>
    	</form>
	</div> <!-- contents end -->
	
<%@ include file="../footer.jsp" %>
    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>