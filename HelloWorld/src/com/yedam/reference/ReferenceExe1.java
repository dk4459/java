package com.yedam.reference;

public class ReferenceExe1 {
	public static void main(String[] args) {
		// 배열선언.
		double[] doubleAry = new double[5];
		doubleAry[0] = 197.5;
		// System.out.println(doubleAry.length);
		doubleAry = new double[] { 1.2, 4.5, 23.0, 124.4, 152.53, 235.65, 745.46 };
		// System.out.println(doubleAry.length);

		// 배열[][] => 다차원 배열
		int[][] intAry = new int[2][3]; // 2 *3 배열선언. [10,20,30][40,50,60]
		intAry[0][0] = 10; // 인덱스 값
		intAry[0][1] = 20; //
		intAry[0][2] = 30;
		intAry[1][0] = 20;
		intAry[1][1] = 30;
		intAry[1][2] = 40;
		for (int j = 0; j < intAry.length; j++) {
			for (int i = 0; i < intAry[j].length; i++) {
				System.out.println("["+j+"]["+i+"] => "+intAry[j][i]);
			}
		}
		
	}

	public int sum(int a, int b) {

		return a + b;
	}

	public static void method1() {
		System.out.println("method1()이 호출되었습니다.");
	}

	private void method2() {
		System.out.println("method2()가 호출되었습니다.");
	}
}
