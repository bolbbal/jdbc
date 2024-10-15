package service.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.MemberVo;
import mapper.MemberDao;
import service.Action;
import util.SecurityPassword;

public class MemberAccess implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw1");
		String newPassword = SecurityPassword.encoding(pw);
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setId(id);
		vo.setPassword(newPassword);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		MemberDao.getInstance().insertMember(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "가입 완료");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(map);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
	}

}
