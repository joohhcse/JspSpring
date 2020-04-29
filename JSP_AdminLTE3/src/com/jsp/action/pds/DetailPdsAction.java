package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;
import com.jsp.service.PdsService;
import com.jsp.utils.MakeFileName;

public class DetailPdsAction implements Action {

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="pds/detail";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String from = request.getParameter("from");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
		String searchType=request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
				
		SearchCriteria cri =new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		try {
			PdsVO pds =null; 
			if(from!=null && from.equals("modify")) {
				pds = pdsService.getPds(pno);
			}else {
				pds = pdsService.read(pno);
			}
			
			List<AttachVO> renamedAttachList=
					MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			pds.setAttachList(renamedAttachList);
			
			request.setAttribute("pds", pds);
			request.setAttribute("pageMaker", pageMaker);
		} catch (SQLException e) {			
			e.printStackTrace();
			url="error/500_error";
		}		
		
		return url;
	}

}
