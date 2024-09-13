package service.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.NoticeVo;
import mapper.NoticeDao;
import service.Action;

public class NoticeInsert implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		NoticeVo vo = new NoticeVo();
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		NoticeDao.getInstance().noticeInsert(vo);
	}

}
