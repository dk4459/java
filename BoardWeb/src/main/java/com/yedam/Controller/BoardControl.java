package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.BoardVO;



public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		String searchConditon = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		String page = req.getParameter("page");
		BoardDAO bDAO = new BoardDAO();
		ReplyDAO rDAO = new ReplyDAO();
		//조회수증가
		bDAO.viewCnt(boardNo);
		//댓글 총페이
		
		BoardVO brd = bDAO.detailList(boardNo);
		System.out.println("이미지"+brd.getImg());
		req.setAttribute("board", brd);
		req.setAttribute("search", searchConditon);
		req.setAttribute("keyword", keyword);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/board/board.tiles").forward(req, resp);
	}

}
