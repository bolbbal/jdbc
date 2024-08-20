<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = DBManager.getInstance().getDBManager();
		if (conn != null) {
	%>
		<p>DB접속 되었습니다.</p>
	<% } else { %>
		<p>DB접속 에러 발생</p>
	<% } %>
</body>
</html>