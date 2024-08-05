package com.kh.chap03_char.run;

import com.kh.chap03_char.model.dao.FileCharDao;

public class CharRun {
	/*
	 * * "문자" "기반" 스트림
	 * 문자 스트림 : 2byte 단위로 입출력 할 수 있는 "넓은 통로"
	 * 			  (XXXReader / XXXWriter)
	 * 기반 스트림 : 외부 매체와 "직접적" 으로 연결되는 "메인 통로"
	 * 
	 * 
	 * > 문자 기반 스트림 : 외부매체를 지정하고 그 외부매체와 직접적으로 연결되는
	 * 					2byte 단위의 통로를 만들겠다.
	 * 
	 * 
	 * XXXReader : XXX 외부 매체로부터 데이터를 입력받는 통로
	 * XXXWriter : XXX 외부 매체로 데이터를 내보내는 통로
	 * 
	 */


	public static void main(String[] args) {
		FileCharDao fc = new FileCharDao();
		
		//fc.fileSave();
		fc.fileRead();
	}
}
