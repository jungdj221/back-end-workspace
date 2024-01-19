package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Rectangle;

public class RectangleController {

	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r + "넓이 : "+width*height;
	}
	
	public String calcCircum(int x, int y,int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r + "둘레 : "+ 2*(width+height);
	}
}
