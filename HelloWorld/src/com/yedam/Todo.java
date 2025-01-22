package com.yedam;

import java.util.Scanner;

public class Todo {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		Boolean run = true;
		while (run) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료");
			System.out.print("메뉴를 선택하세요> ");
			int num = Integer.parseInt(scn.nextLine());
			if (num == 1) { // 입금
				System.out.print("얼마를 넣으실겁니까> ");
				int add = Integer.parseInt(scn.nextLine());
				if(sum+add>100000) {
				System.out.println("현재 잔액이 100,000원을 넘기실 수 없습니다. ");
				}else {
				sum += add;
				System.out.printf("%d원의 금액을 성공적으로 입금하였습니다.\n", sum);
				}
			} else if (num == 2) {
				System.out.print("얼마를 출금하실겁니까> ");
				int minus = Integer.parseInt(scn.nextLine());
				if (sum < minus) {
					System.out.println("현재 가지고있는 금액보다 더 많이 출금하였습니다.");
				} else {
					System.out.printf("%d의 금액을 성공적으로 출금하였습니다.\n", minus);
					sum -= minus;
				}
			} else if (num == 3) {
				System.out.printf("현재 잔액은 %d원 입니다.\n", sum);
			} else if (num == 4) {
				System.out.println("성공적으로 종료하였습니다..");
				run = false;
			}

		}
	}

}
