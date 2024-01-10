package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

	/*
	 * 논리연산자
	 * - 두개의 논리값을 연산해주는 연산자
	 * - 논리연산한 결과마저 논리값 
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true일 경우만 결과값이 true
	 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중에 하나라도 true일 결우 결과값이 true
	 * */
	
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
		//e.method1();
		//e.method2();
		e.practice();
	}
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값을 입력해주세요 > ");
		int number = sc.nextInt();
		boolean result = number >= 1 && number <= 100;
		
		System.out.printf("%d는 1 부터 100 사이의 값인가요? : %b", number, result);
	}
	
	public void method2() {
		// Short Cut Evaluation
		int number = 10;
		boolean result = false; // boolean의 초기값 기본은 false 
		// --> 변수들 초기화부터 지정하고자 할 때
		
		// && 연산자를 기준으로 앞에서 이미 false 이기 때문에 굳이 뒤쪽의 연산으 수행하지 않는다.
		result = (number < 5) && (++number > 0); // false && true = false
		// result = (++number > 0) && (number < 5);
		
		System.out.println(result); // false
		System.out.println(number); // 10
		
		// 뭐가 되는 앞에거가 false면 뒤에 있는 ++연산자는 미적용
		result = (number < 20) || (++number > 0);
		System.out.println(result); // true
		System.out.println(number); // 10
		
		// 예시 -> 로그인
	}
	
	/*
	 * 실습문제
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * A~Z : 65~90, a~z: 97~120
	 * */
	public void practice() {
	
		char ch = '\u0000';
		boolean result = false;
		
		System.out.print("문자를 입력해주세요 > ");
		ch = sc.nextLine().charAt(0);
		
		result = (ch >= 'A' && ch <='Z') || (ch >='a' && ch <='z');
		System.out.println(result);
	}
}
