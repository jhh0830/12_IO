package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO (Data Access Object) 클래스
// 데이터가 보관되어있는 "외부 매체" 와 직접 접근 (연결) 해서
// 데이터를 입출력하는 용도의 클래스
public class FileByteDao {
	
	/*
	 * * 입출력 과정(3 step)
	 * 1. 통로 열기
	 * 2. 볼일 보기 (입력이든 출력이든 간에)
	 * 3. 통로 닫기
	 * 
	 */
	
	// 프로그램 (기준점) ---> 외부매체 (파일)
	// 출력 : 프로그램 내의 데이터를 파일로 내보내기 (즉, 파일로 기록하겠다)
	public void fileSave() {
		// FileOutputStream
		// "파일" 로 데이터를 1byte 단위로 출력해주는  스트림
		
		// 0. FileOutputStream 변수 선언 및 null 로 초기화 
		// > finally 에서의 지역변수 이슈를 해결하기 위해
		FileOutputStream fout = null;
		
		try {
			// 1. 통로 열기
			// > 통로를 열겠다 == 스트림 객체를 생성하겠다.
			fout = new FileOutputStream("a_byte.txt");
			// > 객체 생성 시 연결하고자 하는 파일명을 제시함
			//   해당 파일이 존재하지 않으면
			//   해당 파일이 생성되고 그 이후에 통로가 연결됨
			//   해당 파일이 존재한다면 그냥 통로가 연결됨
			//  (파일명만 제시 시 현재 내가 작업중인 프로젝트 폴더 내에 생성)
			//fout = new FileOutputStream("a_byte.txt", true);
			// > 매개변수로 true 미작성 시 : 기존에 해당 파일이 있을 경우
			//                          내용이 "덮어씌여짐"
			// 							(false도 마찬가지)
			// > 매개변수로 true 작성 시 : 기존에 해당 파일이 있을 경우
			// 							내용이 "이어 쓰여짐"
			
			// 2. 볼일 보기
			// > 1byte 단위로 "내보내는" 작업 
			//   write() 메소드 사용
			// 1byte : -128 ~ 127 까지의 숫자
			// 단, 파일에 기록되기를 0~ 127 까지만 기록됨 (아스키 코드표에 의해)
			fout.write('a'); // a 기록
			fout.write(98); // b 기록
			// > 파일에 기록되기를 아스키 코드표에 의한 문자로 기록됨!!
			
			//fout.write('김');
			// > 한글은 2byte 이기 때문에 깨져서 저장
			//   (바이트 스트림으로는 제한적임)
			byte[] bArr = {99, 100, 101};
			fout.write(bArr); // cde 기록
			// > 오버 로딩
			
			fout.write(bArr, 1,2);
			// > 오버 로딩
			
			// 3. 통로 닫기 (반드시 - finally 블럭에서 작성)
			// > 통로 닫기 == 다 쓴 자원 반납하기
			// close() 메소드 사용
			// fout.close():
			// > 위에서 혹시 예외가 발생할 경우
			// 	 바로 catch 블럭으로 흐름이 빠지면서 실행이 안됨
			
			
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			// > IOException 은 FileNotFoundException의 부모
			e.printStackTrace();
		} finally {
			// 예외가 발생하든, 발생하지 않든 간에
			// 마지막으로 반드시 실행할 구문이 있다면 finally 블럭에서 작성
			try {
			// 3. 통로닫기
			fout.close();
		}catch(IOException e) {
			e.printStackTrace();
			
			
		}
		}
		
		System.out.println("프로그램 종료");
	
		
	}
	
	// 프로그램 (기준점) <--- 외부매체 (파일)
	// 입력 : 파일로부터 데이터를 가지고 오겠다. 읽어들이겠다.
	public void fileRead() {
		
		// FileInputStream
		// : "파일" 로부터 데이터를 1byte 단위로 입력받는 스트림
		
		// 0. FileInputStream 변수 선언 및 null 로 초기화
		FileInputStream fin = null;
		
		try {
		// 1. 통로 열기
		// > 통로를 열겠다 == 스트림 객체를 생성하겠다.
		fin = new FileInputStream("a_byte.txt");
		// > FileInputStram 객체 생성 시
		// 	 기존에 존재하지 않는 파일명을 제시 했을때
		//   FileNotFoundException 이 뜬다!!
		
		
		
		// 2. 볼일 보기
		// > 해당 파일로부터 데이터를 1byte 단위로 읽어들이는 작업
		//   read() 메소드 이용
		// > 문자로써 기록되어있어도 읽어들일 때는 아스키 코드표에 의해
		// 	 숫자로 읽어들임!!
		/*
		System.out.println(fin.read()); // 97
		System.out.println(fin.read()); // 98
		System.out.println(fin.read()); // 99
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		// --- 더이상 읽어들일 데이터가 없음 ---
		System.out.println(fin.read()); // -1
		// 파일의 끝을 만나는 순간 -1 리턴
		*/
		/*
		while(fin.read() != -1) {
			System.out.println(fin.read());
		}
		*/
		// > 퐁당퐁당 출력됨
		//   반복 1회차 당 read 메소드가 검사용 1번, 출력용 1번
		//   총 2번씩 호출되기 때문
		
		// 해결방법1)
		// 무한반복을 이용해서 매번 조건검사 하기
		/*
		while(true) {
			int value = fin.read();
			
			if(value == -1) {
				break;
			}
			
			System.out.println(value);
		}
		*/
		
		// 해결방법2) 조건식 내부에 "대입" 구문을 활용하기
		int value = 0;
		while((value = fin.read()) != -1) {
			System.out.println((char)value);
			
		}

		 
		
		
		// 3. 통로 닫기(반드시 - finally 블럭에서 작업)
		// > 통로 닫기 == 다 쓴 자원을 반납하기
		
		
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
			// 3. 다 쓴 스트림 자원 반납
			fin.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
		
	}
}
