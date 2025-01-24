package com.yedam.reference;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class Caculator {
	public void showCalendar() {
		Date today= new Date();
		LocalDate date = LocalDate.of(2025, 01, 01);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekNumber = dayOfWeek.getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		System.out.println("          "+sdf.format(today));
		String[] days ={"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		
		for(String day : days) {
			System.out.printf("%4s",day);
		}
		System.out.print("\n----------------------------\n");
		int space = dayOfWeekNumber;
		System.out.println();
		for(int i=1; i<=space; i++) {
			System.out.printf("%4s"," ");
		}
		for(int i=1; i<=31; i++) {
			if((space+i)%7==0) {
				System.out.printf("%4s \n",i);
			}else {
				System.out.printf("%4s",i);
			}
		}
		
	}
	public Book getBookInfo(String btTitle, Book[] bookAry) {
//		Book[] bookRepo = { new Book("이것이 자바다","신용권","한빛미디어","5000")//
//				  		  , new Book("자바스크립트","김자바","자바출판사","15000")//
//			     	  	  , new Book("혼자공부하는자바","혼공자","한빛미디어","20000")//
//				   };
		  //배열 검색 
			for(int i = 0; i<bookAry.length;i++) {
				if(bookAry[i].getBookName().equals(btTitle)) {
					return bookAry[i];
				} 
			}
		return null;
		}

	// 1 ~ 100 사이의 임의값을 N개 반환.
	public int[] randomAry(int n) {
		int[] result = new int[n];

		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 100) + 1;
		}

		return result;
	}

	// 두 숫자중에서 큰값을 반환
	public int getMax(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}
		return num2;
	}

	public void start() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("★");
			}
			System.out.println();
		}
	}

	public void placeStart(int row) {
		for (int i = 0; i < row; i++) {
			for (int e = row - 1; e > i; e--) {
				System.out.printf(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.printf("★");
			}
			System.out.println();
		}
	}

	public void tri() {
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 별 출력하는 메소드.
	public void printStar(int cnt, String type) {
		for (int j = 0; j < cnt; j++) {
			for (int i = 0; i < cnt; i++) {
				System.out.printf(type);
			}
			System.out.println();
		}

	}

	public int sum(int a, int b) {
		return a + b;
	}

	// 동일한 메소드명을 중복정의: overloading
	public double sum(double a, double b) {
		return a + b;
	}

	// 매개변수가 다르기 때문에 메서드 오버로딩 가능
	public int sum(int[] intAry) {
		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			sum += intAry[i];
		}
		return sum;
	}
}
