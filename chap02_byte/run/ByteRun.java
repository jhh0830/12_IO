package com.kh.chap02_byte.run;

import com.kh.chap02_byte.model.dao.FileByteDao;

public class ByteRun {

	/*
	 * * "����Ʈ" "���" ��Ʈ��
	 * ����Ʈ ��Ʈ�� : 1byte �����θ� ����� �� �� �ִ� ���� ���
	 * 				(XXXInputStream / XXXOutputStream)
	 * ��� ��Ʈ�� : �ܺ� ��ü�� "������" ���� ����Ǵ� �������
	 * > �ܺθ�ü�� �����ϰ� �� �ܺθ�ü�� ���������� ����Ǵ� 1byte ������ ���
	 * 
	 * 
	 * XXXInputStream : XXX ��� �ܺ� ��ü�κ��� �����͸� "�Է�" �޴� ���
	 * 					(�о���̰ڴ�, �������ڴ�)
	 * XXXOutputStream : XXX ��� �ܺ� ��ü�� �����͸� "���" �ϴ� ���
	 * 					 (���ڴ�. �������ڴ�)
	 */
	public static void main(String[] args) {
		FileByteDao fb= new FileByteDao();
		//fb.fileSave();
		fb.fileRead();
	}

}
