package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardModifyFormAction implements Action {

	private BoardService boardService;// = BoardServiceImpl.getInstance();

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String url = "/board/modifyBoard";
	
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardVO board = null;
		
		try {
			board = boardService.getBoard(bno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("board", board);
		return url;
	}

}
