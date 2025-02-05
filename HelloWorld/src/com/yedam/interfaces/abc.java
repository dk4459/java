package com.yedam.interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;

public class abc {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date day = null;
		
		System.out.println(sdf.format(day));
		
	}
}
