package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;

//@WebServlet("/member/abled")
public class MemberAbledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/abled_success";
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(id.equals(loginUser.getId())) {	//로그인 사용자일 경우 불허
			url = "member/abled_denied";
		} else {	//로그인 사용자가 아닐경우 실행.
			try {
				MemberServiceImpl.getInstance().enabled(id);
				request.setAttribute("id", id);
			} catch (SQLException e) {
				e.printStackTrace();
				url="member/abled_fail";
			}
		}
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
