package com.kh.chap04_assist.part02_object.run;

import com.kh.chap04_assist.part02_object.model.dao.ObjectDao;

public class ObjectRun {
		/*
		 * * ObjectXXX
		 * ��ü ������ ������� �� �ְ� �����ִ� ���� ��Ʈ��
		 * ObjectInputStream / ObjectOutputStream (1byte)
		 * 
		 *  
		 * > 2byte ¥�� ������Ʈ���� �������� ����!!
		 * 
		 */
	
	
	public static void main(String[] args) {
		
		
		ObjectDao od = new ObjectDao();
		//od.fileSave();
		od.fileRead();
	}

}
