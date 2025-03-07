package com.yedam.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.PageVO;
import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;


public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
//		BoardDAO edao = new BoardDAO();
		String page = req.getParameter("page");
		page = page == null?"1":page;
		
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		sc = sc ==null?"":sc;  
		kw = kw ==null?"":kw;  
		SearchVO svo = new SearchVO(Integer.parseInt(page),sc,kw);
		
		List<BoardVO> list = mapper.selectBoard(svo);
		
		req.setAttribute("list", list);
		//페이징
		int totalCnt = mapper.totalCnt(svo);
		PageVO paging = new PageVO(Integer.parseInt(page),totalCnt);
		req.setAttribute("paging", paging);
		// searchCondition, keyword 전달
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// 요청재지정(url:boardList.do (boardList.jsp))
		// forward 페이지 요청이 들어오면 다른페이지로 요청
		req.getRequestDispatcher("/board/boardList.tiles").forward(req, resp);
	}

}
