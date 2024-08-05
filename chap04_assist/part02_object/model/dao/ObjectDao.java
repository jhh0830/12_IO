package com.kh.chap04_assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectDao {
	
	// ���α׷� (������) ---> �ܺθ�ü (����)
	// ���
	public void fileSave() {
		
		// FileOutputStream 
		// (byte�� ���̰� ���� ����Ҽ������⶧���� �� ��������Ѵ�)
		// +
		// ObjectOutputStram
		
		// �׽�Ʈ�� ��ü ����
		Phone ph = new Phone("������ 13", 1200000);
		
		
		
		// 0. ��Ʈ�� ���� ���� �� null �� �ʱ�ȭ
		ObjectOutputStream oos = null;
		try {
		// 1. ��� ���� (��Ʈ�� ��ü ����)
			
			
			oos = new ObjectOutputStream(new FileOutputStream("phone.txt"));
		
		
			// 2. ���� ����
			// > ��ü ������ �����͸� ���Ϸ� �������� ��!!
			//   writeObject() �޼ҵ� �̿�
			oos.writeObject(ph); // ��ĳ����
			// > �ش� VO Ŭ���� ����ο� "����ȭ ����" �� �ؾ� ����� ��µ�
			// > ��ü ������ ��ϵǾ��־ ���Ϸδ� ���� ��������
			//   ������ ����� ��ϵ� ��!!
			// 3. ��� �ݱ� (�ڿ� �ݳ�) - �ݵ�� (finally ����)
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
			// 3. �ڿ� �ݳ�
			oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("���α׷� ����");
		}
		// ���α׷� (������) <-- �ܺθ�ü (����)
		// �Է� 
	public void fileRead() {
		
		// FileInputStream
		// + 
		// ObjectInputStream
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phone.txt"))){
			
			//��ü ������ �о���̴� �޼ҵ�
			// > readObject() �޼ҵ� �̿�
			Phone p = (Phone)ois.readObject(); // �ٿ�ĳ����
			
			System.out.println(p /*.toStirng*/);
			
		}catch(FileNotFoundException e) {
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	System.out.println("���α׷� ����");	
	}
		
	}
	
