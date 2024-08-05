package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class FileCharDao {
	
	/*
	 * 1. ��� ����
	 * 2. ���� ����
	 * 3. ��� �ݱ�
	 */
	
	// ���α׷� (������) --> �ܺθ�ü(����)
	// ��� : ���Ϸ� �����͸� �������ڴ�. ���ڴ�.
	public void fileSave() {
		FileWriter fw = null;
		try {
		// XXXWriter
		// > "����" �� �����͸� 2byte ������ ����ϴ� ��Ʈ��
		
		// 1. ��� ����
		// > ��θ� ���ڴ� == ��Ʈ�� ��ü�� �����ϰڴ�.
		 fw = new FileWriter("b_char.txt",false);
		
		// > ��� ��δ� �������� �ʴ� ���ϸ� ���� ��,
		//   �ش� ������ ����� ���� ���� ��ΰ� �������
		
		
		
		// 2. ���� ����
		// > 2byte ������ ������ �о���̱�
		//   write() �޼ҵ� �̿�
		fw.write("��! IO ��մ�..��\n");
		// > �ش� ���ڿ��� ���� �ϳ��ϳ��� ���۵Ǵ� ����
		// > �ѱ۵� ���� ������!!
		fw.write('A');
		fw.write(' ');
		fw.write('\n');
		
		char[] cArr  = {'k','i', 'w', 'i'};
		fw.write(cArr);
		// 3. ��� �ݱ�(�ݵ�� -finally���� �ۼ�)
		
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
			//3. ��� �ݱ�
			fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("���α׷� ����");
	}
	// ���α׷� (������) <---- �ܺθ�ü(����)
	// �Է� : ���Ϸκ��� �����͸� �������ڴ�. �о���̰ڴ�.
	public void fileRead() {
	
		
		// 0. FileReader = null��  ����
		FileReader fr = null;
		
		
		try {
			
		// FileReader
		// > "����" �κ��� �����͸� 2byte ������ �Է¹޴� ��Ʈ��
		
		// 1. ��� ����
		// > ��θ� ���ڴ� == ��Ʈ�� ��ü�� �����ϰڴ�
		 fr = new FileReader("b_char.txt");
		// > �ݵ�� �����ϴ� ���ϸ����θ� �����ؾ��Ѵ�!!
		
		// 2. ���� ����
		// > 2byte ������ �о���̴� �۾�
		//   read() �޼ҵ带 �̿�
		/*
		 System.out.println(fr.read());
		System.out.println(fr.read());
		System.out.println(fr.read());
		System.out.println(fr.read());
		*/
		// > ���������� �ݸ� Ȱ���� ������
		// ��, ������ ���� ������ ��� -1�� ����
		 /*
		 while(fr.read() != -1) {
			 System.out.println(fr.read());
		 }
		
		*/
		 // > �������� ���
		 
		 // 1) �ذ���
		/*
		 while(true) {
			 int value = fr.read();
			 
			 if(value == -1) {
				 break;
			 }
			 System.out.println(value);
		 }
		 */
		 // 2) �ذ���
		 int value = 0;
		 while((value=fr.read()) != -1) {
			 System.out.print((char)value);
		 }
		System.out.println();
		// 3. ��� �ݱ� - (�ݵ�� finally ���� �۾�)
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e) {
			
		}finally {
			try {
				
			
			// 3. ��� �ݱ�
			fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("���α׷� ����");
	}
}
