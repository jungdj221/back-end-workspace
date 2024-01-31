package com.kh.step3;

public class PrintThread extends Thread{

	public PrintThread(String word) {
		super(word);
	}
	
	//작동 스레드
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String word = Thread.currentThread().getName();
			System.out.println(word);
		}
	}
}
