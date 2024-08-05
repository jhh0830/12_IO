package com.kh.chap04_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectsDao {
	
	// 프로그램 (기준점) --> 외부매체 (파일)
	public void fileSave(String fileName) {
		
		// 휴대폰들의 정보를 객체배열로 나타내기
		Phone[] arr= new Phone[3];
		
		arr[0] = new Phone("아이폰", 1200000);
		arr[1] = new Phone("갤럭시", 1300000);
		arr[2] = new Phone("플립폰", 2000000);
		
		// FileOutputStream
		// + 
		// ObjectOutputStream
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			// arr 배열의 모든 인덱스에 들어있는 휴대폰 객체를
			// phoneList.txt 파일로 한줄한줄 내보내기
			/*
			oos.writeObject(arr[0]);
			oos.writeObject(arr[1]);
			oos.writeObject(arr[2]);
			*/
			for(int i = 0; i <arr.length; i++) {
				oos.writeObject(arr[i]);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
	
	// 프로그램 (기준점) <---- 외부매체 (파일)
	// 입력
	
	public void fileRead() {
		
		// FileInputStream
		// + 
		// ObjectInputStream
		
		// 0. 스트림 변수 선언 및 null 로 초기화
		ObjectInputStream ois = null;
		
		
		try {
			// 1. 통로 열기 (스트림 객체 생성)
			ois = new ObjectInputStream(new FileInputStream("phoneList.txt"));
			// 2. 볼일 보기
			
			
			//System.out.println(ois.readObject()/*.toString*/);
			//System.out.println(ois.readObject()/*.toString*/);
			//System.out.println(ois.readObject()/*.toString*/);
			// > 해당 파일에 Phone 객체의 정보가 몇개 기록되어있을지 알 수 없다!!
			//  (for문 사용 불가!!)
			// System.out.println(ois.readObject()/*.toString*/);
			// > 더이상 읽어들일 데이터가 없을 경우
			//   EOFException 발생 : End Of File 의 약자
			//   (IOException 의 자식클래스임)
			while(true) {
				System.out.println(ois.readObject());
					
				}
			
			
			// 3. 통로 닫기 (finally)
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(EOFException e) {
			System.out.println("파일을 다 읽었습니다.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("프로그램 종료");
		
	}
}
