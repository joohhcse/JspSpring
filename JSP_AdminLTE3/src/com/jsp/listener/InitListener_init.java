package com.jsp.listener;

import java.lang.reflect.Method;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.BoardDAO;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.ReplyDAO;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberServiceImpl;
import com.jsp.service.ReplyServiceImpl;

@WebListener
public class InitListener_init implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent ctxEvent)  { 
//         String sqlSessionFactoryType = 
//        		 ctxEvent.getServletContext().getInitParameter("sqlSessionFactory");
//         String memberDAOType = ctxEvent.getServletContext().getInitParameter("memberDAO");
//         String boardDAOType = ctxEvent.getServletContext().getInitParameter("boardDAO");
//         String replyDAOType = ctxEvent.getServletContext().getInitParameter("replyDAO");
         
//         try {
//        	 
//	         SqlSessionFactory sqlSessionFactory = 
//	        		 (SqlSessionFactory)Class.forName(sqlSessionFactoryType).newInstance();
//	         
//	         
//	         Class<?> memDao = Class.forName(memberDAOType);     
//	         Class<?> borDao = Class.forName(boardDAOType);     
////	         Class<?> repDao = Class.forName(replyDAOType);     
	         
//	         Method setSqlSessionFactory1
//	         	= memDao.getMethod("setSessionFactory", SqlSessionFactory.class);
//	         Method setSqlSessionFactory2
//	         = borDao.getMethod("setSessionFactory", SqlSessionFactory.class);
//	         Method setSqlSessionFactory3
//	         = repDao.getMethod("setSessionFactory", SqlSessionFactory.class);
	         
//	         Object obj1 = memDao.newInstance();
//	         Object obj2 = borDao.newInstance();
//	         Object obj3 = repDao.newInstance();
//	         setSqlSessionFactory1.invoke(obj1, sqlSessionFactory);
//	         setSqlSessionFactory2.invoke(obj2, sqlSessionFactory);
//	         setSqlSessionFactory3.invoke(obj3, sqlSessionFactory);
	         
//	         MemberDAO memberDAO = (MemberDAO)obj1;
//	         BoardDAO boardDAO = (BoardDAO)obj2;
//	         ReplyDAO replyDAO = (ReplyDAO)obj3;
	         
//	         MemberServiceImpl.getInstance().setMemberDAO(memberDAO);
//	         BoardServiceImpl.getInstance().setBoardDAO(boardDAO);
//	         ReplyServiceImpl.getInstance().setReplyDAO(replyDAO);
	         
//         }catch(Exception e) {
//        	 e.printStackTrace();
//         }
                        
    }
	
}
