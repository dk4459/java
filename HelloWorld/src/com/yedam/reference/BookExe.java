package com.yedam.reference;

import java.util.Scanner;

/*
 * 도서명, 저자, 출판사, 판매가격
 */
public class BookExe {
	static Book[] bookRepository = new Book[100];
	static Scanner scn = new Scanner(System.in);
	//저장 공간에 값을 초기값을 생성.
	public static void init() {
		bookRepository[0] = new Book("이것이 자바다", "신용권", "한빛미디어", "7000");
		bookRepository[1] = new Book("이것이 자바다1", "신용권", "한빛미디어", "7000");		
	}//end of init();
	
	//목록 출력
	public static void printList() {
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null) {
				System.out.println(bookRepository[i].showBookInfo());
			}
		}
	}//end of printList();
	
	//도서등록
	public static void addBook() {
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] == null) {
				System.out.println("도서명");
				String bookName = scn.nextLine();
				if (bookName.equals("stop")) {
					break;
				}
				;
				System.out.println("저자");
				String bookWrite = scn.nextLine();
				System.out.println("출판사");
				String chul = scn.nextLine();
				System.out.println("가격");
				String pay = scn.nextLine();
				bookRepository[i] = new Book(bookName, bookWrite, chul, pay);
			}
		}
		System.out.println("등록이 완료되었습니다.");
	}//addbook end
	
	public static void findBook() {
		System.out.println("찾고자 하는 출판사이름을 입력하세요");
		String chul = scn.nextLine();
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null) {

				if (chul.equals(bookRepository[i].getChul())) {
					System.out.println(bookRepository[i].showBookInfo());
				}
			}
		}
	}//end findBook
	
	public static void modifyBook() {
		boolean isExist = false;
		System.out.println("변경하고자하는 책이름을을 입력하세요");
		String bookName = scn.nextLine();
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && bookName.equals(bookRepository[i].getBookName())) {
				System.out.println("수정하고자하는 가격 입력하세요");
				String pay = scn.nextLine();
				bookRepository[i].setPay(pay);
				System.out.println("수정완료되었습니다.");
				isExist = true;
				break;
			}
		} // end of for.
		
		if (!isExist) {
			System.out.println("찾는 도서가 없습니다.");
		}
	}//end of modify
	
	public static void removeBook() {
		boolean isExist = false;
		System.out.println("삭제하고자하는 책이름을을 입력하세요");
		String bookName = scn.nextLine();
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && bookName.equals(bookRepository[i].getBookName())) {
				bookRepository[i] = null;
				System.out.println("삭제완료되었습니다.");
				isExist = true;
				break;
			}
		} // end of for.
		
		if (!isExist) {
			System.out.println("찾는 도서가 없습니다.");
		}
	}//end of remove()
	
	public static void detailBook() {
		System.out.println("상세하는 책이름을을 입력하세요");
		String bookName = scn.nextLine();
		boolean isExist = false;
//      for(int i =0; i<bookRepository.length; i++) {
//    	  if(bookRepository[i] != null&& bookName.equals(bookRepository[i].getBookName())) {
//    		  bookRepository[i].showDetailInfo();
//    		  isExist =  true;
//			  break;
//    	  }
//      }
//      if(!isExist) {
//		  System.out.println("찾는 도서가 없습니다.");
//	  }
		Caculator cal = new Caculator();
		cal.getBookInfo(bookName, bookRepository).showDetailInfo();
	}//end of detail()
	
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			// 1.전체목록 2.도서등록 3.조회(출판사명) 9.종료
			System.out.println("1.전체목록 2.도서등록 3.조회(출판사명) 4.수정 5.삭제 6.상세조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			init();// 초기데이터 생성
			switch (menu) {
			case 1:
			    printList();
				break;
			case 2:
				addBook();
				break;
			case 3:
				findBook();
				break;
			case 4:
				modifyBook();
				break;
			case 5:
				removeBook();
				break;
			case 6:
				detailBook();
				break;
			case 9:
				System.out.println("종료합니다.");
				run = false;
				break;
			}
		}

	} // end of main
}
