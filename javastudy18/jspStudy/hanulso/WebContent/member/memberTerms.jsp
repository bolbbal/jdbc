<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp"%>
	<!-- sub contents -->
   <div class="sub_title">
      <h2>회원 약관</h2>
      <div class="container">
        <div class="location">
         <ul>
            <li class="btn_home">
               <a href="/np/"><i class="fa fa-home btn_plus"></i></a>
            </li>
            <li class="dropdown">
               <a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
               <div class="dropdown_menu">
                  <a href="/np/list.do">공지사항</a>
                  <a href="allclass.html">학과및모집안내</a>
                  <a href="portfolio.html">포트폴리오</a>
                  <a href="online.html">온라인접수</a>
                  <a href="notice.html">커뮤니티</a>
               </div>
            </li>
            <li class="dropdown">
               <a href="/np/list.do">공지사항<i class="fa fa-plus btn_plus"></i></a>
               <div class="dropdown_menu">
                  <a href="/np/list.do">공지사항</a>
                  <a href="qa.html">질문과답변</a>
                  <a href="faq.html">FAQ</a>
               </div>
            </li>
         </ul>
        </div>
      </div><!-- container end -->
   </div>
   
   <div class="container">
   		<h2 style="padding:30px 0;">회원약관</h2>
   		<input type="checkbox" class="agreeAll" name="chkCtrl" id="chkCtrl" value="t">
   		Hanulso 이용약관 모두 동의합니다.
   </div>
   
<%@ include file = "/footer.jsp"%>