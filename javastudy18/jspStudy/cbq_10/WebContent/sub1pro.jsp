<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>

<%
	//클라이언트로부터 저장하는 값이 넘어오면 
//요청(request)하는 모든 값을 utf-8로 인코딩한다
request.setCharacterEncoding("utf-8");
ShopDao dao = new ShopDao();
ShopVo vo = new ShopVo();
//request.getParament(); 메소드를 이용해 요청받은 값을 자바 변수에 저장한다
int custno = Integer.parseInt(request.getParameter("custno"));
String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
if(!(phone.substring(3,4).equals("-")) && !(phone.substring(7,8).equals("-"))) {
	phone = phone.substring(0,3) + "-" + phone.substring(3,7) + "-" + phone.substring(7);
}
String address = request.getParameter("address");
String joindate = request.getParameter("joindate");
String grade = request.getParameter("grade");
String city = request.getParameter("city");
//자바변수에 저장된 값을 Vo객체의 멤버변수에 저장한다

vo.setCustno(custno);
vo.setCustname(custname);
vo.setPhone(phone);
vo.setAddress(address);
vo.setJoindate(joindate);
vo.setGrade(grade);
vo.setCity(city);
//Vo객체 Dao객체의 입력 메서드로 보내어 저장한다

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