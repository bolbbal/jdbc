package service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVo;
import mapper.MemberDao;
import service.Action;

public class MemberInsert implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		MemberVo vo = new MemberVo();
		
		vo.setName(request.getParameter("name"));
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("pw1"));
		vo.setPhone(request.getParameter("phone1") + request.getParameter("phone2") + request.getParameter("phone3"));
		vo.setEmail(request.getParameter("email"));
		
		MemberDao.getInstance().insertMember(vo);
	}

}
