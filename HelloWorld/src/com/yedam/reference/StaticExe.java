package com.yedam.reference;
// 싱글톤객체 = 하나의 객체만 만들어서 활용해서 사용
// 메모리를 적게 사용하기위해 사용.
public class StaticExe {
	public static void main(String[] args) {
		// m1, m2 참조변수.
		// 인스턴스를 많이 사용한다는것 = 메모리사용량이 많음.
		MemberExe m1 = MemberExe.getInstance();
		MemberExe m2 = MemberExe.getInstance();
		System.out.println(m1 == m2);
	}
}