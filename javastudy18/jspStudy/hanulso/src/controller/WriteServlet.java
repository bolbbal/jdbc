package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVo;

@WebServlet("/memberWrite.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] language = request.getParameterValues("language");
		String answer = request.getParameter("answer");

//		System.out.println(id);
//		System.out.println(pw);
//		for(String lang : language) {
//			System.out.println(lang);
//		}
//		System.out.println(answer);
		
//		//브라우저로 출력할 때는 속성에 저장하여 포워딩한다.
//		request.setAttribute("id", id);
//		request.setAttribute("pw", pw);
//		request.setAttribute("language", language);
//		request.setAttribute("answer", answer);
		
		MemberVo vo = new MemberVo();
		
		vo.setId(id);
		vo.setPw(pw);
		vo.setLanguage(language);
		vo.setAnswer(answer);
		
		request.setAttribute("mvo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("ex/print.jsp");
		rd.forward(request, response);
	}

}
