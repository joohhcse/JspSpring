package com.jsp.dao;

import java.sql.SQLException;

import com.jsp.servlet.MemberVO;

public interface LoginDao {
	public MemberVO login(MemberVO mv) throws SQLException;
}
