package service.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.NoticeVo;
import mapper.NoticeDao;
import service.Action;
import util.Criteria;
import util.PageVo;
import util.SearchVo;

public class NoticeSelect implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		Criteria cri = new Criteria();
		
		int pageNum = 1;
		
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		String type = "";
		String keyword = "";
		String query = "";
		
		if(request.getParameter("type")!=null && !request.getParameter("keyword").equals("")) {
			
			type = request.getParameter("type");
			keyword = request.getParameter("keyword");
			
			query = type + " like '%"+keyword+"%'";
		}
		
		cri.setPageNum(pageNum);
		cri.setType(type);
		cri.setKeyword(keyword);
		
		//List<NoticeVo> list = NoticeDao.getInstance().noticeSelect();
		//List<Map<String, Object>> list = NoticeDao.getInstance().noticeMapSelect();
		
		List<NoticeVo> list = NoticeDao.getInstance().noticeSelectWithPage(cri, query);
		
		int count = NoticeDao.getInstance().selectPostCount(query);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("page", pvo);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
	}

}
