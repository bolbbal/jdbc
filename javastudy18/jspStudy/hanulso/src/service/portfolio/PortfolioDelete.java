package service.portfolio;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PortfolioVo;
import mapper.PortfolioDao;
import service.Action;

public class PortfolioDelete implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savePath = "/upload";
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PortfolioVo vo = PortfolioDao.getInstance().selectPortfolioIdx(idx);
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(savePath);
		
		PortfolioDao.getInstance().deletePortfolio(vo, path);
	}

}
