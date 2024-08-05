package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO (Data Access Object) Ŭ����
// �����Ͱ� �����Ǿ��ִ� "�ܺ� ��ü" �� ���� ���� (����) �ؼ�
// �����͸� ������ϴ� �뵵�� Ŭ����
public class FileByteDao {
	
	/*
	 * * ����� ����(3 step)
	 * 1. ��� ����
	 * 2. ���� ���� (�Է��̵� ����̵� ����)
	 * 3. ��� �ݱ�
	 * 
	 */
	
	// ���α׷� (������) ---> �ܺθ�ü (����)
	// ��� : ���α׷� ���� �����͸� ���Ϸ� �������� (��, ���Ϸ� ����ϰڴ�)
	public void fileSave() {
		// FileOutputStream
		// "����" �� �����͸� 1byte ������ ������ִ�  ��Ʈ��
		
		// 0. FileOutputStream ���� ���� �� null �� �ʱ�ȭ 
		// > finally ������ �������� �̽��� �ذ��ϱ� ����
		FileOutputStream fout = null;
		
		try {
			// 1. ��� ����
			// > ��θ� ���ڴ� == ��Ʈ�� ��ü�� �����ϰڴ�.
			fout = new FileOutputStream("a_byte.txt");
			// > ��ü ���� �� �����ϰ��� �ϴ� ���ϸ��� ������
			//   �ش� ������ �������� ������
			//   �ش� ������ �����ǰ� �� ���Ŀ� ��ΰ� �����
			//   �ش� ������ �����Ѵٸ� �׳� ��ΰ� �����
			//  (���ϸ� ���� �� ���� ���� �۾����� ������Ʈ ���� ���� ����)
			//fout = new FileOutputStream("a_byte.txt", true);
			// > �Ű������� true ���ۼ� �� : ������ �ش� ������ ���� ���
			//                          ������ "�������"
			// 							(false�� ��������)
			// > �Ű������� true �ۼ� �� : ������ �ش� ������ ���� ���
			// 							������ "�̾� ������"
			
			// 2. ���� ����
			// > 1byte ������ "��������" �۾� 
			//   write() �޼ҵ� ���
			// 1byte : -128 ~ 127 ������ ����
			// ��, ���Ͽ� ��ϵǱ⸦ 0~ 127 ������ ��ϵ� (�ƽ�Ű �ڵ�ǥ�� ����)
			fout.write('a'); // a ���
			fout.write(98); // b ���
			// > ���Ͽ� ��ϵǱ⸦ �ƽ�Ű �ڵ�ǥ�� ���� ���ڷ� ��ϵ�!!
			
			//fout.write('��');
			// > �ѱ��� 2byte �̱� ������ ������ ����
			//   (����Ʈ ��Ʈ�����δ� ��������)
			byte[] bArr = {99, 100, 101};
			fout.write(bArr); // cde ���
			// > ���� �ε�
			
			fout.write(bArr, 1,2);
			// > ���� �ε�
			
			// 3. ��� �ݱ� (�ݵ�� - finally ������ �ۼ�)
			// > ��� �ݱ� == �� �� �ڿ� �ݳ��ϱ�
			// close() �޼ҵ� ���
			// fout.close():
			// > ������ Ȥ�� ���ܰ� �߻��� ���
			// 	 �ٷ� catch ������ �帧�� �����鼭 ������ �ȵ�
			
			
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			// > IOException �� FileNotFoundException�� �θ�
			e.printStackTrace();
		} finally {
			// ���ܰ� �߻��ϵ�, �߻����� �ʵ� ����
			// ���������� �ݵ�� ������ ������ �ִٸ� finally ������ �ۼ�
			try {
			// 3. ��δݱ�
			fout.close();
		}catch(IOException e) {
			e.printStackTrace();
			
			
		}
		}
		
		System.out.println("���α׷� ����");
	
		
	}
	
	// ���α׷� (������) <--- �ܺθ�ü (����)
	// �Է� : ���Ϸκ��� �����͸� ������ ���ڴ�. �о���̰ڴ�.
	public void fileRead() {
		
		// FileInputStream
		// : "����" �κ��� �����͸� 1byte ������ �Է¹޴� ��Ʈ��
		
		// 0. FileInputStream ���� ���� �� null �� �ʱ�ȭ
		FileInputStream fin = null;
		
		try {
		// 1. ��� ����
		// > ��θ� ���ڴ� == ��Ʈ�� ��ü�� �����ϰڴ�.
		fin = new FileInputStream("a_byte.txt");
		// > FileInputStram ��ü ���� ��
		// 	 ������ �������� �ʴ� ���ϸ��� ���� ������
		//   FileNotFoundException �� ���!!
		
		
		
		// 2. ���� ����
		// > �ش� ���Ϸκ��� �����͸� 1byte ������ �о���̴� �۾�
		//   read() �޼ҵ� �̿�
		// > ���ڷν� ��ϵǾ��־ �о���� ���� �ƽ�Ű �ڵ�ǥ�� ����
		// 	 ���ڷ� �о����!!
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
		// --- ���̻� �о���� �����Ͱ� ���� ---
		System.out.println(fin.read()); // -1
		// ������ ���� ������ ���� -1 ����
		*/
		/*
		while(fin.read() != -1) {
			System.out.println(fin.read());
		}
		*/
		// > �������� ��µ�
		//   �ݺ� 1ȸ�� �� read �޼ҵ尡 �˻�� 1��, ��¿� 1��
		//   �� 2���� ȣ��Ǳ� ����
		
		// �ذ���1)
		// ���ѹݺ��� �̿��ؼ� �Ź� ���ǰ˻� �ϱ�
		/*
		while(true) {
			int value = fin.read();
			
			if(value == -1) {
				break;
			}
			
			System.out.println(value);
		}
		*/
		
		// �ذ���2) ���ǽ� ���ο� "����" ������ Ȱ���ϱ�
		int value = 0;
		while((value = fin.read()) != -1) {
			System.out.println((char)value);
			
		}

		 
		
		
		// 3. ��� �ݱ�(�ݵ�� - finally ������ �۾�)
		// > ��� �ݱ� == �� �� �ڿ��� �ݳ��ϱ�
		
		
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
			// 3. �� �� ��Ʈ�� �ڿ� �ݳ�
			fin.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("���α׷� ����");
		
	}
}
