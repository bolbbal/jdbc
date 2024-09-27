package service.portfolio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PortfolioVo;
import mapper.PortfolioDao;
import service.Action;

public class PortfolioView implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PortfolioDao.getInstance().updatePortfolioViewCount(idx);
		
		PortfolioVo vo = PortfolioDao.getInstance().selectPortfolioIdx(idx);
		
		request.setAttribute("view", vo);
	}

}
