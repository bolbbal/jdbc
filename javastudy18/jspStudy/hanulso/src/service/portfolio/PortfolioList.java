package service.portfolio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PortfolioVo;
import mapper.PortfolioDao;
import service.Action;
import util.*;

public class PortfolioList implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Criteria cri = new Criteria();
		
		int pageNum = 1;
		int amount = 5;
		
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		String type = "";
		String keyword = "";
		String query = "";
		
		if(request.getParameter("type")!=null && !request.getParameter("keyword").equals("")) {
			
			type = request.getParameter("type");
			keyword = request.getParameter("keyword");
			
			query = type + " like '%" + keyword + "%'";
		}
		
		int count = PortfolioDao.getInstance().getPortfolioCount(query);
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		cri.setType(type);
		cri.setKeyword(keyword);
		
		List<PortfolioVo> list = PortfolioDao.getInstance().portfolioView(cri, query);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("page", pvo);
		
	}

}
