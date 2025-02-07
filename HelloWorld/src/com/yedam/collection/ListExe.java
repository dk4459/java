package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;


public class ListExe {
	public static void main(String[] args) {
		List<String> str1 = new ArrayList<>();
	
		
		str1.add(null);
		str1.add("Hong");
		str1.add(new String("kildong"));
		str1.add(new String(new byte[] {77,108,108,111,96}));
		
		str1.remove(0);
		System.out.println(str1.size());
		
		str1.add(0,"hello");
		
		for(String str : str1) {
			System.out.print(str+" ");
		}
		
	}
}
