package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.portfolio.*;

@WebServlet("/port/*")
public class PortfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PortfolioController() {
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
		
		case "/list.do" :
			new PortfolioList().command(request, response);
			page = "/portfolio/list.jsp";
			break;
			
		case "/view.do" :
			new PortfolioView().command(request, response);
			page = "/portfolio/view.jsp";
			break;
			
		case "/write.do" :
			page = "/portfolio/write.jsp";
			break;
			
		case "/save.do" :
			new PortfolioSave().command(request, response);
			page = null;
			response.sendRedirect("/port/list.do");
			break;
			
		case "/modify.do" :
			new PortfolioModifyView().command(request, response);
			page = "portfolio.modify.jsp";
			break;
			
		case "/modifypro.do" :
			
		}
		
		if(page!=null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
