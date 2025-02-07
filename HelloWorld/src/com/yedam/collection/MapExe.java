package com.yedam.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		//키 : 값 => 엔트리
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("홍길동", 90);
		map.put("김민수", 80);
		map.put("박은수", 85);
		map.put("김민수", 77);
		
		//키 => 값 반환.
		System.out.println(map.get("김민수"));
		
		//키 -> set 반환.
		Set<String> keys = map.keySet();
		for(String key : keys){
			System.out.printf("키: %s, 값: %d\n",key,map.get(key));
		}
		
		//키:값 (엔트리) 엔트리반환.
		Set <Entry <String, Integer>> entry = map.entrySet();
		for(Entry <String, Integer> ent : entry){
			System.out.printf("키: %s, 값: %d \n",ent.getKey(),ent.getValue());
		}
		
	}
}
