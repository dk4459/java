package com.yedam.api;

public class StringUtil {
	static void 연결하기(String str, String str2) {
		
	}
	static void checkGender(String str1) {
		char gender = str1.charAt(str1.length()-7);
		System.out.println(gender);
		if(gender=='1'||gender=='3') {
			System.out.println("남자입니다.");
		}else if(gender=='2'||gender=='4') {
			System.out.println("여자입니다.");
		}
	}
	static void checkExtension(String str1) {
		//split 방법
		System.out.println(str1);
		String[] StringexeAry = str1.split("[.]");
		System.out.println(StringexeAry[1]);
		//substring 방법
		int index = str1.indexOf(".");
		String exe = str1.substring(index+1);
		System.out.println(exe);
	}
	static void getLength(String str1,String str2,String str3) {
		int trimStr1 = str1.trim().length();
		int trimStr2 = str2.trim().length();
		int trimStr3 = str3.trim().length();
		System.out.printf("str1 length: %d str2 length: %d str3 length: %d \n",trimStr1,trimStr2,trimStr3);
	}
}
