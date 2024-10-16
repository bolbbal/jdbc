package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/content/*")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		System.out.println(action);
		switch(action) {
		case "/list.do" :
			page="/contents/postList.jsp";
			break;
		
		case "/detail.do" :
			page="/contents/postDetail.jsp";
			break;
			
		case "/write.do" :
			page="/contents/postWrite.jsp";
			break;
		}
		
		System.out.println(page);
		if(page!=null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
