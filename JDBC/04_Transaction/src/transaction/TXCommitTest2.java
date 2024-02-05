package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import config.Serverinfo;

public class TXCommitTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 대윤 -> 대규 : 50만원씩 이체
		 * 이 관련 모든 쿼리를 하나로 묶는다, 트랜잭션 사용
		 * 대윤님의 잔액이 마이너스가 되면 이체 취소
		 * */
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
			
			conn.setAutoCommit(false);
			boolean check = true;
			while(check) {
				System.out.print(" 송금 : ");
				int send = sc.nextInt();
				
				String query1 = "UPDATE bank SET balance = ? WHERE name = ?";
				String query2 = "UPDATE bank SET balance = ? WHERE name = ?";
				String query3 = "SELECT * FROM bank WHERE balance < ? && name = ?";
				
				PreparedStatement ps1 = conn.prepareStatement(query1);
				ps1.setInt(1, 1000000 - send);
				ps1.setString(2, "정대윤");
				ps1.executeUpdate();
				
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setInt(1, 0 + send);
				ps2.setString(2, "신대규");
				ps2.executeUpdate();
				
				PreparedStatement ps3 = conn.prepareStatement(query3);
				ps3.setInt(1, 0);
				ps3.setString(2, "정대윤");
				ResultSet rs = ps3.executeQuery();
				
				if(rs.next()) {
					//if(rs.getInt("balance")<0) 이게 쿼리문에서 balance <0
					conn.rollback();
					System.out.println("돈이 없어요");
					check = false;
				} else {
					conn.commit();
					System.out.println("송금완료");
				}
				//conn.setAutoCommit(true);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
