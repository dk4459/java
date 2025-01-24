package com.yedam.reference;

public class Book {
	private String bookName;
	private String bookWrite;
	private String chul;
	private String pay;
	public Book(String bookName, String bookWrite, String chul, String pay) {
		super();
		this.bookName = bookName;
		this.bookWrite = bookWrite;
		this.chul = chul;
		this.pay = pay;
	}
	void showDetailInfo() {
		// 도서명: 이것이 자바다  출판사: 한빛미디어 
		// 저 자: 신용권       가격: 25000 원
		System.out.printf("도서명: %-10s 출판사: %-6s\n저 자: %-10s 가 격: %-5s 원\n",bookName,bookWrite,chul,pay);
	 }
	 
	public Book(String pay) {
		super();
		this.pay = pay;
	}

	//제목, 저자 ,가격
	public String showBookInfo() {
		
		String result = "책이름: "+bookName+"  저자: "+bookWrite+"  출판사: "+chul+"  가격: "+pay+"원 입니다.";
		
		return result;
	}
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWrite() {
		return bookWrite;
	}
	public void setBookWrite(String bookWrite) {
		this.bookWrite = bookWrite;
	}
	public String getChul() {
		return chul;
	}
	public void setChul(String chul) {
		this.chul = chul;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		if(Integer.parseInt(pay)<0) {
			this.pay = "0";
			return;
		}
		this.pay = pay;
	}
	
	
}
