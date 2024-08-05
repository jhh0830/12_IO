package com.kh.chap04_assist.part02_object.model.vo;

import java.io.Serializable;
					// ����ȭ ���� : ��� �þ�߸��ڴ�.
public class Phone implements Serializable{

	
	// �ʵ�
	private String name;
	private int price;
	
	// ������
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
