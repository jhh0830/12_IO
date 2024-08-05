package com.kh.chap04_assist.part02_object.run;

import com.kh.chap04_assist.part02_object.model.dao.ObjectDao;

public class ObjectRun {
		/*
		 * * ObjectXXX
		 * 객체 단위로 입출력할 수 있게 도와주는 보조 스트림
		 * ObjectInputStream / ObjectOutputStream (1byte)
		 * 
		 *  
		 * > 2byte 짜리 보조스트림은 존재하지 않음!!
		 * 
		 */
	
	
	public static void main(String[] args) {
		
		
		ObjectDao od = new ObjectDao();
		//od.fileSave();
		od.fileRead();
	}

}
