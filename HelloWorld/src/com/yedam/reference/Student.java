package com.yedam.reference;
//gender => MEN , WOMEN 2개의 값만 올 수 있도록 type을 지정 할 수 있다.

public class Student {
	private String studentName;
	private int engScore;
	private int mathScore;
	private Gender gender;

	// 메서드(기능)

	void printInfo() {
		System.out.printf("이름은 %s, 영어점수 %d, 수학점수 %d \n", studentName, engScore, mathScore);
	}

	double avg() {
		return (engScore + mathScore) / 2.0;
	}

	// 생성자
	public Student() {

	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(String studentName, int engScore, int mathScore) {
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	public Student(String studentName, int engScore, int mathScore, Gender gender) {
		super();
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.gender = gender;
	}

	// 게터세터
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
