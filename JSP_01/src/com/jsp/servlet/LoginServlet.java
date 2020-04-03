package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

//@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		
//		request.getRequestDispatcher("login_success.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request, response);
		
		
//		out.println("doGet() execute!!");
//		out.println("<DOCTYPE!>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>");
//		out.println("<로그인페이지>");
//		out.println("</title>");
//		out.println("</head>");
//		out.println("</body>");
//		out.println("<form action=\"login.html\" method=\"post\" >");
//		out.println("아이디 : <input type=\"text\" name=\"id\" /><br/>");
//		out.println("패스워드 : <input type=\"password\" name=\"pwd\" /><br/>");
//		out.println("<input type=\"submit\" value=\"로그인\" />");
//		out.println("</form>");
//		out.println("</body>");
//		out.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//MemberVO member = memberService.getMember(id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("login_success.jsp").forward(request, response);
		
//		//forward와 re-direct의 차이
//		out.println("<script>");
//		out.println("alert('로그인 성공입니다.')");
//		out.println("location.href='https://www.naver.com';");		//브라우저에게 날림 // re-direct //기존 req는 날아감
//		out.println("</script>");
//		System.out.println("doPost() execute!!");
	}

}
