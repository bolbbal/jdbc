package service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PostVo;
import mapper.PostDao;
import service.Action;

public class PostUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		PostVo vo = new PostVo();
		
		vo.setTitle(request.getParameter("title"));
		vo.setSinger(request.getParameter("singer"));
		vo.setContents(request.getParameter("contents"));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		PostDao.getInstance().PostContentsUpdate(vo);
	}

}
