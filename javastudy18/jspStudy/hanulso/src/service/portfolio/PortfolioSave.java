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

public class PortfolioSave implements Action {
	
	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String savepath = "/upload";
		int maxSize = 20*1024*1024; //최대 업로드 파일 크기 20mb
		String enctype = "utf-8";
		
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath(savepath);
		System.out.println("서버 상의 실제 디렉토리 : " + path);
		
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, enctype, new DefaultFileRenamePolicy()); //동일한 파일이 존재하면 새로운 이름을 부여하여 업로드됨
		
		PortfolioVo vo = new PortfolioVo();
		
		vo.setWriter(multi.getParameter("writer"));
		vo.setTitle(multi.getParameter("title"));
		vo.setContent(multi.getParameter("content").replace("\r\n", "<br>"));
		vo.setImgurl(multi.getFilesystemName("imgurl")); //실제 서버에 업로드된 파일명을 구한다
		
		PortfolioDao.getInstance().insertPortfolio(vo);
	}
}
