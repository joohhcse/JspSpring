package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dao.LoginDao;
import com.jsp.dao.LoginDaoImpl;
import com.jsp.servlet.MemberVO;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	private static LoginService service;
	
	//Constructor
	public LoginServiceImpl() {
		loginDao = LoginDaoImpl.getInstance();
	}
	
	public static LoginService getInstance() {
		if(service == null)
			service = new LoginServiceImpl();
		
		return service;
	}
	
	@Override
	public MemberVO login(MemberVO mv) {
		MemberVO resmv = null;
		
		try {
			resmv = loginDao.login(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resmv;
	}

}
