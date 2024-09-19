package service.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.NoticeVo;
import mapper.NoticeDao;
import service.Action;

public class NoticeDetail implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeVo vo = NoticeDao.getInstance().getSelectIdx(idx);
		
		request.setAttribute("view", vo);
	}

}
