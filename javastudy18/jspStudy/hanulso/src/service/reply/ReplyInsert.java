package service.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.ReplyVo;
import mapper.ReplyDao;
import service.Action;

public class ReplyInsert implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int port_idx = Integer.parseInt(request.getParameter("pidx"));
		int member_idx = Integer.parseInt(request.getParameter("member_idx"));
		String reply = request.getParameter("cmtContent");
		
		ReplyVo vo = new ReplyVo();
		
		vo.setPort_idx(port_idx);
		vo.setMember_idx(member_idx);
		vo.setReply(reply);
		
		ReplyDao.getInstance().insertReply(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("msg", "success");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(map);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
	}

}
