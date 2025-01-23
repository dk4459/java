package com.yedam;

import java.util.Scanner;

/*
 * 친구정보관리 앱 v.1
 * 이름,연락처,성별(남,여) => 홍길동,010-1234-1234,남
 * 1.목록 (이름,연락처,성별) 2.등록 3.조회(성별) 9.종료
 */
public class Todo2 {

	public static void main(String[] args) {
		String[] friendAry = new String[100];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("1.목록 (이름,연락처,성별) 2.등록 3.조회(성별) 4.삭제 5.수정 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						String name = friendAry[i].split(",")[0];
						String tel = friendAry[i].split(",")[1];
						String gender = friendAry[i].split(",")[2];
						System.out.printf("이름: %3s 전화번호: %11s 성별 %1s \n", name, tel, gender);
					}
				}
				break;
			case 2:
				for (int i = 0; i < friendAry.length; i++) {
					System.out.printf("이름,연락처,성별을 입력하세요  => 홍길동,010-1234-1234,남");
					String add = scn.nextLine();
					boolean exist = true;
					for (int j = 0; j < friendAry.length; j++) {
						if (friendAry[j] != null) {
							if (friendAry[j].split(",")[0].equals(add.split(",")[0])) {
								System.out.println("이미 같은이름인 사람이있습니다. 그래도 입력하시겠습니까? yes or no");
								String choice = scn.nextLine();
								if (choice.equals("yes")) {
									exist = true;
								} else if (choice.equals("no")) {
									System.out.println("등록하지않았습니다.");
									exist = false;
								} else {
									System.out.println("해당 값을 입력하지 않아 등록이 실패하였습니다.");
									exist = false;
								}
							}
						}
					}
					if (add.equals("stop")) {
						break;
					} else if (exist) {
						friendAry[i] = add;
						System.out.println("정상적으로 입력되었습니다." + friendAry[i]);
					}

				}
				break;
			case 3:
				System.out.println("찾고자 하는 성별을 입력하세요");
				String choice = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						String gender = friendAry[i].split(",")[2];
						if (choice.equals(gender)) {
							String name = friendAry[i].split(",")[0];
							String tel = friendAry[i].split(",")[1];
							System.out.printf("이름: %s 전화번호: %s 성별 %s \n", name, tel, gender);
						}
					}
				}
				break;
			case 4:
				System.out.println("삭제하고자 하는 이름을 입력하세요");
				String findName = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						String name = friendAry[i].split(",")[0];
						if (findName.equals(name)) {
							friendAry[i] = null;
							System.out.println("삭제되었습니다.");
						}
					}
				}
				break;
			case 5:
				System.out.println("수정하고자 하는 이름을 입력하세요");
				String selectName = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						String name = friendAry[i].split(",")[0];
						if (selectName.equals(name)) {
							System.out.printf("이름,연락처,성별을 입력하세요  => 홍길동,010-1234-1234,남");
							friendAry[i] = scn.nextLine();
							System.out.println("수정이 완료되었습니다.");
						}
					}

				}
				break;
			case 9:
				run = false;
				break;
			}
		}
	}
}
