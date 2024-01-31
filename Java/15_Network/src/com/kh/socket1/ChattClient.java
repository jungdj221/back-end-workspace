package com.kh.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ChattClient {
	
	public static void main(String[] args) {
		
		try {
			//소캣만 알아도 됨. 클라이언트주소, 포트번호
			InetAddress ip = InetAddress.getLocalHost();
			// 1. 소캣 생성
			Socket s = new Socket(ip.getHostAddress(), 60000);
			System.out.println("Client Socket Creating...");
			
			// 2. 스트림 // client가 쓴거 읽는다 -> 쓴다
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			System.out.println("Client stream Creating..");
			
			
			String line = "";
			while((line = br.readLine())!=null) {
				pw.println(line);
			}
			
		}catch(Exception e) {
			System.out.println("서버와의 연결에 실패했습니다.");
		}
	}
}
