<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<% 
	request.setCharacterEncoding("utf-8");
	
	String syear = request.getParameter("syear");
	String sclass = request.getParameter("sclass");
	String sno = request.getParameter("sno");
	
	int kor = Integer.parseInt(request.getParameter("kor"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	
	ScoreVo vo = new ScoreVo();
	vo.setSyear(syear);
	vo.setSclass(sclass);
	vo.setSno(sno);
	vo.setKor(kor);
	vo.setEng(eng);
	vo.setMat(mat);
	
	ScoreDao dao = new ScoreDao();
	dao.insertScore(vo);
	
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