package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;



public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		BoardDAO bDAO = new BoardDAO();
		
		BoardVO brd = bDAO.detailList(boardNo);
		//세션 아이디 VS 글 작성 아이디
		HttpSession session = req.getSession();
		String sessionId = (String) session.getAttribute("loginId");
		String writeId = brd.getWriter();
		
		if(!sessionId.equals(writeId)) {
			req.setAttribute("msg", "권한을 확인하세요.");
			req.setAttribute("board", brd);
			req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
			return;
		}
		
		req.setAttribute("board", brd);
		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
	}

}
