package service.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import domain.UserVo;
import mapper.UserDao;
import service.Action;

public class UserUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savepath = "/upload";
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(savepath);
		
		Part imgurl = request.getPart("userImg");
		String imgName = imgurl.getSubmittedFileName();
		
		if(imgName != null && !imgName.isEmpty()) {
			String realPath = imgName.substring(0, imgName.lastIndexOf("."));
			String ext = imgName.substring(imgName.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString();
			
			imgName = realPath + "_" + uuid + ext;
			
			imgurl.write(path + File.separator + imgName);
		}
		
		HttpSession session = request.getSession(false);
		
		UserVo originalVo = (UserVo) session.getAttribute("user");
		
		UserVo vo = new UserVo();
		
		vo.setUserIdx(originalVo.getUserIdx());
		vo.setUserNickname(request.getParameter("nickname"));
		vo.setUserImg(imgName);
		
		UserDao.getInstance().updateUser(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("msg", "success");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(map);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
	}

}
