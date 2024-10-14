package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.member.CertiCheck;
import service.member.EmailSend;
import service.member.IDCheck;
import service.member.MemberAccess;
import service.member.MemberInsert;
import service.notice.NoticeDelete;
import service.notice.NoticeDetail;
import service.notice.NoticeInsert;
import service.notice.NoticeModify;
import service.notice.NoticeSelect;
import service.notice.NoticeUpdate;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberController() {
        super();
       
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getPathInfo();
		String page = null;
		
		switch(action) {
		case "/terms.do":
			page="/member/memberTerms.jsp";
			break;
		
		case "/member.do":
			page="/member/member.jsp";
			break;
		
		case "/idcheck.do":
			new IDCheck().command(request, response);
			break;
			
		case "/memberpro.do":
			new MemberInsert().command(request, response);
			page = null;
			response.sendRedirect("/");
			break;
			
		case "/emailsend.do":
			new EmailSend().command(request, response);
			break;
			
		case "/certiCheck.do":
			new CertiCheck().command(request, response);
			break;
			
		case "/access.do":
			new MemberAccess().command(request, response);
			break;
			
		case "/login.do":
			page = "/member/login.jsp";
			break;
		}
		
		if(page!=null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
