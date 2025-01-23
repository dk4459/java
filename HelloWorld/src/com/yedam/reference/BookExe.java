package com.yedam.reference;

import java.util.Scanner;

/*
 * 도서명, 저자, 출판사, 판매가격
 */
public class BookExe {
	public static void main(String[] args) {
		Book[] bookRepository = new Book[100];
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			//1.전체목록 2.도서등록 3.조회(출판사명) 9.종료
		System.out.println("1.전체목록 2.도서등록 3.조회(출판사명) 9.종료");
		  int menu = Integer.parseInt(scn.nextLine());
		  
		  switch(menu) {
		  case 1:
			  for (int i = 0; i<bookRepository.length; i++) {
				  if(bookRepository[i]!=null) {
					  System.out.printf("책이름: %s 저자: %s 출판사: %s 가격%s \n",
							  bookRepository[i].bookName,
							  bookRepository[i].bookWrite,
							  bookRepository[i].chul,
							  bookRepository[i].pay);
				  }
			  }
			  break;
		  case 2:
			  for(int i = 0; i<bookRepository.length; i++) {
				  if(bookRepository[i]==null) {
				  System.out.println("도서명");
				  String bookName = scn.nextLine();
				  if(bookName.equals("stop")) {
					  break;
				  };
				  System.out.println("저자");
				  String bookWrite = scn.nextLine();
				  System.out.println("출판사");
				  String chul = scn.nextLine();
				  System.out.println("가격");
				  String pay = scn.nextLine();
				   bookRepository[i] = new Book(bookName,bookWrite,chul,pay);
				  }
			  }
			  System.out.println("등록이 완료되었습니다.");
			  break;
		  case 3:
			  System.out.println("찾고자 하는 출판사이름을 입력하세요");
			  String chul = scn.nextLine();
			  for(int i = 0; i<bookRepository.length; i++) {
				 if(bookRepository[i] != null) {
					 if(chul.equals(bookRepository[i].chul)) {
						 System.out.printf("책이름: %s 저자: %s 출판사: %s 가격%s \n",
								  bookRepository[i].bookName,
								  bookRepository[i].bookWrite,
								  bookRepository[i].chul,
								  bookRepository[i].pay);
					 }
				 } 
			  }
			  break;
		  case 9:
			  System.out.println("종료합니다.");
			  run = false;
			  break;
		  }
		}
		
	} // end of main
}
