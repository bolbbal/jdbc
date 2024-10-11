package service.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.Action;

public class CertiCheck implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String certinum = request.getParameter("certinumber");
		String authenKey = (String) request.getSession().getAttribute("authenticationKey");
		
		Map<String, String> map = new HashMap<String, String>();
		
		Gson gson = new Gson();
		
		if(certinum.equals(authenKey)) {
			map.put("msg", "인증번호 일치");
			map.put("check", "ok");
		} else {
			map.put("msg", "인증번호 불일치");
			map.put("check", "nok");
		}
		
		String json = gson.toJson(map);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
	}

}
