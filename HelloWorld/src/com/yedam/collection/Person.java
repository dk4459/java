package com.yedam.collection;

public class Person {
	// 필드: 이름, 나이, 취미
	private String name;
	private int age;
	private String hobby;

	public Person() {

	}

	public Person(String name, int age, String hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
