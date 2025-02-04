package com.yedam.inheritance;

public class Casting {
	public static void main(String[] args) {
		//

		Friend f1 = new ComFriend("김민수", "010-789-456", "회사", "부서"); // 자동형변환

		// ComFriend f2 = (ComFriend)new Friend("1","2"); //강제형변환
		f1 = new Friend("홍길동","010-2222");
		System.out.println(f1.toString());
		
		if (f1 instanceof ComFriend) {
			ComFriend f2 = (ComFriend) f1;
			System.out.println(f2.showInfo());
		}else {
			System.err.println("형변환 못함");
		}
	}
}
