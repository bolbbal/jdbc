package service.post;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import domain.PostSuggestVo;
import domain.PostVo;
import mapper.PostDao;
import service.Action;

public class PostInsert implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savepath = "/upload";
		int maxSize = 20*1024*1024;
		String enctype = "utf-8";
		
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath(savepath);
		
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, enctype, new DefaultFileRenamePolicy());
		
		PostVo postVo = new PostVo();
		PostSuggestVo suggestVo = null;
		
		postVo.setNickname(multi.getParameter("nickname"));
		postVo.setPassword(multi.getParameter("password"));
		postVo.setTitle(multi.getParameter("title"));
		postVo.setContents(multi.getParameter("contents").replace("\r\n", "<br>"));
		postVo.setImgurl(multi.getFilesystemName("imgurl"));
		
		if(Integer.parseInt(multi.getParameter("post_type_idx")) == 2 ) {
			suggestVo = new PostSuggestVo();
			
			suggestVo.setSinger(multi.getParameter("singer"));
			suggestVo.setMusic(multi.getParameter("music"));
			suggestVo.setYoutube_url(multi.getParameter("youtube_url"));
			suggestVo.setThumnail(multi.getFilesystemName("thumnail"));
			suggestVo.setLyrics(multi.getParameter("lyrics").replace("\r\n", "<br>"));
		}
		
		PostDao.getInstance().insertPost(postVo, suggestVo);
	}

}
