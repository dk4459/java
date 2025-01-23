package com.yedam.reference;

import java.util.Scanner;

public class StudentExe {
	public static void main(String[] args) {
		Student [] students = new Student[5];
		
		Student std1 = new Student(); // 인스턴스 생성.
		std1.setStudentName("홍길동");
		std1.setEngScore(50);
		std1.setMathScore(50);
		
		Student std2 = new Student();
		std2.setStudentName("김민수");
		std2.setMathScore(60);
		std2.setEngScore(80);
		
   		
		Student std3 = new Student();
		std3.setStudentName("홍정학");
		std3.setMathScore(75);
		std3.setEngScore(90);
		students[0] = std1;
		students[1] = std2;
		students[2] = std3;
		students[3] = new Student("김민지",88,92);
		
		//학생의 이름을 입력받는 변수 : studName 
		//학생의 평균을 출력하는 프로그램을 작성.
		Scanner scn = new Scanner(System.in);
		System.out.println("찾고자하는 이름을 입력하세요");
		String studName = scn.nextLine();
		for(int i = 0 ; i< students.length; i++) {
//			if(students[i] != null && students[i].getEngScore()>80) {
//				students[i].printInfo();
//				double avg = students[i].avg();
//				System.out.println("평균점수는 "+avg+"점 입니다");
//			}
			if(students[i] != null &&students[i].getStudentName().equals(studName)) {
			  double avg = students[i].avg();
			  System.out.printf("%s학생의 평균점수는 %.2f점 입니다.\n",studName,avg);
			  
			}	
		}
	
		Student std4 = new Student("신현욱");
		System.out.println(std4.getStudentName());
	}
}