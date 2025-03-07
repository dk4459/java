package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.MemberVO;

public class MemberDAO extends DAO{
	
	public MemberVO login(String id, String pw) {
		String sql = "SELECT member_id "
					+ "      ,passwd"
					+ "      ,member_name"
					+ "      ,reponsibility "
					+ "FROM tbl_member "
					+ "WHERE member_id = ? "
					+ "AND   passwd = ? ";
		System.out.println(sql);
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery(); //쿼리 실행
			if(rs.next()) { //조회된 결과가 있으면
				MemberVO mvo = new MemberVO();
				mvo.setMemberId(rs.getString("member_id"));
				mvo.setPasswd(rs.getString("passwd"));
				mvo.setMemberName(rs.getString("member_name"));
				mvo.setReponsibility(rs.getString("reponsibility"));
				return mvo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return null;
	}

	public List<MemberVO> memberList() {
		List <MemberVO> members = new ArrayList<>(); 
		String sql = "SELECT member_id "
				+ "      ,passwd"
				+ "      ,member_name"
				+ "      ,reponsibility "
				+ "FROM tbl_member ";
	System.out.println(sql);
	try {
		psmt = getConnect().prepareStatement(sql);
		
		rs = psmt.executeQuery(); //쿼리 실행
		while(rs.next()) { //조회된 결과가 있으면
			MemberVO mvo = new MemberVO();
			mvo.setMemberId(rs.getString("member_id"));
			mvo.setPasswd(rs.getString("passwd"));
			mvo.setMemberName(rs.getString("member_name"));
			mvo.setReponsibility(rs.getString("reponsibility"));
			members.add(mvo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		disConnect();
	}
		return members;
	}
	//삭제
	public boolean deleteMember(String id) {
		String sql = "DELETE FROM tbl_member "
				+ " WHERE member_id = ?";
		try {
			psmt=getConnect().prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//등록
	public boolean addMember(MemberVO member) {
		String sql = "INSERT INTO tbl_member(member_id, passwd, member_name) "
					+ "VALUES (?,?,?)";
		try {
			psmt= getConnect().prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getPasswd());
			psmt.setString(3, member.getMemberName());
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
