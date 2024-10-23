package service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;
import mapper.MainDao;
import service.Action;

public class MainService implements Action {
	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		List<PostAndSuggestVo> newList = MainDao.getInstance().getRecentlyPost();
		
		request.setAttribute("newList", newList);
	}
}
