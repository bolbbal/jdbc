package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BlogController
 */
@WebServlet("*.do")
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request,response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = uri.substring(contextPath.length());
		System.out.println(command);
		
		String path = null;
		
		switch(command) {
		case "/list.do":
			path="/blog/list.jsp";
			break;
		case "/view.do":
			path="/blog/view.jsp";
			break;
		case "/write.do":
			path="/blog/write.jsp";
			break;
		case "/login.do":
			path="/member/login.jsp";
			break;
		case "/introduce.do":
			path="/about/introduce.jsp";
			break;
		case "/concat.do":
			path="/concat/concat.jsp";
			break;
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
