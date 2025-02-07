package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("홍길동");
		set.add("반값습니다.");
		set.add("1000");
		set.add(String.valueOf(true));
		set.add("홍길동");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}
		System.out.println("================================");
		for(String sets : set) {
			System.out.println(sets);
		}
	}
}
