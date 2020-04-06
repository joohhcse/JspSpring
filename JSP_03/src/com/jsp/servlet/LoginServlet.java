package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.service.LoginService;
import com.jsp.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");

		request.getRequestDispatcher("/WEB-INF/views/common/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		
		String url = "/WEB-INF/views/common/login_success.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//로그인 처리		//MemberVO member = mService.getMember(id);
//		response.sendRedirect("/main");

		LoginService service = LoginServiceImpl.getInstance();
		
		MemberVO mvo = new MemberVO();
		mvo.setId(id);
		mvo.setPwd(pwd);
		
		MemberVO resmv = service.login(mvo);
		
		if(resmv == null) {
			System.out.println("login fail");

			request.setAttribute("id", id);
			url = "/WEB-INF/views/common/loginForm.jsp";
		}
		else {	//login success
			System.out.println("login ok");

			//로그인성공
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPwd(pwd);
			member.setEmail("helloUser");
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
		}
		
//		if(!(id.equals("mimi") && pwd.equals("mimi"))) {
//			request.setAttribute("id", id);
//			url = "/WEB-INF/views/common/loginForm.jsp";
//		}
//		else {
//			//로그인성공
//			MemberVO member = new MemberVO();
//			member.setId(id);
//			member.setPwd(pwd);
//			member.setEmail("mimi");
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("loginUser", member);
//			
//			System.out.println(member.toString());
//		}
		
		request.getRequestDispatcher(url).forward(request,  response);
		
		System.out.println(url);
	}

}
