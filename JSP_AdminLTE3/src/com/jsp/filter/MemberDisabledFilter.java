package com.jsp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.utils.ViewResolver;

public class MemberDisabledFilter implements Filter {

	private List<String> checkURLs = new ArrayList<String>();	//들어오는 url이 고정이면 > set hashmap 사용 

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MemberDisabledFilter :: doFilter");
		
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpResp = (HttpServletResponse)response;
		
		String uri = httpReq.getRequestURI();
		
		MemberVO loginUser = (MemberVO)httpReq.getSession().getAttribute("loginUser");
		
		if(loginUser != null && loginUser.getEnabled() != 1 ) {
			for (String url : checkURLs) {	
				if (uri.contains(url)) {
					url="commons/checkDisabled";
					ViewResolver.view(httpReq, httpResp, url);
					return;
				}
			}
		}
		else {
			chain.doFilter(request, response);			
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MemberDisabledFilter :: init");
		
		String paramValue =  fConfig.getInitParameter("checkURL");
		StringTokenizer st = new StringTokenizer(paramValue,",");
		while(st.hasMoreTokens()) {
			String urlKey = st.nextToken();
			checkURLs.add(urlKey);
		}
	}
	
	private boolean excludeCheck(String url) {		
		for(String strURL : checkURLs) {
			if(url.contains(strURL)) {
				return true;
			}
		}		
		return false;
	}

}