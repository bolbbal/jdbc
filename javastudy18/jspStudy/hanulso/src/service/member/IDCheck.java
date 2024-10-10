package service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapper.MemberDao;
import service.Action;

public class IDCheck implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		String result = MemberDao.getInstance().selectID(id);

		//write()는 문자열 형식으로 쓰는 메소드
		//int 타입으로 받았다면
		//String.valueOf(result) 사용했어도 됨
		response.getWriter().write(result);
	}

}
