package com.yedam.inheritance;

import java.util.Scanner;
/*
 * 친구목록, 등록, 수정, 삭제
 * 수정: 이름, 연락처 입력.
 */

public class FriendExe {
	// 싱글톤.
	// 1. 필드선
	private static FriendExe instance = new FriendExe();

	// 2. 생성자 은닉.
	private FriendExe() {
	}

	// 3. 인스턴스 반환하는 메소드.
	public static FriendExe getInstance() {
		return instance;
	}

	Friend[] friends = new Friend[100];

	public void init() {
		friends[0] = new Friend("홍길동", "010-24242");
		friends[1] = new UnivFriend("현욱", "010-1111", "서울대", "경영");
		friends[2] = new ComFriend("신현욱", "010-24223", "삼성", "인사");
	}

	Scanner scn = new Scanner(System.in);

	// 시작
	public void run() {
		init();
		boolean run = true;
		while (run) {
			System.out.println("1.친구목록 2.등록 3.수정 4.삭제 9.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: {
				friendList();
				break;
			}
			case 2: {
				addFriend();
				break;
			}
			case 3: {
				editFriend();
				break;
			}
			case 4: {
				delFriend();
				break;
			}
			case 9: {
				System.out.println("종료합니다.");
				run = false;
				break;

			}
			default:
				System.out.println("목록을 확인하세요");
			}// end of switch()
		} // while문 종료
	}// end of run();

	// 추가 메서드.
	void friendList() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].showInfo());
			}
		}
	}// end of friendList()

	// 친구: 이름,연락처
	// 학교: 친구 + 학교명, 전공,
	// 회사: 친구 + 회사명, 부서.
	void addFriend() {
		while (true) {
			System.out.println("1.일반친구 2.학교친구 3.회사친구 4.종료");
			int choice = Integer.parseInt(scn.nextLine());
			if (choice == 4) {
				System.out.println("등록을 종료합니다.");
				break;
			}
			if (choice < 1 || choice > 3) {
				System.out.println("올바른값을 입력하세요");
				continue;
			}
			// 이름 연락처
			String name ="";
			String tel = "";
			while (true) {
				System.out.println("이름을 입력하세요");
				name = scn.nextLine();
				//이름의 정상값의 범위
				if (name.length() >= 2 && name.length() <= 10) {
					break;
				}
				System.out.println("2글자 이상 10글자 이하 입력하세요");
			}
			while (true) {
			System.out.println("연락처를 입력하세요");
			tel = scn.nextLine();
			  if(tel.length() >2) {
				  break;
			  }
			  System.out.println("2글자 이상 입렵하세요");
			}
			Friend friend = null;
			if (choice == 1) {
				friend = new Friend(name, tel);
			} else if (choice == 2) {
				System.out.println("학교명을 입력하세요");
				String school = scn.nextLine();
				System.out.println("전공를 입력하세요");
				String job = scn.nextLine();
				friend = new ComFriend(name, tel, school, job);
			} else if (choice == 3) {
				System.out.println("회사명을 입력하세요");
				String comName = scn.nextLine();
				System.out.println("부서를 입력하세요");
				String department = scn.nextLine();
				friend = new UnivFriend(name, tel, comName, department);
			}

			// 빈공간에 저장.
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					break;
				}
			}
			System.out.println("등록완료");
		} // while문 종료
	}// end of addFriend()

	void editFriend() {
		boolean exist = false;
		System.out.println("수정하실 이름을 입력하세요");
		String name = scn.nextLine();
		System.out.println("수정할 것을 말씀하세요 1.전화번호 2.회사명 3.부서 4.대학이름 5.전공");
		int select = Integer.parseInt(scn.nextLine());
		for(int i = 0; i < friends.length; i++) {
			if(friends[i]!= null && friends[i].getFriendName().equals(name)){
				if(select==1) {
					exist = true;
					System.out.println("전화번호 수정해주세요");
					String tel = scn.nextLine();
					friends[i].setPhoneNumber(tel);
					break;
				}else if(select==2) {
					exist = true;
					System.out.println("회사명 수정해주세요");
					String tel = scn.nextLine();
					ComFriend uiv = (ComFriend)friends[i];
					uiv.setCompanyName(tel);
					break;
				}else if(select==3) {
					exist = true;
					System.out.println("부서 수정해주세요");
					String tel = scn.nextLine();
					ComFriend uiv = (ComFriend)friends[i];
					uiv.setDepartment(tel);
					break;
				}else if(select==4) {
					exist = true;
					System.out.println("대학명을 수정해주세요");
					String tel = scn.nextLine();
					UnivFriend uiv = (UnivFriend)friends[i];
					uiv.setUnivName(tel);
					break;
				}else if(select==5) {
					exist = true;
					System.out.println("전공을 수정해주세요");
					String tel = scn.nextLine();
					UnivFriend uiv = (UnivFriend)friends[i];
					uiv.setUnivmajor(tel);
					break;
				}
				
			} 
		}
		if(!exist) {
			System.out.println("찾는이름이 없습니다.");
			return;
		}
		System.out.println("수정이 완료하였습니다.");
	}// end of editFriend()

	void delFriend() {
		int cnt = 0;
		System.out.println("삭제하실 이름을 입력하세요");
		String name = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
			if(friends[i]!= null && friends[i].getFriendName().equals(name)) {
				cnt++;
				friends[i]=null;
			}
		}
		if(cnt==0) {
			System.out.println("찾는이름이 없습니다.");
			return;
		}
		System.out.println("삭제가 완료하였습니다.");
	}// end of delFriend()

}
