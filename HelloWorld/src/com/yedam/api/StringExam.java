package com.yedam.api;

public class StringExam {
	public static void main(String[] args) {
		
		no3();
		no1();
		no2();
	}
	static void 연습() {
		String str = "hello";
		String str1 = "world";
		StringUtil.연결하기(str,str1);
	}
	static void no1() {
		String ssn1 = "9803061234123";
		String ssn2 = "980306 2234123";
		String ssn3 = "980306-1234123";
		StringUtil.checkGender(ssn1);
	}
	static void no2() {
		String file1 = "C:/temp/flower.jpg";
		String file2 = "C:/temp/flower.mp3";
		StringUtil.checkExtension(file1);
	}
	static void no3() {
		String str1 = " suggest ";
		String str2 = " good ";
		String str3 = " hahaha ";
		StringUtil.getLength(str1, str2, str3);
	}
}
