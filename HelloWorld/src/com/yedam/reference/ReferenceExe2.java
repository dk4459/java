package com.yedam.reference;

import java.util.Scanner;

public class ReferenceExe2 {
	public static void main(String[] args) {
		String [][] info = new String[5][2];

		Scanner scn = new Scanner(System.in);
		for(int i =0; i<info.length; i++) {
			for(int j =0; j<info[i].length;j++) {
				if(info[i][j]==null) {
					if(j==0) {
					System.out.println("이름을 입력하세요");
					info[i][j]=scn.nextLine();
					}else if(j==1) {
						System.out.println("점수를 입력하세요");
						info[i][j]=scn.nextLine();
					}
				}
			}
		}
		System.out.println("===============");
		System.out.printf("  이름   점수 \n");
		System.out.println("===============");
		for(int i=0; i<info.length;i++) {
			for(int j =0; j<info[i].length; j++) {
				System.out.printf("%5s",info[i][j]);
			}
				System.out.println();
		}
		
		int sum = 0;
		int max = 0;
		int best = 0;
		for(int i=0; i<info.length;i++) {
				sum += Integer.parseInt(info[i][1]);
			if(max< Integer.parseInt(info[i][1])) {
				max = Integer.parseInt(info[i][1]);
				best = i;
			}
		}
		System.out.println("점수의 합게는 "+sum+"점 입니다.");
		System.out.printf("최고의 학생은 %s이고 최고점은 %s입니다.",info[best][0],info[best][1]);
	}
}
