package service.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ReplyVo;
import mapper.ReplyDao;
import service.Action;

public class ReplySave implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int post_idx = Integer.parseInt(request.getParameter("post_idx"));
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String comment = request.getParameter("comment").replace("\r\n", "<br>");
		
		ReplyVo vo = new ReplyVo();
		
		vo.setPostIdx(post_idx);
		vo.setNickname(nickname);
		vo.setReply_password(password);
		vo.setComment(comment);
		
		ReplyDao.getInstance().insertReply(vo);
	}

}
