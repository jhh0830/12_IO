package com.kh.chap04_assist.part01_buffered.run;

import com.kh.chap04_assist.part01_buffered.model.dao.BufferedDao;

public class BufferedRun {

	
	/*
	 * * ���� ��Ʈ��
	 * ��� ��Ʈ�� (�ܺθ�ü�� ���� ����Ǿ��ִ� ���) �� ������ �����
	 * Ȯ���ų �� �ִ� ��Ʈ��(��, ���� ��� ����)
	 * ���� ��Ʈ���� �ܵ� ��� �Ұ�!!
	 * ��, �ܵ����� ��ü ������ �Ұ���!!
	 * 
	 * 
	 * [ ǥ���� ]
	 * ������Ʈ��Ŭ������ ��ü�� = new ������Ʈ��Ŭ������(��ݽ�Ʈ����ü��);
	 * 
	 * * ������ ��
	 * 1. ������Ʈ�� �� ��ݽ�Ʈ���� "����" �� ��ġ�ؾ� �Ѵ�.
	 * > �Է��̸� �Է�, ����̸� ��³��� �� ���� ������!!
	 * 2. ������Ʈ���� ��ݽ�Ʈ���� "����� ������"�� ��ġ�ؾ��Ѵ�.
	 * > ����Ʈ�� ����Ʈ, ���ڸ� ���ڳ��� �� ���� ������!!
	 * 
	 * *BufferedXXX
	 * ����� �ӵ� ���� ��� ������ ���� ��Ʈ��
	 * BufferedReader / BufferedWriter (2byte)
	 * BufferedInputStream / BufferedOutputStream (1byte)
	 * > ���� ������ �����ؼ� ������� �����͸� �ѹ��� ��Ɗx�ٰ�
	 * 	 �Ѳ����� ������� �����ؼ� �ӵ��� ������ �������ִ� ����
	 * 
	 */
	public static void main(String[] args) {

		BufferedDao bd = new BufferedDao();
		//bd.fileSave();
		bd.fileRead();
	
	}

}
