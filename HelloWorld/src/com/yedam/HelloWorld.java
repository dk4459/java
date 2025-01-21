package com.yedam;

//HelloWorld.java 소스코드 => HelloWorld. 실행파일
public class HelloWorld {

	// method: 기능
	public static void main(String[] args) {
		System.out.println("Hello, World");

		int myAge = 20;
		myAge = 25;
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println("i의 값은 " + i);
				sum += i;
			}
		}
		System.out.println(sum);

	}
}
