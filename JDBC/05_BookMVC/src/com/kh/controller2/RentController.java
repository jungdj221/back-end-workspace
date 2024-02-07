package com.kh.controller2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

public class RentController {
	private RentDAO dao = new RentDAO();
	
	public boolean rentBook(int bkNo, int memberNo){ // 사용자정보 + 책 정보
		try {
			if(dao.rentBook(bkNo, memberNo)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Rent> printRentBook(int no) throws SQLException {
		return dao.printRentBook(no);
	}
	
	// 대여 취소
	public boolean deleteRent(int no){
		try {
			if(dao.deleteRent(no)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
