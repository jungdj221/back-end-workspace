package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Book;
import com.kh.model.RentBook;

import config.Serverinfo;

public class BookController {

	public BookController() {
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("서버 연결x");
		}
	}
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM tb_book";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> bookList = new ArrayList<>();
		
		while(rs.next()) {
			int bookNumber = rs.getInt("bk_no");
			String bookTitle = rs.getString("bk_title");
			String bookAuthor = rs.getString("bk_author");
			int bookPrice = rs.getInt("bk_price");
			int bookPublicNo= rs.getInt("pub_no");
			
			bookList.add(new Book(bookNumber, bookTitle, bookAuthor, bookPrice, bookPublicNo));
		}
		closeAll(rs, ps, conn);
		return bookList;
	}
	
	// 2. 책 등록
	public int registerBook(String title, String author) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_book(bk_title, bk_author) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(2, author);
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
		
	}
	
	// 3. 책 삭제
	public int sellBook(int no) throws SQLException {
		Connection conn = getConnect();
		String qurey = "DELETE FROM tb_book WHERE bk_no=?";
		PreparedStatement ps = conn.prepareStatement(qurey);
		
		ps.setInt(1, no);
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
	}
	
	// 로그인후 
	// 1. 책 대여
	public ArrayList<RentBook> rentBook(int bookNo) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_book WHERE bk_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		ArrayList<RentBook> myBookList = new ArrayList<>();
		
		if(rs.next()) {
			int bookNumber = rs.getInt("bk_no");
			String bookTitle = rs.getString("bk_title");
			String bookAuthor = rs.getString("bk_author");
			int bookPrice = rs.getInt("bk_price");
			int bookPublicNo= rs.getInt("pub_no");
			
			myBookList.add(new RentBook(bookNumber, bookTitle, bookAuthor, bookPrice, bookPublicNo));
			
			return myBookList;
		} 
		closeAll(rs, ps, conn);
		return null;
		
		
	}
	
	// 2. 내가 대여한 책 조회
	public void printRentBook() throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM ";
		PreparedStatement ps = conn.prepareStatement(query);
	}
	
	
}
