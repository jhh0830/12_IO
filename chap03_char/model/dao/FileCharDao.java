package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class FileCharDao {
	
	/*
	 * 1. 통로 열기
	 * 2. 볼일 보기
	 * 3. 통로 닫기
	 */
	
	// 프로그램 (기준점) --> 외부매체(파일)
	// 출력 : 파일로 데이터를 내보내겠다. 쓰겠다.
	public void fileSave() {
		FileWriter fw = null;
		try {
		// XXXWriter
		// > "파일" 로 데이터를 2byte 단위로 출력하는 스트림
		
		// 1. 통로 열기
		// > 통로를 열겠다 == 스트림 객체를 생성하겠다.
		 fw = new FileWriter("b_char.txt",false);
		
		// > 출력 통로는 존재하지 않는 파일명 제시 시,
		//   해당 파일을 만들고 나서 연결 통로가 만들어짐
		
		
		
		// 2. 볼일 보기
		// > 2byte 단위로 데이터 읽어들이기
		//   write() 메소드 이용
		fw.write("와! IO 재밌다..ㅎ\n");
		// > 해당 문자열의 문자 하나하나씩 전송되는 개념
		// > 한글도 전송 가능함!!
		fw.write('A');
		fw.write(' ');
		fw.write('\n');
		
		char[] cArr  = {'k','i', 'w', 'i'};
		fw.write(cArr);
		// 3. 통로 닫기(반드시 -finally에서 작성)
		
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
			//3. 통로 닫기
			fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
	// 프로그램 (기준점) <---- 외부매체(파일)
	// 입력 : 파일로부터 데이터를 가져오겠다. 읽어들이겠다.
	public void fileRead() {
	
		
		// 0. FileReader = null로  선언
		FileReader fr = null;
		
		
		try {
			
		// FileReader
		// > "파일" 로부터 데이터를 2byte 단위로 입력받는 스트림
		
		// 1. 통로 열기
		// > 통로를 열겠다 == 스트림 객체를 생성하겠다
		 fr = new FileReader("b_char.txt");
		// > 반드시 존재하는 파일명으로만 제시해야한다!!
		
		// 2. 볼일 보기
		// > 2byte 단위로 읽어들이는 작업
		//   read() 메소드를 이용
		/*
		 System.out.println(fr.read());
		System.out.println(fr.read());
		System.out.println(fr.read());
		System.out.println(fr.read());
		*/
		// > 마찬가지로 반목문 활용이 가능함
		// 단, 파일의 끝을 만났을 경우 -1을 리턴
		 /*
		 while(fr.read() != -1) {
			 System.out.println(fr.read());
		 }
		
		*/
		 // > 퐁당퐁당 출력
		 
		 // 1) 해결방법
		/*
		 while(true) {
			 int value = fr.read();
			 
			 if(value == -1) {
				 break;
			 }
			 System.out.println(value);
		 }
		 */
		 // 2) 해결방법
		 int value = 0;
		 while((value=fr.read()) != -1) {
			 System.out.print((char)value);
		 }
		System.out.println();
		// 3. 통로 닫기 - (반드시 finally 에서 작업)
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e) {
			
		}finally {
			try {
				
			
			// 3. 통로 닫기
			fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("프로그램 종료");
	}
}
