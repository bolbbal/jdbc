package service.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.NoticeVo;
import mapper.NoticeDao;
import service.Action;

public class NoticeSelect implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		List<NoticeVo> list = NoticeDao.getInstance().noticeSelect();
		int count = NoticeDao.getInstance().selectPostCount();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
	}

}
