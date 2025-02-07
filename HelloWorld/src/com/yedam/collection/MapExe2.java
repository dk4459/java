package com.yedam.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExe2 {
	public static void main(String[] args) {
		// map 컬렉션.
		Map<String,Person> family = new HashMap<>();
		family.put("아버지", new Person("홍길동",45,"낚시"));
		family.put("어머니", new Person("최지수",40,"독서"));
		family.put("아들", new Person("홍식이",13,"게임"));
		family.put("딸", new Person("홍영서",11,"유튜브"));
		
		Person result = family.get("아버지");
		
		System.out.println(result.getName()+","+result.getAge()+","+result.getHobby());
		
	}
}
