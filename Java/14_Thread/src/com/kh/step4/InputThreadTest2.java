package com.kh.step4;

import javax.swing.JOptionPane;

public class InputThreadTest2 {

	public static void main(String[] args) {
		
		InputThread input = new InputThread();
		input.start();
		
		CountThread count = new CountThread();
		count.start();	
	}

}

class InputThread extends Thread{
	
	public void run() {
	// 1. 데이터 입력 작업
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
	}
}