package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Book;

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
	
	public String printBookAll() throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM tb_book";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> bookList = new ArrayList<>();
		
		while(rs.next()) {
			int bookNumber = rs.getInt("bookNumber");
			String bookTitle = rs.getString("bookTitle");
			String bookAuthor = rs.getString("bookAuthor");
			int bookPrice = rs.getInt("bookPrice");
			int bookPublicNo= rs.getInt("bookPublicNo");
			
			
		}
		
	}
	
	public void registerBook() {
		
	}
	
}
