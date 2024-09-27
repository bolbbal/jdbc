package service.portfolio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PortfolioVo;
import mapper.PortfolioDao;
import service.Action;

public class PortfolioModifyView implements Action {
	
	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PortfolioVo vo = PortfolioDao.getInstance().selectPortfolioIdx(idx);
		
		request.setAttribute("modify", vo);
	}
	
}
