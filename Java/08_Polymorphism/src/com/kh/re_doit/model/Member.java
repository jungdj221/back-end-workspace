package com.kh.re_doit.model;

import java.util.Arrays;

// model class : 캡슐화 <- 변수:private 정보은닉을 위해서
public class Member {

	private String name = "";
	private int age = 0;
	private int coupon = 0;
	private Book[] bookList = new Book[3]; // 포함관계
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; //this.name 여기있는 name을 받아온 String name으로 바꿀게요
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
	
	
	
	
}
