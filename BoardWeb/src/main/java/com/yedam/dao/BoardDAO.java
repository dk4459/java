package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Board;

/*
 * 추가,수정,삭제,조회
 * Create,Read,Update,Delete
 */
public class BoardDAO extends Dao {
	//조회
	public List<Board> selectBoard(){
		List<Board> result = new ArrayList<>();
		String query = "SELECT *"
					+ " FROM tbl_board "
					+ " ORDER BY board_no ";
				
		try {
			psmt = getConnect().prepareStatement(query);
			rs= psmt.executeQuery();
			while(rs.next()) {
				Board brd = new Board();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setWriteDate(rs.getDate("write_date"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				
				result.add(brd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	} 
	//추가
	public boolean insertBoard(Board board) {
		
		return false;
	}
	//수정
	public boolean updateBoard(Board board) {
		
		return false;
	}
	//삭제
	public boolean deleteBoard(int boardNo) {
		String query = "DELETE FROM tbl_board"
					+ " WHERE board_no = ?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
