package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;

@WebServlet("/member/checkPassword")
public class CheckPasswordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		
		String pwd=request.getParameter("pwd");
		
		if(pwd == null)
			return;
		
		HttpSession session = request.getSession();				
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser.getPwd().equals(pwd)) {
			result="SUCCESS";
		}
		
		response.getWriter().print(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
