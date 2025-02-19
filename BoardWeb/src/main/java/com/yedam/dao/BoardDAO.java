package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가, 수정, 삭제, 조회
 * create, Read, Update, Delete
 *  
 */
public class BoardDAO extends DAO {

	// 조회(삭제)
	public List<BoardVO> selectBoard() {
		List<BoardVO> boardlist = new ArrayList<>();
		String qry = "select board_no, " + "          title, " + "          content, " + "          writer, "
				+ "          write_date, " + "          view_cnt " + "from tbl_board " + "ORDER BY board_no";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			psmt = getConnect().prepareStatement(qry);
			rs = psmt.executeQuery();
			// 조회결과 저장
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriterDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));

				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardlist;
	}

	// 상세조회
	public BoardVO detailList(int boardNo) {
		String qry = "select board_no, " + "          title, " + "          content, " + "          writer, "
				+ "          write_date, " + "          view_cnt " + "from tbl_board " + " WHERE board_no = ?";
		try {
			psmt = getConnect().prepareStatement(qry);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriterDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				return board;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 조회수
	public boolean viewCnt(int bno) {
		String sql = "UPDATE tbl_board " + "SET view_cnt = view_cnt+1 " + "WHERE board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, bno);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 추가
	public boolean insertBoard(BoardVO board) {
		String query = "INSERT INTO tbl_board(board_no, title, content, writer) " + "VALUES (board_seq.nextval,?,?,?)";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 수정
	public boolean updateBoard(BoardVO board) {
		String query = "Update tbl_board " + "SET title = ? ," + "	 content = ? " + "WHERE board_no = ? ";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 삭제
	public boolean deleteBoard(int boardNo) {

		return false;
	}
}
