package com.yedam.inheritance;

public class OracleDao implements Dao{

	public void register() {
		System.out.println("등록기능");
	}

	public void remove() {
		System.out.println("삭제기능");
	}

	public void search() {
		System.out.println("조회기능");
	}
}
