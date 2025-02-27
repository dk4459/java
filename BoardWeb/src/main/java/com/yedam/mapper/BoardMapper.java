package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

public interface BoardMapper {
	//총페이지 들고오기
	public int totalCnt(SearchVO svo);
	//조회수 증가
	public boolean viewCnt(int bno);
	//상세조회
	public BoardVO detailList(int boardNo);
	//전체조회
	public List<BoardVO> selectBoard(SearchVO svo);
	// 추가
	public int insertBoard(BoardVO board);
	// 수정
	public int updateBoard(BoardVO board);
	// 삭제
	public int deleteBoard(int boardNo);
}
