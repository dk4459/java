package com.yedam;

import java.util.Scanner;

public class Todo {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		Boolean run =true;
		while (run) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료");
			System.out.print("메뉴를 선택하세요> ");
			int num = Integer.parseInt(scn.nextLine());
			if(num==1) { //입금
				System.out.print("얼마를 넣으실겁니까> ");
			 int add = Integer.parseInt(scn.nextLine());
			 sum += add;
			 System.out.printf("%d의 금액을 성공적으로 입금하였습니다.\n",sum);
			}else if(num == 2) {
				System.out.print("얼마를 출금하실겁니까> ");
				int minus = Integer.parseInt(scn.nextLine());
				 sum -= minus;
				 System.out.printf("%d의 금액을 성공적으로 입금하였습니다.\n",sum);
			}else if (num == 3) {
				System.out.printf("현재 잔액은 %d원 입니다.\n",sum);
			}else if (num == 4) {
				System.out.println("성공적으로 종료하였습니다.");
				run = false;
			}

			
		}
	}

}
