package service.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVo;
import mapper.MemberDao;
import service.Action;
import util.SecurityPassword;

public class IdPwSearch implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = SecurityPassword.encoding(request.getParameter("pw"));
		
		int result = MemberDao.getInstance().getSelectIdPw(id, pw);
		HttpSession session = request.getSession();
		if(result == 1) {
			MemberVo vo = MemberDao.getInstance().SetID(id);
			session.setAttribute("login", vo);
			response.sendRedirect("/");
		} else if(result == 0 || result == -1) {
			session.setAttribute("msg", "아이디 또는 패스워드 확인");
			response.sendRedirect("/mem/login.do");
		}

	}

}
