package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.vo.ReplyVO;

//댓글목록,등록,삭제,상세조회
public class ReplyDAO extends DAO{
	//윈도우함수
	/*
	 *  SELECT reply_no, reply,replyer,board_no ,RN
 		FROM (SELECT reply_no, reply,replyer,board_no ,ROW_NUMBER() OVER (ORDER BY reply_no) RN 
        	  FROM tbl_reply
        	  WHERE board_no=1002)
		WHERE RN BETWEEN 6 AND 10;
	 * */
	//목록
	public List<ReplyVO> replyList(int boardNo,int page){
		List<ReplyVO> rvo = new ArrayList<ReplyVO>();
		String sql = "SELECT tbl_a.* "
				     + "FROM (SELECT /*+ INDEX_DESC (r PK_REPLY)*/ "
				     + "      rownum rn,reply_no,reply,replyer,board_no,reply_date "
				     + "      FROM tbl_reply r "
				     + "      WHERE board_no=?) tbl_a "
				+ "WHERE tbl_a.rn >=(?-1)*5+1 "
				+ "AND tbl_a.rn <= ? * 5";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
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
		}finally{
			disConnect();
		}
		return rvo;
	} 
	//총페이지
	public int totalPage(int boardNo) {
		String sql = "SELECT COUNT(1) cnt "
					+ "FROM tbl_reply "
					+ "WHERE board_no= ? ";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1,boardNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			disConnect();
		}
		return 0;
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
		}finally{
			disConnect();
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
		}finally{
			disConnect();
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
		}finally{
			disConnect();
		}
		return false;
	}
	
	//차트
	public List<Map<String,Object>> chartData(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "SELECT e.department_id,"
					+ "       d.department_name,"
					+ "       count(*) cnt "
					+ "FROM employees e JOIN departments d "
					+ "                  ON(e.department_id=d.department_id) "
					+ "GROUP BY e.department_id, "
					+ "         d.department_name";
		try {
			psmt=getConnect().prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				map.put("dept_name", rs.getString(2));
				map.put("dept_cnt", rs.getInt(3));
				list.add(map);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disConnect();
		}
		return list;
	}
}
