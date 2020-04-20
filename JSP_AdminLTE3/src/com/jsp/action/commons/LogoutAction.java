package com.jsp.action.commons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dispatcher.ViewResolver;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class LogoutAction implements Action{

	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="redirect:/commons/login.do";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		ViewResolver.view(request, response, url);
		return url;
	}
	
}
