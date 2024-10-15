package service.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("login", id);
			response.sendRedirect("/");
		} else if(result == 0 || result == -1) {
			String msg = "아이디 또는 패스워드 확인 바랍니다";
			response.sendRedirect("/mem/login.do?msg=" + URLEncoder.encode(msg, "utf-8"));
		}

	}

}
