package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/commons/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init() execute()");
//	}
//	
//	public void destroy() {
//		System.out.println("destroy() execute()");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet() execute()");
		
		String url = "/WEB-INF/views/commons/loginForm.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("doPost() execute()");
//		String url = "redirect:main";
		String url = "redirect:/member/list";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			MemberServiceImpl.getInstance().login(id, pwd);
			
			MemberVO loginUser = MemberServiceImpl.getInstance().getMember(id);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60 * 30);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error.jsp";
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) {
			e.printStackTrace();
			url = "commons/loginForm.jsp";
			request.setAttribute("msg", e.getMessage());
		}
		
		ViewResolver.view(request, response, url);
	}

}
