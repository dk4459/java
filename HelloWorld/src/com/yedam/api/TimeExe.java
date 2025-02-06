package com.yedam.api;

public class TimeExe {
	public static void main(String[] args) {
		// 1부터 100,000,000 까지 짝수합을 구하는 시간.
		
		long time1 = System.nanoTime();
		long sum = 0;
		for(long i =1 ; i<=100000000000L; i++) {
			if(i%2 == 0) {
				sum += i;
			}
		}
		long time2 = System.nanoTime();
		int minute = (int) ((time2-time1)/1000000000/60);
		int seconds = (int) ((time2-time1)/1000000000%60);
		System.out.println("짝수 합: "+sum+" 걸린시간 :"+minute+"분 "+seconds+"초" );
	}
}
