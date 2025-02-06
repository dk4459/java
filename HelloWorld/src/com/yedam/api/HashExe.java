package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class HashExe {
	public static void main(String[] args) {
		//컬렉션(List, Set, Map)
		//set : 중복된 값은 저장불가
		Set<Member> set = new HashSet<>();
		set.add(new Member("user01",100));
		set.add(new Member("user01",80));
		set.add(new Member("user03",70));
		
		
		for(Member sets: set) {
			System.out.println(sets.hashCode());
			System.out.println(sets);
		}
	}
}
