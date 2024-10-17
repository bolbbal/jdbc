package service.post;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import domain.PostSuggestVo;
import domain.PostVo;
import domain.UserVo;
import mapper.PostDao;
import service.Action;

public class PostInsert implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savepath = "/upload";
		
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath(savepath);
		PostVo postVo = new PostVo();
		PostSuggestVo suggestVo = null;
		
		Part imgurl = request.getPart("imgurl");
		String imgName = imgurl.getSubmittedFileName();
		
		if(imgName != null && !imgName.isEmpty()) {
			String realPath = imgName.substring(0, imgName.lastIndexOf("."));
			String ext = imgName.substring(imgName.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString();
			
			imgName = realPath + "_" + uuid + ext;
			
			imgurl.write(path + File.separator + imgName);
		}
		
		postVo.setTitle(request.getParameter("title"));
		postVo.setContents(request.getParameter("contents").replace("\r\n", "<br>"));
		postVo.setPost_type_idx(Integer.parseInt(request.getParameter("post_type_idx")));
		postVo.setImgurl(imgName);
		
		if(Integer.parseInt(request.getParameter("post_type_idx")) == 2 ) {
			suggestVo = new PostSuggestVo();
			
			suggestVo.setSinger(request.getParameter("singer"));
			suggestVo.setMusic(request.getParameter("music"));
			suggestVo.setYoutube_url(request.getParameter("youtube_url"));
			suggestVo.setLyrics(request.getParameter("lyrics").replace("\r\n", "<br>"));
			suggestVo.setThumnail(request.getParameter("thumnail"));
		}
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			UserVo userVo = (UserVo) session.getAttribute("user");
			
			if(userVo != null) {
				int currentPostIdx = PostDao.getInstance().currentPostIdx();
				PostDao.getInstance().insertPostSuggest(suggestVo, currentPostIdx);
			}
			
			
		} else {
			postVo.setNickname(request.getParameter("nickname"));
			postVo.setPassword(request.getParameter("password"));
			PostDao.getInstance().insertPost(postVo, suggestVo);
		}
		
		
//			Part thumnail = request.getPart("thumnail");
//			String thumName = thumnail.getSubmittedFileName();
//			
//			if(thumName != null && !thumName.isEmpty()) {
//				String realPath = thumName.substring(0, thumName.lastIndexOf("."));
//				String ext = thumName.substring(thumName.lastIndexOf("."));
//				String uuid = UUID.randomUUID().toString();
//				
//				thumName = realPath + "_" + uuid + ext;
//				
//				imgurl.write(path + File.separator + thumName);
//			}
//			System.out.println(thumName);
//			suggestVo.setThumnail(thumName);
		
		
		
	}

}
