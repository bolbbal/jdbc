package service.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PostVo;
import mapper.PostDao;
import service.Action;

public class PostView implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PostDao.getInstance().UpdateViewcount(idx);
		PostVo vo = PostDao.getInstance().getPostSelect(idx);
		
		request.setAttribute("view", vo);
	}

}
