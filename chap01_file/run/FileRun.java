package com.kh.chap01_file.run;

import java.io.File;
import java.io.IOException;

public class FileRun {

	/*
	 * * File 클래스
	 * 자바 구문을 통해 파일 또는 폴더를 만들거나
	 * 그 이외의 부가적인 기능을 제공하는 자바 클래스
	 * java.io 패키지에 존재함
	 * > File 객체가 생성됬다고 해서 파일이 셀제로 만들어진건 아님!!
	 */
	public static void main(String[] args) {
		try {
			// * 파일 만들어보기
			// 1. 별도의 경로지정을 하지 않고 파일명 (test.txt) 만 제시해서 생성 
			File file1 = new File("test.txt");
			file1.createNewFile();
			// > 현재 내가 작업중인 이 12_IO 프로젝트 폴더내에 바로 생성됨
			
			// 2. 경로 지정을 한 파일명(C:\\aaa\\test.text) 을 제시해서 생성
			// File file2 = new File("C:\\aaa\\test.txt");
			File file2 = new File("C:/aaa/test.txt");
			file2.createNewFile();
			// > 반드시 존재하는 폴더 경로로 제시해야함!!
			// 즉, C:/aaa 라는 폴더가 이미 존재해야지 파일이 만들어짐
			
			/*
			 * * 절대경로와 상대경로
			 * - 절대경로 : C 드라이브 또는 D 드라이브 (루트 디렉토리)
			 * 			  모든 경로를 경유하여 전부 기입하는 방식
			 * - 상대경로 : 반대로 루트 디렉토리로 시작하지 않는 방식
			 */
			
			// 3. 폴더를 생성하고 나서 그 안에 파일을 생성하는 방법
			File bbbFolder = new File("C:\\bbb");
			bbbFolder.mkdir(); // mkdir == make directory (폴더만들기)
			
			File file3 = new File("C:\\bbb\\text.txt");
			file3.createNewFile();
			
			
			// 4. "별도의 경로 지정 없이" 폴더 생성 후 파일 생성하기
			File folder = new File("test"); // 상대경로방식
			folder.mkdir();
			// > 폴더 또한 상대경로방식일 경우 현재 내가 작업중인
			//   이 프로젝트 폴더 내에 바로 만들어진다.
			
			File file = new File("test\\person.txt"); // 상대경로방식
			file.createNewFile();
			
			// * File 클래스에서 제공하는 유용한 메소드들
			// folder.mkdir() : 폴더를 생성해주는 메소드
			// file.createNewFile() : 파일을 생성해주는 메소드
			
			System.out.println(folder.isFile()); // 폴더이므로 false
			System.out.println(file.isFile()); // 파일이므로 true
			// > isFile() : 파일인지 검사 후 파일이면 true / 아니면 false 리턴
			
			System.out.println("파일명 : " + file.getName()); // person.txt
			System.out.println("상위폴더 : " + file.getParent()); // test 상위폴더 이름만 나옴
			System.out.println("절대경로 : " + file.getAbsolutePath());
			//  C:\01_Java-workspace\12_IO\test\person.txt
			
			System.out.println("파일용량 : " + file.length()); // 16(byte 단위) 안녕하세요. 를 적어둔 기준
			file.delete(); // 파일삭제
			
		}catch(IOException e){
			e.printStackTrace(); // 어떤 문제가 발생했는지
		}
		System.out.println("프로그램 종료");
	}

}


/*
 * * IO(InputOutput, 입출력)
 * 프로그램 상의 데이터를 "외부매체" 내보내거나, "외부매체" 로부터 읽어들이는 과정
 * - 내보내는 방향 : Output (출력)
 * - 읽는 방향 : Input(입력)
 * > 항상 기준점은 내가 작성중인 이 프로그램!!
 * 
 * * 프로그램 상의 데이터를 외부매체 (모니터, 스피커, "파일" 등) 로 출력하거나
 * 	 입력장치 (키보드, 마우스, ..등) 로 입력받는 과정을 거치려면 반드시
 *   프로그램과 그 외부매체 사이의 "연결 통로" 를 만들어 줘야 한다!!
 *   > 연결통로 == "스트림" (Stream)
 *   
 *   
 * * 스트림의 특징
 * - 단방향성 (일반통행)
 * : 입력이면 입력, 출력이면 출력
 *   즉, 입력용, 출력용 스트림이 각각 "따로" 존재함
 *   (동시에 입출력 하고자 한다면 하나의 스트림으로는 절대 불가함)
 * - 선입선출 (First In, First Out - FIFO) 
 * : 먼저 통로로 진입한 값이 제일 먼저 나가게 됨
 * - 시간지연 문제가 생할 수 있다 (delay)
 * 
 * * 스트림의 구분
 * - 통로의 사이즈 (너비)
 * 바이트 스트림 : 1byte 짜리가 이동할 수 있을 정도의 사이즈 (좁은 통로)
 * 				입력 (XXXInputStream) / 출력 (XXXOutputStream)
 * 문자 스트림 : 2byte 짜리가 이동할 수 있을 정도의 사이즈(넓은 통로)
 * 				입력 (XXXReader) / 출력 (XXXWriter)
 * 
 * - 외부매체와의 직접적인 연결 여부
 * 기반 스트림 : 외부 매체와 직접적으로 연결되는 메인 통로
 * 보조 스트림 : 기반 스트림 만으로 부족한 성능을 향상시켜주는 용도의 스트림
 * 			  절대 단독으로 사용 불가(즉, 메인 통로로써는 못쓴다)
 * 			  반드시 기반 스트림과 "결합" 해서 같이 쓴다.
 * 			  예) 속도 향상, 객체 단위로 입출력하게 도와줌, 자료형에 데이터를 맞춰 변환 등...
 * 
 */


