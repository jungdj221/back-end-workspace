package com.kh.loop;

import java.util.Scanner;

public class D_while {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식){
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * */
	//1~5까지 출력 : for - > while

	
	public void method1() {
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		System.out.println();
		
		int i=1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
	}
	
	// 무한루프 & break문
	/*
	 * - switch
	 * - 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다
	 * */
	public void method2() {
//		for(;;) {
//			
//		}
		while(true) {
			System.out.print("숫자입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
		}
	}
	
	/*
	 * do{
	 * 		실행 코드
	 * } while(조건식);
	 * */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while문");
		}
		
		do {
			System.out.println("do-while문");
		} while(number == 0);
	}
	
	public void method4() {
		/*
		 * 숫자 맞히기 게임
		 * 1과100사이의 값을 입력해서 임의로 지정한(Random)값을 맞히면 게임 끝
		 * 게임이 끝나면 몇 번만에 숫자를 맞혔는지 출력
		 * 예(57)
		 * 35
		 * 더 큰수를 입력하세요
		 * 70
		 * 더 작은수를 입력하세요
		 * 57
		 * 3번만에 맞췄습니다.
		 * */
		int random = (int) (Math.random()*100)+1;
		System.out.println(random);
		System.out.print("1과 100 사이의 값 입력 : ");
		int num = sc.nextInt();
		int i=0;
		while(true) {
			i++;
			if(num < random) {
				System.out.println("더 큰수를 입력하세요");
				System.out.print("1과 100 사이의 값 입력 : ");
				 num = sc.nextInt();
			} else if(num > random) {
				System.out.println("더 작은수를 입력하세요");
				System.out.print("1과 100 사이의 값 입력 : ");
				 num = sc.nextInt();
			} else {
				System.out.print(i + "번 만에 맞췄습니다.\n");
				break;
			}
			
		}
		
	}
	
	public void method5() {
//		int deposit = 0;
//		int withdraw = 0;
//		int balance = deposit - withdraw;
		int balance =0;
		boolean check = true;
		while(check) {
			
			
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택 > ");
			int select = sc.nextInt();
//			if(select == 1) {
//				System.out.print("예금액 > ");
//				balance += sc.nextInt();
//			} else if(select == 2) {
//				System.out.print("출금액 > ");
//				balance -= sc.nextInt();
//			} else if(select == 3) {
//				System.out.print("잔고 > " + (balance));
//			} else if(select == 4) {
//				System.out.println("종료합니다.");
//				break;
//			} else {
//				System.out.print("지정된 키번호를 이용하십시오\n");
//			}
			
			//switch
			switch(select) {
			case 1:
				System.out.print("예금액 > ");
				balance += sc.nextInt();
				break;
			case 2:
				System.out.print("출금액 > ");
				int ex = sc.nextInt();
				if(ex > balance) System.out.println("잔고가 부족합니다");
				else balance -=  ex;
				
				break;
			case 3:
				System.out.print("잔고 > " + (balance));
				break;
			case 4:
				System.out.println("종료합니다.");
				check = false;
				break;
			}
			//if(select == 4)break;
		}
		
		
	}
	public static void main(String[] args) {
		D_while d = new D_while();
		//d.method1();
		//d.method2();
		//d.method3();
		//d.method4();
		d.method5();
	}
}






