package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// BufferedReader / BufferedWriter
public class BufferedDao {
	
	// ���α׷� (������) ---> �ܺθ�ü (����)
	// ���
	public void fileSave() {
		
		// FileWriter
		// +
		// BufferedWriter
		// try catch��
		/*
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			
			// 1. ��� ����
			// 1_1. ��ݽ�Ʈ�� ��ü ���� ���� (������� ���� �����)
			// 
						
			// 1_2. ������Ʈ�� ��ü ���� (�̹� ������� ��ݽ�Ʈ�� ��ü�� �ѱ�鼭)
			bw = new BufferedWriter(fw = new FileWriter("c_buffer.txt"));
			
			
			
			// 2. ���� ����
			bw.write("�ȳ��ϼ���");
			bw.newLine();// ������ �־��ִ� �޼ҵ�
			bw.write("�ݰ����ϴ�\n");
			bw.write("����������");
			
			
			// 3. ��� �ݱ�(�ݵ�� - finally)
		
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				// 3. ��� �ݱ� == �ڿ� �ݳ��ϱ�
				// > ������ ������ "����" ���� �ݳ��ϱ�!!
				try {
				bw.close();
				//fw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		System.out.println("���α׷� ����");
	*/
		//try ~ with ~ resource���� (JDK 7 �̻���� ���� ����)
		/*
		 * try(��Ʈ����ü��������; ��Ʈ����ü�������� for��ó�� �������� ;�� �Ⱥ��������){
		 *  	���ܰ� �߻��ҹ��� ����;
		 *  
		 *  
		 * }catch(����Ŭ������ ������){
		 * 		���ܰ� �߻����� �� ������ �ڵ�;
		 * 
		 * }
		 * > ��Ʈ�� ��ü�� try(����) ���� �����ϸ�
		 * 	 ��Ʈ�� ��ü ���� �� �ش� try ��� ������ �ȷ�Ǹ�
		 * 	 �˾Ƽ� �ڿ� �ݳ��� �ȴ�!!
		 */
		try(BufferedWriter bw 
				= new BufferedWriter(new FileWriter("c_buffer.txt"))){
		bw.write("�ȳ��ϼ���");
		bw.newLine();
		bw.write("�ݰ����ϴ�\n");
		bw.write("����������");
		
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("���α׷� ����");
	}
	// ���α׷� (������) <-- �ܺθ�ü (����)
	// �Է�
	public void fileRead() {
		// FileReader
		// +
		// BufferedReader
		
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
			/*
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			// > ���̻� �о���� ������ ���ٸ� null�� ��ȯ
			  */
			// 1) �ذ���
			/*
			while(br.readLine() !=null) {
				String value= br.readLine();
				if(value == null) {
					break;
				}
				System.out.println(value);
			}
			*/
			
			//2) �ذ���
			String value = null;
			while((value = br.readLine())!= null) {
				System.out.println(value);
			}
			
			 
		}catch(FileNotFoundException e) {
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("���α׷� ����");
	}
}
