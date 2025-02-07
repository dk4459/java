package com.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileExe {
	public static void main(String[] args) {
		try {
			Reader rd = new FileReader("c:/temp/ListExe.java");
			while(true) {
				int chr = rd.read(); //char(2byte)
				System.out.print((char)chr);
				if(chr == -1) {
					break;
				}
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("end of prog.");
	}
	
	
	//문자기반 파일생성
	void write() {
		//문자기반 파일출력.
				try {
					
					Writer wr = new FileWriter("c:/temp/test2.txt");
					wr.write(65); //int매개값.
					wr.write(new char[] {'B','C'});
					
					wr.write("DEFGHI",2,3); // 2번째인덱스로부터 3개까지만 가져오기 ex)FGH 
					wr.flush();wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	//★바이트 기반 파일복사.★
	void copy() {
		// c:/temp/sample.PNG -> c:/temp/copy.PNG 생성
				try {
					InputStream is = new FileInputStream("c:/temp/sample.jpg");
					OutputStream os = new FileOutputStream("c:/temp/copy.jpg");
					byte[] buf = new byte[1000]; //배열 사용하면 여러개의 바이트를 한번에 처리가 가능
					while(true) {
						int data = is.read(buf);
						System.out.println(data);
						os.write(buf); 
						if(data == -1) {
							break;
						}
					}
					is.close();
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				

				System.out.println("end of prog");

	}
	//바이트기반 파일읽기
	static void input() {
		try {
			InputStream is = new FileInputStream("c:/temp/test1.dat");
			while (true) {
				int data = is.read(); // 한 바이트를 일고 반환. 읽을게 없으면 -1
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//바이트기반 파일생성.
	static void output() {
		// 출력스트림(바이트기반) OutputStream.
		try {
			OutputStream os = new FileOutputStream("c:/temp/test1.img");
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
