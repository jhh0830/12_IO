package com.kh.chap03_char.run;

import com.kh.chap03_char.model.dao.FileCharDao;

public class CharRun {
	/*
	 * * "����" "���" ��Ʈ��
	 * ���� ��Ʈ�� : 2byte ������ ����� �� �� �ִ� "���� ���"
	 * 			  (XXXReader / XXXWriter)
	 * ��� ��Ʈ�� : �ܺ� ��ü�� "������" ���� ����Ǵ� "���� ���"
	 * 
	 * 
	 * > ���� ��� ��Ʈ�� : �ܺθ�ü�� �����ϰ� �� �ܺθ�ü�� ���������� ����Ǵ�
	 * 					2byte ������ ��θ� ����ڴ�.
	 * 
	 * 
	 * XXXReader : XXX �ܺ� ��ü�κ��� �����͸� �Է¹޴� ���
	 * XXXWriter : XXX �ܺ� ��ü�� �����͸� �������� ���
	 * 
	 */


	public static void main(String[] args) {
		FileCharDao fc = new FileCharDao();
		
		//fc.fileSave();
		fc.fileRead();
	}
}
