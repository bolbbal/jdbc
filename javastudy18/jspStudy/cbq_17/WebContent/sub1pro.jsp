<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	request.setCharacterEncoding("utf-8");

	ShopVo vo = new ShopVo();
	
	vo.setCustno(Integer.parseInt(request.getParameter("custno")));
	vo.setCustname(request.getParameter("custname"));
	vo.setPhone(request.getParameter("phone"));
	vo.setAddress(request.getParameter("address"));
	vo.setJoindate(request.getParameter("joindate"));
	vo.setGrade(request.getParameter("grade"));
	vo.setCity(request.getParameter("city"));
	
	ShopDao dao = new ShopDao();
	dao.insertMember(vo);
	
	response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>