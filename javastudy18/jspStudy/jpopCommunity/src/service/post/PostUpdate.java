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

public class PostUpdate implements Action {

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
		postVo.setContents(multi.getParameter("contents"));
		postVo.setImgurl(multi.getFilesystemName("imgurl"));
		
		if(multi.getParameter("post_type_idx").equals(2)) {
			suggestVo.setSinger(multi.getParameter("singer"));
			suggestVo.setMusic(multi.getParameter("music"));
			suggestVo.setYoutube_url(multi.getParameter("youtube_url"));
			suggestVo.setThumnail(multi.getFilesystemName("thumnail"));
		}
		
		PostDao.getInstance().insertPost(postVo, suggestVo);
	}

}
