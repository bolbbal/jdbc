package service.portfolio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;

public class Download implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String fileName = request.getParameter("file");
		String directory = request.getServletContext().getRealPath("\\upload");
		
		File file = new File(directory+"\\"+fileName);
		
		String mimeType = request.getServletContext().getMimeType(file.toString());
		System.out.println(mimeType);
		
		String downloadName = new String(fileName.getBytes("EUC-KR"), "8859_1");
	
		response.setHeader("Content-Disposition", "attactment; fileName="+downloadName);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		//파일 읽기
		ServletOutputStream servletOutputStream = response.getOutputStream();
		//출력
		byte[] b = new byte[1024];
		
		int data = 0;
		while((data = (fileInputStream.read(b, 0, b.length))) != -1) {
			//b 크기만큼 0부터 length까지 읽기
			servletOutputStream.write(b, 0, data);
		}
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
	}

}
