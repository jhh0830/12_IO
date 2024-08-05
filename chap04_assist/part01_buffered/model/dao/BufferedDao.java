package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// BufferedReader / BufferedWriter
public class BufferedDao {
	
	// 프로그램 (기준점) ---> 외부매체 (파일)
	// 출력
	public void fileSave() {
		
		// FileWriter
		// +
		// BufferedWriter
		// try catch문
		/*
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			
			// 1. 통로 열기
			// 1_1. 기반스트림 객체 먼저 생성 (메인통로 먼저 만들기)
			// 
						
			// 1_2. 보조스트림 객체 생성 (이미 만들어진 기반스트림 객체를 넘기면서)
			bw = new BufferedWriter(fw = new FileWriter("c_buffer.txt"));
			
			
			
			// 2. 볼일 보기
			bw.write("안녕하세요");
			bw.newLine();// 개행을 넣어주는 메소드
			bw.write("반갑습니다\n");
			bw.write("저리가세요");
			
			
			// 3. 통로 닫기(반드시 - finally)
		
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				// 3. 통로 닫기 == 자원 반납하기
				// > 생성된 순서의 "역순" 으로 반납하기!!
				try {
				bw.close();
				//fw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		System.out.println("프로그램 종료");
	*/
		//try ~ with ~ resource구문 (JDK 7 이상부터 지원 가능)
		/*
		 * try(스트림객체생성구문; 스트림객체성생구먼 for문처럼 마지막에 ;만 안붙이히면됨){
		 *  	예외가 발생할버반 구문;
		 *  
		 *  
		 * }catch(예외클래스명 변수명){
		 * 		예외가 발생했을 때 실행할 코드;
		 * 
		 * }
		 * > 스트림 객체를 try(여기) 에서 생성하면
		 * 	 스트림 객체 생성 후 해당 try 블록 구문이 안료되면
		 * 	 알아서 자원 반납이 된다!!
		 */
		try(BufferedWriter bw 
				= new BufferedWriter(new FileWriter("c_buffer.txt"))){
		bw.write("안녕하세요");
		bw.newLine();
		bw.write("반갑습니다\n");
		bw.write("저리가세요");
		
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
	// 프로그램 (기준점) <-- 외부매체 (파일)
	// 입력
	public void fileRead() {
		// FileReader
		// +
		// BufferedReader
		
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
			/*
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			// > 더이상 읽어들일 내용이 없다면 null을 반환
			  */
			// 1) 해결방법
			/*
			while(br.readLine() !=null) {
				String value= br.readLine();
				if(value == null) {
					break;
				}
				System.out.println(value);
			}
			*/
			
			//2) 해결방법
			String value = null;
			while((value = br.readLine())!= null) {
				System.out.println(value);
			}
			
			 
		}catch(FileNotFoundException e) {
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}
}
