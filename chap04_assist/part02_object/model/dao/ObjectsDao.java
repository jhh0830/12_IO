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
	
	// ���α׷� (������) --> �ܺθ�ü (����)
	public void fileSave(String fileName) {
		
		// �޴������� ������ ��ü�迭�� ��Ÿ����
		Phone[] arr= new Phone[3];
		
		arr[0] = new Phone("������", 1200000);
		arr[1] = new Phone("������", 1300000);
		arr[2] = new Phone("�ø���", 2000000);
		
		// FileOutputStream
		// + 
		// ObjectOutputStream
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			// arr �迭�� ��� �ε����� ����ִ� �޴��� ��ü��
			// phoneList.txt ���Ϸ� �������� ��������
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
		System.out.println("���α׷� ����");
	}
	
	// ���α׷� (������) <---- �ܺθ�ü (����)
	// �Է�
	
	public void fileRead() {
		
		// FileInputStream
		// + 
		// ObjectInputStream
		
		// 0. ��Ʈ�� ���� ���� �� null �� �ʱ�ȭ
		ObjectInputStream ois = null;
		
		
		try {
			// 1. ��� ���� (��Ʈ�� ��ü ����)
			ois = new ObjectInputStream(new FileInputStream("phoneList.txt"));
			// 2. ���� ����
			
			
			//System.out.println(ois.readObject()/*.toString*/);
			//System.out.println(ois.readObject()/*.toString*/);
			//System.out.println(ois.readObject()/*.toString*/);
			// > �ش� ���Ͽ� Phone ��ü�� ������ � ��ϵǾ������� �� �� ����!!
			//  (for�� ��� �Ұ�!!)
			// System.out.println(ois.readObject()/*.toString*/);
			// > ���̻� �о���� �����Ͱ� ���� ���
			//   EOFException �߻� : End Of File �� ����
			//   (IOException �� �ڽ�Ŭ������)
			while(true) {
				System.out.println(ois.readObject());
					
				}
			
			
			// 3. ��� �ݱ� (finally)
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(EOFException e) {
			System.out.println("������ �� �о����ϴ�.");
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
		
		System.out.println("���α׷� ����");
		
	}
}
