package service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PostVo;
import mapper.PostDao;
import service.Action;

public class PostInsert implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		PostVo vo = new PostVo();
		
		vo.setNickname(request.getParameter("nickname"));
		vo.setPassword(request.getParameter("password"));
		vo.setTitle(request.getParameter("title"));
		vo.setSinger(request.getParameter("singer"));
		vo.setContents(request.getParameter("contents"));
		
		PostDao.getInstance().insertPost(vo);
	}

}
