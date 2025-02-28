package com.yedam;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.SearchVO;

public class TEST {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);

			SearchVO svo = new SearchVO(1, "T", "325");
//			List<BoardVO> list = mapper.selectBoard(svo);
			List<Map<String,Object>> list = mapper.fullData();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(gson.toJson(list));
//			for (BoardVO boardVO : list) {
//				System.out.printf("넘버는 %d 제목 %s 내용 %s", boardVO.getBoardNo(), boardVO.getTitle(), boardVO.getContent());
//
//				BoardVO bvo = new BoardVO(345, "신현욱", "신현욱실습", "예담");
//				if (mapper.updateBoard(bvo) > 0) {
//					System.out.println("수정완료");
//				}
//				;
//			}

		}
	}
}
