package service.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.NoticeVo;
import mapper.NoticeDao;
import service.Action;

public class NoticeUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		NoticeVo vo = new NoticeVo();
		
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		NoticeDao.getInstance().noticeDetailUpdate(vo);
	}

}
