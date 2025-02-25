package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.ReplyVO;

//댓글목록,등록,삭제,상세조회
public class ReplyDAO extends DAO{
	
	//목록
	public List<ReplyVO> replyList(int boardNo){
		List<ReplyVO> rvo = new ArrayList<ReplyVO>();
		String sql = "SELECT reply_no, reply,replyer,board_no "
					+"FROM tbl_reply "
					+"WHERE board_no = ? ";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ReplyVO reply = new ReplyVO();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReply(rs.getString("reply"));
				reply.setReplyer(rs.getString("replyer"));
				reply.setBoardNo(rs.getInt("board_no"));
				rvo.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rvo;
	} 
	
	//상세 
	public ReplyVO selectReply(int replyNo) {
		String sql = "SELECT reply_no, reply,replyer,board_no"
				+"FROM tbl_reply "
				+"WHERE reply_no = ? ";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, replyNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				ReplyVO reply = new ReplyVO();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReply(rs.getString("reply"));
				reply.setReplyer(rs.getString("replyer"));
				reply.setBoardNo(rs.getInt("board_no"));
				return reply;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//등록.
	public boolean insertReply(ReplyVO reply) {
		String query1 ="SELECT reply_seq.nextVal from dual";
		String sql = "INSERT INTO tbl_reply(reply_no, reply,replyer, board_no) "
					+ " VALUES(?,?,?,?)";
		try {
			psmt=getConnect().prepareStatement(query1);
			rs = psmt.executeQuery();
			if(rs.next()) {
				reply.setReplyNo(rs.getInt(1)); //첫번째 컬럼
			}
			
			psmt=getConnect().prepareStatement(sql);
			psmt.setInt(1, reply.getReplyNo());
			psmt.setString(2, reply.getReply());
			psmt.setString(3, reply.getReplyer());
			psmt.setInt(4, reply.getBoardNo());
			if(psmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//삭제 
	public boolean deleteReply(int replyNo) {
		String sql = "DELETE FROM tbl_reply "
				+ " WHERE reply_no = ? ";
		try {
			psmt=getConnect().prepareStatement(sql);
			psmt.setInt(1, replyNo);
			if(psmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
