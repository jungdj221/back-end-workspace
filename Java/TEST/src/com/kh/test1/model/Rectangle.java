package com.kh.test1.model;

public class Rectangle {
	private int widith;
	private int height; // public -> private
	
	public Rectangle() {
	}
	public Rectangle(int widith, int height) { // -> 생성자 생성에 있어서 protected -> public
		this.widith = widith;
		this.height = height;
	}
	
	public int getWidith() {
		return widith;
	}
	public void setWidith(int widith) {
		this.widith = widith;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) { // gatter setter에서 getter은 return값을 setter은 받는 값을 명시
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle [widith=" + widith + ", height=" + height + "]";
	}
	
	
}

	
