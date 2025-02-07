package com.yedam.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 학생정보 관리
 * 학생이름, 키 ,몸무게, 점수
 */
public class StudentApp {
	Scanner scn = new Scanner(System.in);
	boolean run = true;
	List<Student> students = new ArrayList<>();

	public void start() {
		init();
		while (run) {
			System.out.println("1.목록 2.등록 3.삭제 9.종료");
			System.out.println("선택>> ");
			// 임시저장.

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				removeStudent();
				break;
			case 4:
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				save();
				run = false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		} // end of start

	}

	public void studentList() {
		//파일읽기
		for(Student student : students) {
			System.out.printf("이름:%s 키:%.2fcm 몸무게:%.2fkg 점수:%d점 \n",student.getName(),student.getHeight(),student.getWeight(),student.getScore());
		}
	}
	public void addStudent() {
		System.out.println("학생의 이름을 입력하세요");
		String name= scn.nextLine();
		Double height=0.0;
		while(true) {
		System.out.println("학생의 키를 입력하세요");
		try{
			height = Double.parseDouble(scn.nextLine());
			break;
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
			
		  }
		 
		}
		System.out.println("학생의 몸무게 입력하세요");
		Double weight= Double.parseDouble(scn.nextLine());
		System.out.println("학생의 점수 입력하세요");
		int score= Integer.parseInt(scn.nextLine());
		students.add(new Student(name,height,weight,score));
		System.out.println("등록이 완료되었습니다.");
	}
	public void removeStudent() {
		System.out.println("학생이름 입력>>");
		String name= scn.nextLine();
		
		for(int i = 0 ; i < students.size(); i++ ) {
			if(students.get(i).getName().equals(name)) {
				students.remove(i);
			}
		}
		System.out.println("삭제가완료되었습니다.");
	}
	public void save() {
		try {
			Writer reader = new FileWriter("c:/temp/studentList.txt");
			BufferedWriter br = new BufferedWriter(reader);
			for(Student std : students) {
				br.write(std.getName()+" "+std.getHeight()+" "+
			             std.getWeight()+" "+std.getScore()+" \n");
			}
			br.flush();
			reader.flush();
			br.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init() {
		try {
			Reader reader = new FileReader("c:/temp/studentList.txt");
			BufferedReader br = new BufferedReader(reader);
			while(true) {
				String str = br.readLine();
				if(str == null) {
					break;
				}
				String[] stuAry =str.split(" ");
				Student student = new Student(stuAry[0],Double.parseDouble(stuAry[1]),
						Double.parseDouble(stuAry[2]),Integer.parseInt(stuAry[3]));
				students.add(student);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
