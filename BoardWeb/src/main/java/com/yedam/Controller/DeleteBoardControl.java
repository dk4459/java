package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bno = Integer.parseInt(req.getParameter("boardNo"));
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		String page = req.getParameter("page");
		BoardDAO bdao = new BoardDAO();
		
		if(bdao.deleteBoard(bno)) {
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+searchCondition+"&keyword="+keyword);
		};
	}

}
