package com.yedam;

import com.yedam.reference.ReferenceExe1;

public class aryIdx {
	public static void main(String[] args) {
		
		
		String [] strAry  = {"가","나","다"};
		
		for(int i = 0 ; i<strAry.length; i++) {
			if(strAry[i].equals("다")) {
				System.out.println("인덱스번호는 "+i+"입니다.");
				strAry[i]=null;
			}
			System.out.println(strAry[i]);
		}
	}
}
