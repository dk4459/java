package com.yedam;
/*
 * 학생점수 입력받아서 배열저장.
 * 최고점수,평균, 합계점수 출력
 */

import java.util.Scanner;

public class ForLoopExe1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int[] scores = new int[3];
		while (run) {
			System.out.println("1.학생점수 입력 2.최고점수 3. 평균,합계점수  4.종료");
			System.out.print("선택하세요> ");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1:
				System.out.printf("점수를입력하세요> ");
				for(int i = 0; i<scores.length; i++) {
				   System.out.print("점수를 입력하세요> ");
				   scores[i] = Integer.parseInt(scn.nextLine());
				}
				System.out.println("입력완료");
				break;
			case 2:
				int max = 0;
				for(int i = 0; i<scores.length; i++) {
					if(scores[i]>max) {
						max = scores[i];
					}
				}
				System.out.println("최고점수는 "+max+"점 입니다.");
				break;
			case 3:
				double avg = 0;
				int sum = 0;
				for(int i = 0; i<scores.length; i++) {
					sum += scores[i];
				}
				avg = (double)sum/scores.length;
				System.out.println("점수 합계는 "+sum+"점 이며."+"평균 점수는 "+Math.round(avg*100)/100.0+"점 입니다.");
				break;
			case 4:
				System.out.println("해당 프로그램을 종료합니다.");
				run=false;
				break;
			default:
				System.out.println("맞는 값을 입력하세요");
			}
		}
		

	}
}
