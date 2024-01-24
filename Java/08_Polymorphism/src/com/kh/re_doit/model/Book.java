package com.kh.re_doit.model;

public class Book {

	private String title;
	private boolean coupon;
	private int accessAge;
	
	// String[] 배열을 Book배열로 바꿔야 booklist와 books를 동일시 할 수 있음
	public Book(String title, boolean coupon) {
		this.title = title;
		this.coupon = coupon;

	}
	
	
	public Book(String title, int accessAge) {
		this.title = title;
		this.accessAge = accessAge;
	}

	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isCoupon() {
		return coupon;
	}


	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}


	public int getAccessAge() {
		return accessAge;
	}


	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}
	
	
	
}

