package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.post.BestPost;
import service.post.LikeButton;
import service.post.PostInsert;
import service.post.PostList;
import service.post.PostUpdate;
import service.post.PostView;
import service.post.HateButton;
import service.post.PostModify;

@WebServlet("/posts/*")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2, 
		maxFileSize = 1024*1024*20, 
		maxRequestSize = 1024*1024*100 
)
public class PostController extends HttpServlet {
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
		System.out.println(action);
		String page = null;
		
		switch(action) {
		case "/list.do" :
			new PostList().command(request, response);
			page="/post/post.jsp";
			break;
		
		case "/view.do" :
			new PostView().command(request, response);
			page="/post/postView.jsp";
			break;
			
		case "/write.do" :
			page="/post/postWrite.jsp";
			break;
			
		case "/writepro.do" :
			new PostInsert().command(request, response);
			page=null;
			response.sendRedirect("/posts/list.do");
			break;
			
		case "/modify.do" :
			new PostModify().command(request, response);
			page="/post/postModify.jsp";
			break;
			
		case "/modifypro.do" :
			new PostUpdate().command(request, response);
			page=null;
			response.sendRedirect("/posts/list.do");
			break;
		
		case "/best.do" :
			new BestPost().command(request, response);
			page = "/post/bestPost.jsp";
			break;
		
		case "/suggest.do" :
			new PostList().command(request, response);
			page="/post/postSuggestList.jsp";
			break;
			
		case "/like.do" :
			new LikeButton().command(request, response);
			break;
			
		case "/hate.do" :
			new HateButton().command(request, response);
			break;
		
		
//		case "/reply.do" :
//			new replyButton().command(request, response);
//			break;
		}
		
		if(page!=null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
