package com.yedam.exception;

import com.yedam.reference.Student;

public class NullPointException {
	public static void main(String[] args) {
		
		Student student = null;
		String[] strAry = {"Hello","World"};

		// 예외처리.
		try {
			strAry[2]= "Nice";
			System.out.println(student.getStudentName());
		} 
//		catch (NullPointerException | ArrayIndexOutOfBoundsException d) {
//			System.err.println("널 포인트 어레이인덱스 아웃 오프 바운스 인셉션?");
//			d.printStackTrace();
//		}
		catch(NullPointerException e) {
			System.out.println("null값을 참조 또는 배열 볌위 초과");
			e.printStackTrace();
		}
//		catch(ArrayIndexOutOfBoundsException d) {
//			System.err.println("어레이인덱스 아웃 오프 바운스 인셉션?");
//		}
	}
}
