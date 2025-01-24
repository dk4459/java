package com.yedam.reference;

public class CaculatorExe {
	public static void main(String[] args) {
		
		Book[] bookStore = { new Book("이것이 자바다","신용권","한빛미디어","5000")//
		  		  , new Book("자바스크립트","김자바","자바출판사","15000")//
	     	  	  , new Book("혼자공부하는자바","혼공자","한빛미디어","20000")//
	     	  	, new Book("혼자공부하는자바스크립트","CSS","한빛미디어","24000")//
	     	  	, new Book("혼자공부하는HTML","HTML","한빛미디어","22000")//
		   };
		
		Caculator cal = new Caculator();
		
		Book author = cal.getBookInfo("혼자공부하는HTML",bookStore);
		if(author!=null) {
			//author.showDetailInfo();
		}else {
			System.err.println("조회결과 없음");
		}
		
		int[] ary1 = {14,23,11,14,24};
		int[] ary2 = {33,23,6,12,9};
		//System.out.println(cal.getMax(cal.sum(ary1),cal.sum(ary2)));      
		int [] randomA = cal.randomAry(5); 
		
		for(int num : randomA) {
			System.out.println(num);
		}
		//System.out.println(cal.sum(randomA));
		//cal.printStar(10,"○");
		
		//System.out.printf("두 수의 합은 %f입니다.",cal.sum(4.0, 5.5));
	    
		double result = cal.sum(new int[] {10,20,30,40});
		
		//System.out.println(result);
		
		// cal.start();
		 
		// cal.placeStart(20);
		//cal.tri(); 
		
		cal.showCalendar();
	
	}    
}
