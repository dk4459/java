package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

public class TEST {
		public static void main(String[] args) {
			SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
			try (SqlSession session = sqlSessionFactory.openSession(true)) {
				BoardMapper mapper = session.getMapper(BoardMapper.class);
				
				SearchVO svo = new SearchVO(1,"T","325");
				List<BoardVO> list = mapper.selectBoard(svo);
				for(BoardVO boardVO : list) {
					System.out.printf("넘버는 %d 제목 %s 내용 %s",boardVO.getBoardNo(),boardVO.getTitle(),boardVO.getContent());
					
				BoardVO bvo = new BoardVO(345,"신현욱","신현욱실습","예담");
				if(mapper.updateBoard(bvo)>0) {
					System.out.println("수정완료");
				};
				}
				
			}
		}
}
