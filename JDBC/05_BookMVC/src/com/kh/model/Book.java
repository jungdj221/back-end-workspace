package com.kh.model;

public class Book {

	private int bookNumber;
	private String bookTitle;
	private String bookAuthor;
	private int bookPrice;
	private int bookPublicNo;
	public Book() {
	}
	public Book(int bookNumber, String bookTitle, String bookAuthor, int bookPrice, int bookPublicNo) {
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookPublicNo = bookPublicNo;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookPublicNo() {
		return bookPublicNo;
	}
	public void setBookPublicNo(int bookPublicNo) {
		this.bookPublicNo = bookPublicNo;
	}
	@Override
	public String toString() {
		return " 책 번호 : " + bookNumber + " | 책 제목 : " + bookTitle + ", 저자 : " + bookAuthor
				+ ", 가격 : " + bookPrice + ", 출판번호 : " + bookPublicNo;
	}
	
	
	
	
	
	
	
}
