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

		response.setContentType("application/json");
		
		response.getWriter().write(result);
	}

}
