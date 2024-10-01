package service.portfolio;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import domain.PortfolioVo;
import mapper.PortfolioDao;
import service.Action;

public class PortfolioUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savepath = "/upload";
		int maxSize = 20*1024*1024;
		String enctype = "utf-8";
		
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath(savepath);
		
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, enctype, new DefaultFileRenamePolicy());
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PortfolioVo oldVo = PortfolioDao.getInstance().selectPortfolioIdx(idx);
		PortfolioVo vo = new PortfolioVo();
		
		vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
		vo.setTitle(multi.getParameter("title"));
		vo.setContent(multi.getParameter("content").replace("\r\n", "<br>"));
		
		if(multi.getParameter("imgurl").equals(null)) {
			vo.setImgurl(oldVo.getImgurl());
		} else {
			vo.setImgurl(multi.getFilesystemName("imgurl"));
		}
		
		PortfolioDao.getInstance().updatePortfolio(vo);
	}

}
