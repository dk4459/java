package com.yedam;

import java.util.Scanner;

public class ForLoop2 {
	public static final String blue = "\u001B[34m";

	public static void main(String[] args) {
//		String[] ary ="홍길동,80".split(",");
//		for(String arys : ary) {
//		System.out.println(arys);
//		}
		String[] strAry = new String[10];
		strAry[0] = "홍길동";
		String name = "김길동";
		for (int i = 0; i < strAry.length; i++) {
			if (strAry[i] == null) {
				strAry[i] = name;
				break;
			}
		}

		Scanner scn = new Scanner(System.in);

		String[] studentAry = new String[100];
		boolean run = true;
		
		studentAry[0] = "홍길동,70";
		studentAry[1] = "김민수,80";
		studentAry[2] = "박우식,75";
		while (run) {
			System.out.println("1.학생이름,점수 2.최고점수 3.학생입력단건 4.조회(이름) 9.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				
				for (int i = 0; i < studentAry.length; i++) {
					System.out.print("학생이름과 점수를 입력하세요> ");
					String order = scn.nextLine();
					if(order.equals("stop")) {
						System.out.println("입력을종료합니다.");
						break;
					}
					studentAry[i]= order;
				}
				System.out.println("정상적으로입력하였습니다.");

				break;
			case 2:
				int max = 0;
				String maxStu = "";
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) {
						int score = Integer.parseInt(studentAry[i].split(",")[1]);
						String student = studentAry[i].split(",")[0];
						if (max < score) {
							max = score;
							maxStu = student;
						}
					}
				}
				System.out.printf("최고점 학생은 %s이며 최고액은 %d점입니다. \n", maxStu, max);
				break;
			case 3:
				System.out.printf("이름과 점수를 입력하세요");
				String value = scn.nextLine();
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] == null) {
						studentAry[i] = value;
						break;
					}
				}
				break;
			case 4:
				System.out.print("찾을 학생 이름을 입력하세요");
				String searchName = scn.nextLine();
				for(int i = 0; i<studentAry.length; i++) {
					if(studentAry[i]!=null) {
						String findStu = studentAry[i].split(",")[0];
						String findSco = studentAry[i].split(",")[1];
						if(findStu.equals(searchName)) {
							System.out.printf("%s의 점수는 %s점입니다. \n",findStu,findSco);
						}
					}
				}
			
				break;
			case 9:
				System.out.println("종료되었습니다.");
				run = false;
				break;
			default:
				System.out.println("점수 제대로된 값을 입력");

			}
		} // end of while.

		System.out.println("end of prog.");

	}
}
