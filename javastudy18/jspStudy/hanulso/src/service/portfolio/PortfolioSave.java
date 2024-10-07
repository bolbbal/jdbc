package service.portfolio;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		
		
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath(savepath);
		
		Part imgurl = request.getPart("imgurl");
		String fileName = imgurl.getSubmittedFileName();
		
		if(fileName != null && !fileName.isEmpty()) { //첨부파일 처리
			
			String realPath = fileName.substring(0, fileName.lastIndexOf("."));
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString();
			
			fileName = realPath + "_" + uuid + ext;
			
			imgurl.write(path + File.separator + fileName); //첨부파일 업로드
		}
		
		PortfolioVo vo = new PortfolioVo();
		
		vo.setWriter(request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content").replace("\r\n", "<br>"));
		vo.setImgurl(fileName); //실제 서버에 업로드된 파일명을 구한다
		
		PortfolioDao.getInstance().insertPortfolio(vo);
	}
}
