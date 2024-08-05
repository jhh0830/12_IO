package com.kh.chap04_assist.part01_buffered.run;

import com.kh.chap04_assist.part01_buffered.model.dao.BufferedDao;

public class BufferedRun {

	
	/*
	 * * 보조 스트림
	 * 기반 스트림 (외부매체와 직접 연결되어있는 통로) 의 부족한 기능을
	 * 확장시킬 수 있는 스트림(즉, 성능 향상 목적)
	 * 보조 스트림은 단독 사용 불가!!
	 * 즉, 단독으로 객체 생성이 불가능!!
	 * 
	 * 
	 * [ 표현법 ]
	 * 보조스트림클래스명 객체명 = new 보조스트림클래스명(기반스트림객체명);
	 * 
	 * * 주의할 점
	 * 1. 보조스트림 과 기반스트림의 "방향" 이 일치해야 한다.
	 * > 입력이면 입력, 출력이면 출력끼리 만 결합 가능함!!
	 * 2. 보조스트림과 기반스트림의 "통로의 사이즈"도 일치해야한다.
	 * > 바이트면 바이트, 문자면 문자끼리 만 결합 가능함!!
	 * 
	 * *BufferedXXX
	 * 입출력 속도 성능 향상 목적의 보조 스트림
	 * BufferedReader / BufferedWriter (2byte)
	 * BufferedInputStream / BufferedOutputStream (1byte)
	 * > 버퍼 공간을 제공해서 입출력할 데이터를 한번에 모아둿다가
	 * 	 한꺼번에 입출력을 진행해서 속도를 빠르게 향상시켜주는 원리
	 * 
	 */
	public static void main(String[] args) {

		BufferedDao bd = new BufferedDao();
		//bd.fileSave();
		bd.fileRead();
	
	}

}
