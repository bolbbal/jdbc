package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.notice.NoticeInsert;
import service.notice.NoticeSelect;

@WebServlet("/np/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		String page = null;
		
		switch(action) {
		case "/list.do":
			new NoticeSelect().command(request, response);
			page="/notice/list.jsp";
			break;
		
		case "/write.do":
			page="/notice/write.jsp";
			break;
			
		case "/modify.do":
			page="/notice/modify.jsp";
			break;
			
		case "/view.do":
			page="/notice/view.jsp";
			break;
		case "/writepro.do":
			new NoticeInsert().command(request, response);
			page=null;
			response.sendRedirect("/np/list.do");
			break;
		}
		
		if(page!=null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
