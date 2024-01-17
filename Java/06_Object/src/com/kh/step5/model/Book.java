package com.kh.step5.model;

public class Book {

	/*
	 * 캡술화(Encapsulation)
	 * - 정보은닉 : 외부에서 객체 접근하는데 있어서 정보를 숨기고 객체의 연산을 통해서만  접근이 가능하게 하는 것
	 * - 객제 내 정보손상, 오용을 방지하고, 데이터가 변경되어도 다른 객체에 영향을 주지 않음
	 * - 독립성이 좋고, 하나의 모듈처럼 사용이 가능 
	 * */
	
	private String title; //이제부터 변수는 무조건 private에 넣기
	private int price;
	private double discountRate;
	private String author;
	
	// alt +  shift +  s
	public Book() {} // generate constructor from superclass
	
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	} //generate constructor using field

	// getter(값을 불러올때), setter(값을 담을때)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	@Override  // generate toString()
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author
				+ "]";
	}

	


	
	
	
	
	
	
	
}
