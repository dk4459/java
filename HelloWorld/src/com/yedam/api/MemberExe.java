package com.yedam.api;

import com.yedam.reference.Student;

public class MemberExe {
	public static void main(String[] args) {
		// equals(객체비교)
		Object o1 = new Object();
		Object o2 = new Object();
		
		Member m1 = new Member();
		Member m2 = new Member();
		//비교 연산자 
		System.out.println(m1.equals(m2));
	}
}
