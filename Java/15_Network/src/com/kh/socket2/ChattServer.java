package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트가 보낸 메세지를 받아서
// 다시 클라이언트에게 받은 메시지를 보낸다
/*
 * 서버측 로직
 * 1. ServerSocket 생성 port : 60000
 * 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
 * 3. 소켓으로부터 스트림 리턴
 * */

public class ChattServer {

	public static void main(String[] args) {
		try {
			ServerSocket server2 = new ServerSocket(60000);
			System.out.println("Server2 Ready.");
			
			// 클라이언트 서버 접속시 accept
			Socket s2 = server2.accept(); 
			System.out.println(s2.getInetAddress() + "님이 접속하셨습니다.");
			// Socket하나를 returning
			//System.out.println("Client Socket.. Returning..");
			
			//클라이언트한테 받음
			BufferedReader br = new BufferedReader(new InputStreamReader(s2.getInputStream()));
			//다시 클라이언트에게 받은 메세지를 보낸다
			PrintWriter pw = new PrintWriter(s2.getOutputStream(), true);
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println("[" + s2.getInetAddress() + "]가 보낸 메세지 : " + line);
				pw.println(line);
			}
			
		}catch(Exception e) {
			System.out.println("클라이언트와 연결 끊어짐");
		}
		
	}

}
