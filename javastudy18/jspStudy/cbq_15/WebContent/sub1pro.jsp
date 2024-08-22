<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	
	request.setCharacterEncoding("utf-8");
	ShopDao dao = new ShopDao();
	ShopVo vo = new ShopVo();
	
	int custno = Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	if(!(phone.substring(3,4).equals("-")) && !(phone.substring(8,9).equals("-"))) {
		phone = phone.substring(0,3) + "-" + phone.substring(3,7) +"-"+phone.substring(7);		
	}
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	vo.setCustno(custno);
	vo.setCustname(custname);
	vo.setPhone(phone);
	vo.setAddress(address);
	vo.setJoindate(joindate);
	vo.setGrade(grade);
	vo.setCity(city);
	
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