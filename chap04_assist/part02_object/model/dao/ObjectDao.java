package com.kh.chap04_assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectDao {
	
	// 프로그램 (기준점) ---> 외부매체 (파일)
	// 출력
	public void fileSave() {
		
		// FileOutputStream 
		// (byte가 차이가 나면 사용할수가없기때문에 늘 맞춰줘야한다)
		// +
		// ObjectOutputStram
		
		// 테스트용 객체 생성
		Phone ph = new Phone("아이폰 13", 1200000);
		
		
		
		// 0. 스트림 변순 선언 및 null 로 초기화
		ObjectOutputStream oos = null;
		try {
		// 1. 통로 열기 (스트림 객체 생성)
			
			
			oos = new ObjectOutputStream(new FileOutputStream("phone.txt"));
		
		
			// 2. 볼일 보기
			// > 객체 단위로 데이터를 파일로 내보내야 함!!
			//   writeObject() 메소드 이용
			oos.writeObject(ph); // 업캐스팅
			// > 해당 VO 클래스 선언부에 "직렬화 선언" 을 해야 제대로 출력됨
			// > 객체 단위로 기록되어있어서 파일로는 깨져 보이지만
			//   실제로 제대로 기록된 것!!
			// 3. 통로 닫기 (자원 반납) - 반드시 (finally 에서)
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
			// 3. 자원 반납
			oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("프로그램 종료");
		}
		// 프로그램 (기준점) <-- 외부매체 (파일)
		// 입력 
	public void fileRead() {
		
		// FileInputStream
		// + 
		// ObjectInputStream
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phone.txt"))){
			
			//객체 단위로 읽어들이는 메소드
			// > readObject() 메소드 이용
			Phone p = (Phone)ois.readObject(); // 다운캐스팅
			
			System.out.println(p /*.toStirng*/);
			
		}catch(FileNotFoundException e) {
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	System.out.println("프로그램 종료");	
	}
		
	}
	
