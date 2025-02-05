package com.yedam.interfaces.emp;

import java.util.ArrayList;
import java.util.List;

import com.yedam.inheritance.ComFriend;
import com.yedam.inheritance.Friend;
import com.yedam.reference.Gender;
import com.yedam.reference.Student;

/*
 * Collection 1) List 2)Set 3)Map
 */
public class Exe {
	public static void main(String[] args) {
		// 학생정보를 저장하는 컬렉션(ArrayList) 선언
		List<Student> stuAry = new ArrayList<>();
		stuAry.add(new Student("가가가",50,60));
		stuAry.add(new Student("나나나",60,70));
		stuAry.add(new Student("다다다",70,80));
		stuAry.add(new Student("다다다",70,80,Gender.MEN));
		
		for(int i= 0; i<stuAry.size(); i++) {
			if(stuAry.get(i).getGender()==null) {
				stuAry.get(i).setGender(Gender.WOMEN);
			}
			System.out.println("이름: "+stuAry.get(i).getStudentName()+
			" 영어점수: "+stuAry.get(i).getEngScore()+
			" 수학점수: "+stuAry.get(i).getMathScore()+
			" 성별 "+stuAry.get(i).getGender());
		}
		for(int i =0; i< stuAry.size(); i++) {
			if(stuAry.get(i).getStudentName().equals("김민수")) {
				stuAry.remove(i);
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	static void method() {
		String[] staAry = new String[10];
		List<String> strList = new ArrayList<>();
		List<Friend> friends = new ArrayList<>();
		
		friends.add(new Friend("홍길동","010-222"));
		friends.add(new ComFriend("김길동","010-111","국민","신한이이"));
		
		friends.remove(0);
		System.out.println("friends크기: "+friends.size());
		System.out.println(friends.get(0).showInfo());
		
		strList.add("안녕하세요.");
		strList.add("Hello");
		strList.add("반갑습니다.");
		System.out.println("strList크기: "+strList.size());
		for(String strLists:strList) {
			System.out.println(strLists);
		}
	
		strList.remove("Hello");
		for(String strLists:strList) {
			System.out.println(strLists);
		}
	}
}
