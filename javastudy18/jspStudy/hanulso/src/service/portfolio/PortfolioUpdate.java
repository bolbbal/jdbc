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
import com.oreilly.servlet.multipart.FileRenamePolicy;

import domain.PortfolioVo;
import mapper.PortfolioDao;
import service.Action;

public class PortfolioUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savepath = "/upload";
	
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath(savepath);
		
		//파일 업로드 처리
		Part image = request.getPart("image");
		String fileName = image.getSubmittedFileName();
		String originalImg = request.getParameter("imgurl");
		
		if(fileName != null && !fileName.isEmpty()) { //첨부파일 처리
			
			String realPath = fileName.substring(0, fileName.lastIndexOf("."));
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString();
			
			fileName = realPath + "_" + uuid + ext;
			
			image.write(path + File.separator + fileName); //첨부파일 업로드
		} else { //첨부파일 안했을 때 기존 이미지
			fileName = originalImg;
			
		}
		
		PortfolioVo vo = new PortfolioVo();
		
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content").replace("\r\n", "<br>"));
		vo.setImgurl(fileName);
		
		PortfolioDao.getInstance().updatePortfolio(vo);
	}

}
