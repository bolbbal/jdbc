<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "Model.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Connection conn = DBManager.getInstance().getDBManager();
		if (conn != null) { %>
		<p>DB연결성공</p>
	<% } else { %>
		<p>DB연결실패</p>
	<% } %>
</body>
</html>