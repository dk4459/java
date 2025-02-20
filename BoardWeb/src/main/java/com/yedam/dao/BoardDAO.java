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
	public List<BoardVO> selectBoard(int page) {
		List<BoardVO> boardlist = new ArrayList<>();
		String qry = "SELECT tbl_b.*\r\n" 
				+ "    FROM (SELECT rownum rn, tbl_a.*\r\n" 
				+ "             FROM (SELECT board_no, title, content, writer, write_date, view_cnt \r\n" //
				+ "                   FROM tbl_board\r\n"
				+ "                   ORDER BY board_no DESC) tbl_a) tbl_b\r\n" //
				+ "WHERE tbl_b.rn >= (? -1)*5+1 \r\n" 
				+ "AND tbl_b.rn<= ? * 5";
		try {
			psmt = getConnect().prepareStatement(qry);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
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
		}finally{
			disConnect();
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
		}finally{
			disConnect();
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
		}finally{
			disConnect();
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
		}finally{
			disConnect();
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
		}finally{
			disConnect();
		}
		return false;
	}

	// 삭제
	public boolean deleteBoard(int boardNo) {
		String query = "DELETE FROM tbl_board "
					  + "WHERE board_no = ? ";
	
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
			if(r >0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disConnect();
		}
		return false;
	}
	//페이지 총 갯수 찾기
	public int totalCnt() {
		String query = "SELECT COUNT(1) cnt "
					  + "FROM tbl_board";
		try {
			psmt = getConnect().prepareStatement(query);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disConnect();
		}
		return 0;
	}
}
