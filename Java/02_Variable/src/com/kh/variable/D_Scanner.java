package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {

	/*
	 * Scanner
	 * - 화면(Console)으로 부터 데이터를 "입력" 받는 클래스
	 * 
	 * 1. import java.util.Scanner; 추가
     *
	 * 2. Scanner 객체 생성
	 *    Scanner sc = new Scanner(System.in);
	 *    
	 * 3. Scanner 메서드 사용
	 * 	입력값이 
	 * 		- 문자열일때 : sc.next() - 공백이 있을 경우 공백 이전까지
	 * 					sc.nextLine(); - 공백 포함 엔터 전까지 -> 얘만 사용하는것을 권장
	 * 		- 정수일때 : sc.nextInt(); - 
	 * 		- 실수일때	 : sc.nextFloat();, sc.nextDouble();
	 **/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름은 무엇입니까? > ");
		String name = sc.next(); // enter 처리 X
		sc.nextLine(); // enter 처리
		
		System.out.print("당신의 집은 어디십니까? > ");
		String addr = sc.nextLine();
		
		System.out.print("당신의 나이는 몇살입니까? > ");
		int age = sc.nextInt(); // enter 처리 X
		
		System.out.print("당신의 키는 몇입니까? (소수점 첫째 자리까지 입력하세요) > ");
		double height = sc.nextDouble(); // enter 처리 X
		sc.nextLine();
		
		System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
		String input = sc.nextLine();
		char gender = input.charAt(0);
		
//		System.out.println("당신의 이름은 " + name 
//						  	+ "이고 사는곳은 "+ addr 
//						  	+ ", 나이는 " + age 
//						  	+ "살, 키는 "+height+"cm, 성별은" + input + "입니다");
		
		// --> printf로 변경
		System.out.printf("당신의 이름은 %s이고 사는곳은 %s, 나이는 %d살, 키는 %.1fcm, 성별은 %c입니다",name, addr, age, height, gender);
		
	}

}
