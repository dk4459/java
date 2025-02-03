package com.yedam.reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Board의 실행 클래스.
 * 1.글목록 2.글등록 3.삭제 9.종료
 * 
 * */
public class BoardExe {
	// 클래스를 불러올떄 static은 같이 한번에 준비됨.
	// 필드도 같이 불러오기위해서 static선언.
	static Board[] boardRepo = new Board[100]; // 게시글을 등록하는 배열.
	static Scanner scn = new Scanner(System.in);
	static String loginId; // 로그인정보

	public static void initData() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 배열의 샘플데이터.
		// Date 타입에는 예외처리를 해줘야하는데 값마다 넣는게 힘들기때문에 throws에 parseException을 하고
		boardRepo[0] = new Board("게시글제목1", "내용입니다.1", "user01", sdf.parse("2025-01-27"));
		boardRepo[1] = new Board("게시글제목2", "내용입니다.2", "user01", sdf.parse("2025-01-29"));
		boardRepo[2] = new Board("게시글제목3", "내용입니다.3", "user01", sdf.parse("2025-01-30"));
		boardRepo[3] = new Board("게시글제목4", "내용입니다.4", "user01", sdf.parse("2025-01-30"));
		boardRepo[4] = new Board("게시글제목5", "내용입니다.5", "user01", sdf.parse("2025-01-30"));

		boardRepo[5] = new Board("게시글제목6", "내용입니다.6", "user02", sdf.parse("2025-01-30"));
		boardRepo[6] = new Board("게시글제목7", "내용입니다.7", "user02", sdf.parse("2025-01-30"));
		boardRepo[7] = new Board("게시글제목8", "내용입니다.8", "user02", sdf.parse("2025-01-30"));
		boardRepo[8] = new Board("게시글제목9", "내용입니다.9", "user02", sdf.parse("2025-01-30"));
		boardRepo[9] = new Board("게시글제목10", "내용입니다.10", "user02", sdf.parse("2025-01-30"));

		boardRepo[10] = new Board("게시글제목11", "내용입니다.11", "user03", sdf.parse("2025-01-30"));
		boardRepo[11] = new Board("게시글제목12", "내용입니다.12", "user03", sdf.parse("2025-01-30"));
		boardRepo[12] = new Board("게시글제목13", "내용입니다.13", "user03", sdf.parse("2025-01-30"));
	}

	public static void boardList() {
		// 글 목록을 보여주는 메서드.
		// 1페이지: 0~4, 2페이지: 5~9
		// 인덱스 기준이라 삭제가 되면 5개씩 보여주지않음.
		// 삭제가 되도 5개씩 보여줄수있도록.
		//
		int page = 1;
		int lastPage = (int) Math.ceil(getMaxCount() / 5.0); // 13/5 = > 2.6;
		while (true) {
			int firstIdx = page * 5; // page:2 =>5
			int lastIdx = firstIdx - 5; // page:2 =>9
			int Idx = 0;

			System.out.println("번호|   제목   |     내용     |   Id   |    날짜");
			System.out.println("----------------------------------------------");
			for (int i = 0; i < boardRepo.length; i++) {
				if (boardRepo[i] != null) {
					Idx++;
					if (Idx <= firstIdx && Idx > lastIdx) {
						System.out.println(Idx + ".  " + boardRepo[i].showBoard());
					}
				}
			}

//			for (int i=firstIdx; i <= firstIdx + 5; i++) {
//				if (boardRepo[i] != null) {
//					System.out.println(boardRepo[i].showBoard());
//				}
//			}
//			for (int i = firstIdx; i <= lastIdx; i++) {
//				if (boardRepo[i] != null) {
//					System.out.println(boardRepo[i].showBoard());
//				}
//			}
			System.out.println("이전페이지:p, 이후페이지:n, 종료:q");
			String paging = scn.nextLine();
			if (paging.equals("n")) {
				// 마지막페이지보다는 작은값.
				if (page < lastPage) {
					page++;
				}
			} else if (paging.equals("p")) {
				if (page > 1) {
					// 1보다는 큰값.
					page--;
				}
			} else if (paging.equals("q")) {
				return;
			}
		} // end of while.
	}

	// 배열을 매개값으로 전달하면 건수가 몇건 반환 메소드.
	public static int getMaxCount() {
		int count = 0; // 전체 건수
		for (int i = 0; i < boardRepo.length; i++) {
			if (boardRepo[i] != null) {
				count++;
			}
		}
		return count; // 건수반환.
	}

	public static void addBoard() {
		// 글 등록 메서드.
		// 제목: 5글자 이상 ~ 15글자 이하. 콘솔출력("등록불가합니다");
		// 똑같은 글제목이 있으면 콘솔출력("이미 있는 제목입니다.");
		System.out.print("제목을 입력>>");
		String title = scn.nextLine();
		System.out.print("내용을 입력>>");
		String content = scn.nextLine();
//		System.out.print("아이디를 입력>>");
//		String writer = scn.nextLine();
//		String name = login(id,pw);
//		System.out.print("날짜를 입력>>");
//		String writeDate = scn.nextLine();
		// 배열의 빈공간에 입력한 데이터를 입력.
		// 작성시의 시스템날짜로 변경
		if (title.length() <= 15 && title.length() >= 5) {
			for (int i = 0; i < boardRepo.length; i++) {
				if (title.equals(boardRepo[i].getTitle())) {
					System.out.println("이미 있는 제목입니다.");
					break;
				} else if (boardRepo[i] == null) {
					boardRepo[i] = new Board(title, content, loginId, new Date());
					System.out.println("등록완료.");
					break; // 한건만 등록.
				}
			}
		} else {
			System.out.println("등록불가합니다.");
			return;
		}
	}

	public static void removeBoard() {
		// 글 삭제 메서드. 글 제목을 입력받고 한건삭제
		System.out.print("삭제하고싶은 제목을 입력>>");
		String title = scn.nextLine();

		for (int i = 0; i < boardRepo.length; i++) {
			if (boardRepo[i] != null && boardRepo[i].getTitle().equals(title)) {
				boardRepo[i] = null;
				System.out.println("삭제완료.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		// MemberExe 클래스
		// static 선언시 인스턴스 선언 안하고 클래스.메소드 해도 불러오기 가능.
//		MemberExe exe = new MemberExe(); // 인스턴스 선언

		while (true) {
			// id, password 일치하면 글목록기능 사용.
			System.out.println("아이디 입력>>");
			String id = scn.nextLine();
			System.out.println("비밀번호 입력>>");
			String pw = scn.nextLine();
			String name = MemberExe.login(id, pw);
			if (name != null) {
				// 로그인 성공시 이름 출력.
				System.out.println("로그인을 성공했습니다.");
				System.out.println(name + "님 환영합니다.");
				break; // while 반복종료.
			} else {
				System.out.println("아이디와 비밀번호를 확인하세요.");
			}
		} // 로그인 끝
		boolean run = true;
		try {
			initData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 초기데이터 생성.
		while (run) {
			System.out.println("1.글목록 2.글등록 3.삭제 9.종료");
			System.out.println("--------------------------");
			System.out.print("선택>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 목록.
				boardList();
				break;
			case 2: // 등록.
				addBoard();
				break;
			case 3: // 삭제.
				removeBoard();
				break;
			case 9: // 종료.
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default: // 1, 2, 3, 9 외의 경우.
				System.out.println("메뉴를 확인하세요.");
			} // end of switch
		} // end of while.
		System.out.println("end of prog.");

	} // end of main.
}