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
	String sname = request.getParameter("sname");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	
	ScoreVo vo = new ScoreVo();
	vo.setSyear(syear);
	vo.setSclass(sclass);
	vo.setSno(sno);
	vo.setSname(sname);
	vo.setBirth(birth);
	vo.setGender(gender);
	vo.setTel1(tel1);
	vo.setTel2(tel2);
	vo.setTel3(tel3);
	
	ScoreDao dao = new ScoreDao();
	dao.insertStudent(vo);
	
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