package com.yedam;

import java.util.Scanner;

public class Todo3 {
	//frienAry [null,null,null][null,null,null]
	//friendAry[i][0] = "신현욱"  friendAry[i][0]  
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String[][] frindAry = new String[100][3];
		frindAry[0] = new String[] {"김민수","010-1213-2323","남"};
		frindAry[1] = new String[] {"신현욱","010-1213-2323","여"};
		frindAry[2] = new String[] {"김김김","010-1213-2323","남"};
		while (run) {
			System.out.print("메뉴룰 선택하세요 1.목록 2.등록 3.조회(성별) 4.삭제 5.수정");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {

			case 1:
				System.out.println("===================");
				System.out.println("이름   전화번호    성별");
				for (int i = 0; i < frindAry.length; i++) {
					for (int j = 0; j < frindAry[i].length; j++) {
						if (frindAry[i][j] != null) {
							System.out.print(frindAry[i][j]);
						}
					}
					if(frindAry[i][0]!=null) {
						System.out.println();
					}
				}
				System.out.println("===================");
				break;
			case 2:
				boolean stop = false;
				
				for (int i = 0; i < frindAry.length; i++) {
					for (int j = 0; j < frindAry[i].length; j++) {
						if (frindAry[i][j] == null) {
							if (j == 0) {
								System.out.println("이름을 입력하세요");
								String name = scn.nextLine();
								if (name.equals("stop")) {
									System.out.println("등록을 종료합니다.");
									stop = true;
									break;
								}
								frindAry[i][j] = name;

							} else if (j == 1) {
								System.out.println("점수를 입력하세요");
								frindAry[i][j] = scn.nextLine();
							} else if (j == 2) {
								System.out.println("성별을 입력하세요");
								frindAry[i][j] = scn.nextLine();
							}
						}
					}
					if (stop) {
						break;
					}
				}
				break;
			case 3:
				System.out.printf("찾고자하는 성별을 입력하세요");
				String gender = scn.nextLine();
				System.out.println("===================");
				System.out.println("이름   전화번호    성별");
				for (int i = 0; i < frindAry.length; i++) {
					for (int j = 0; j < frindAry[i].length; j++) {
						if (frindAry[i][j] != null) {
							if(frindAry[i][2].equals(gender)) {
							System.out.print(frindAry[i][j]);
							}
						}
					}
					if(frindAry[i][0]!=null&&frindAry[i][2].equals(gender)) {
						System.out.println();
					}
				}
				System.out.println("===================");
				break;
			case 4: 
				System.out.print("삭제하실 이름을 입력하세요");
				String name = scn.nextLine();
				boolean exist1 = false;
				for(int i = 0; i<frindAry.length; i++) {
					if(frindAry[i][0]!= null) {
						if(frindAry[i][0].equals(name)) {
							frindAry[i][0]=null;
							frindAry[i][1]=null;
							frindAry[i][2]=null;
							exist1 = true;
						}
					}
				}
				if(!exist1) {
					System.out.println("수정하실 이름이 없습니다.");
				}else {
				System.out.println("삭제가 완료하였습니다.");
				}
				break;
			case 5:
				System.out.print("수정할 이름을 입력하세요");
				String tname = scn.nextLine();
				boolean exist = false;
				for(int i = 0; i<frindAry.length; i++) {
					if(frindAry[i][0]!= null) {
						if(frindAry[i][0].equals(tname)) {
							System.out.println("수정할 이름을 입력하세요");
							String rname = scn.nextLine();
							System.out.println("수정할 번호를 입력하세요");
							String rphone = scn.nextLine();
							System.out.println("수정할 성별을 입력하세요");
							String rgender = scn.nextLine();
							frindAry[i][0]=rname;
							frindAry[i][1]=rphone;
							frindAry[i][2]=rgender;
							exist = true;
						} 
					}
				}
				if(!exist) {
					System.out.println("존재하지 않는 이름입니다.");
				}
				break;
			}//switch 끝

		}
	}
}
