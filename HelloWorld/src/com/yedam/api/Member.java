package com.yedam.api;

public class Member {
	String memberId;
	int memPoint;

	public Member() {
		this.memberId = "user01";
		this.memPoint = 4;
	}
	public Member(String MemberId, int memPoint) {
		this.memberId = MemberId;
		this.memPoint = memPoint;
	}
	
	
	@Override
	public int hashCode() {
		
//return super.hashCode(); //Object의 hashcode는 주소값
		return memberId.hashCode()+memPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member m2 = (Member) obj;
			if (this.memberId == m2.memberId && this.memPoint == m2.memPoint) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
	
		return "memberId: "+this.memberId+" 점수: "+this.memPoint;
	}
}
