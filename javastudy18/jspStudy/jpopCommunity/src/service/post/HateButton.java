package service.post;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.PostVo;
import mapper.PostDao;
import service.Action;

public class HateButton implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int post_idx = Integer.parseInt(request.getParameter("post_idx"));
		
		PostDao.getInstance().UpdateHatecount(post_idx);
		
		PostVo vo = PostDao.getInstance().selectPopularCount(post_idx);
		
		Integer hate = vo.getHatecount();
		Integer like = vo.getLikecount();
		
		String likecount = like.toString();
		String hatecount = hate.toString();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("hatecount", hatecount);
		map.put("likecount", likecount);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(map);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
	}

}
