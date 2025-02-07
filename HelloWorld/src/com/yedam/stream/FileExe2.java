package com.yedam.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//버퍼 스트림 사용
public class FileExe2 {
	public static void main(String[] args) {
		// 보조스트림(입출력스트림)
		try {
			Reader reader = new FileReader("c:/temp/student.txt");
			// 보조스트림 매개변수에 일반스트림을 넣음.
			BufferedReader br = new BufferedReader(reader); 
			while (true) {
				String str = br.readLine(); //한라인씩 읽어오기
			//만약 읽을 값이 없으면 null을 반환.
				if(str == null) {   
				break;
				}
				String[] strAry =str.split(" "); //구분자 공백
				System.out.println("이름: "+strAry[0]+","
						+ "영어: "+strAry[1]+"수학: "+strAry[2]);
			}
			
			//보조스트림 끄기
			br.close(); 
			//일반스트림 끄기
			reader.close(); 
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
