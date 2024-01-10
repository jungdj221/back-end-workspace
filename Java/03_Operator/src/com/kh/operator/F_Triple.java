package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 식 1 : 식 2;
	 * 
	 *  - 조건식에는 주로 비교, 논리 연산자가 사용
	 *  - 조건식의 결과가 true이면 식1을 수행
	 *  - 조건식의 결과가 false이면 식2를 수행
	 * */
	
	public static void main(String[] args) {

		F_Triple f = new F_Triple();
		f.method1();
	}
	
	public void method1() {
		//입력받은 정수가 양수인지 음수인지 판단
		// 양수이다. 음수이다
		
		
		System.out.print("정수를 입력하세요 >");
		int number = sc.nextInt();
		
		String result = number >= 1 ? "양수이다" : number <= -1 ? "음수이다" : "0입니다";
		// boolean result = (number >=1) ? System.out.println("양수이다") : (number <= -1) ? System.out.println("음수이다") : System.out.println("0입니다");
		System.out.println(result);
		
		if (number >=1) {
			System.out.println("양수이다");
		} else if(number <=-1){
			System.out.println("음수이다");
		} else {
			System.out.println("입력하신 값이 0입니다");
		}
	}
	
}
