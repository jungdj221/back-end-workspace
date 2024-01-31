package com.kh.step3;

import java.awt.Toolkit;

public class BeepThread extends Thread{
	
	//작동 스레드
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		// 경고음 5번 울리는 작업
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("삡소리 작동중");
		}
	}
}
