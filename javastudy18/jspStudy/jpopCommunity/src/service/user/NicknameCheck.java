package service.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mapper.UserDao;
import service.Action;

public class NicknameCheck implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String nickname = request.getParameter("nickname");
		
		String result = UserDao.getInstance().getUserNickname(nickname);
		System.out.println(result);
		Map<String, String> map = new HashMap<String, String>();
		Gson gson = new Gson();
		
		map.put("result", result);
		
		String json = gson.toJson(map);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());		
	}

}
