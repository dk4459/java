package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;



public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//2종류의 파일 티입.(multipart)
		String saveDir = req.getServletContext().getRealPath("images");
		System.out.println(saveDir);
		MultipartRequest mr = new MultipartRequest(
			 req                //1. 요청객체
		    ,saveDir            //2. 파일저장
			,1024*1024*5        //3.최대파일의 크기
			,"utf-8"            //4.인코등
			,new DefaultFileRenamePolicy()            //5.RENAME정책
);
		//3개 파라미터 활용 db 저장 목록 이동
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
//		String writer = req.getParameter("writer");
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		//매개값으로 활용
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		bvo.setImg(img); //추가한 img컬럼.
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession session = sqlSessionFactory.openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		if(mapper.insertBoard(bvo)>0) {
			//forward             vs  redirect 
			//파라미터값 같이 전달     vs  바로전달
			resp.sendRedirect("boardList.do");
		}else{
			System.out.println("실패");
		};
	}

}
