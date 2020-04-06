package com.jsp.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jsp.ibatis.config.SqlMapClientFactory;
import com.jsp.servlet.MemberVO;

public class LoginDaoImpl implements LoginDao {

	private SqlMapClient smc;
	private static LoginDao loginDao;
	
	//Constructor
	private LoginDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static LoginDao getInstance() {
		if(loginDao == null)
			loginDao = new LoginDaoImpl();

		return loginDao;
	}
	
	
	@Override
	public MemberVO login(MemberVO mv) throws SQLException {
		MemberVO resmv = null;
		
		try {
			resmv =  (MemberVO) smc.queryForObject("member.login", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resmv;
	}

}
