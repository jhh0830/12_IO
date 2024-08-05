package com.kh.chap04_assist.part02_object.model.vo;

import java.io.Serializable;
					// 직렬화 선언 : 길게 늘어뜨리겠다.
public class Phone implements Serializable{

	
	// 필드
	private String name;
	private int price;
	
	// 생성자
	public Phone() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Phone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", price=" + price + "]";
	}
	
}
