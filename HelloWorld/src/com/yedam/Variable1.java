package com.yedam;

public class Variable1 {
	public static void main(String[] args) {
		//int(4byte)
		int num1 = 1001111;
		
		byte num2 = 27;
		//short(2byte)
		short num3 = 256;
		long num4 = 1000000000000000000L;
		System.out.println(Long.MAX_VALUE);
		
		byte num5 = 20;
		//강제형변환(casting)
		byte result = (byte)(num2 + num5); 
		int intResult = num1 + num5;
		System.out.println(intResult);
		//데이터타입 변수이름 = 값 
		int[] intAry =  {10,20,82,11};
		String[] strAry = { "Hong","Park","choi" };
		
		strAry[2] ="Kim";
		
		 // 크기 10을 생성
		int[] anotherAry = new int[10];
		for(int i=0; i<anotherAry.length; i++) {
			anotherAry[i] = (int)(Math.random() *100);
		}
		// 배열값을 출력.
		for(int num : anotherAry) {
			System.out.println(num);
		}
		System.out.println(anotherAry);
		
		int sum = 0; 
		 for(int i=0; i<intAry.length; i++) {
			 sum += intAry[i];
		 }
		 
		 System.out.println("총 값은: "+ sum+ "입니다.");
	}
}
