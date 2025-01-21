package com.yedam;

public class Valiable2 {
	public static void main(String[] args) {

		for (int j = 1; j <= 9; j++) {
			int num = 5;
			for (int i = 2; i <= 6; i++) {
				// System.out.print(" 5 X "+i+" = "+num*i+"\n");
				System.out.printf(" %d * %d = %2d", i, j, j * i);
			}
			System.out.println();
		}
		System.out.println("end of prog");
	}
}
