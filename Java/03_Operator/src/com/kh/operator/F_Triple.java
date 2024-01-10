package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 값1 : 값2; 괄호나 그런거 치지 않아도 됨.
	 * 
	 *  - 조건식에는 주로 비교, 논리 연산자가 사용
	 *  - 조건식의 결과가 true이면 식1을 수행
	 *  - 조건식의 결과가 false이면 식2를 수행
	 * */
	
	public static void main(String[] args) {

		F_Triple f = new F_Triple();
		//f.method1();
		//f.practice1();
		//f.practice2();
		f.practice3();
	}
	
	public void method1() {
		//입력받은 정수가 양수인지 음수인지 판단
		// 양수이다. 음수이다
		
		
		System.out.print("정수를 입력하세요 >");
		int number = sc.nextInt();
		
		String result = number >= 1 ? "양수이다" : number <= -1 ? "음수이다" : "0입니다"; // 2차항 연산시 number == ? "0이다" : "음수이다"; 이렇게 해도 됨.
		// boolean result = (number >=1) ? System.out.println("양수이다") : (number <= -1) ? System.out.println("음수이다") : System.out.println("0입니다");
		System.out.println(result);
		
//		if (number >=1) {
//			System.out.println("양수이다");
//		} else if(number <=-1){
//			System.out.println("음수이다");
//		} else {
//			System.out.println("입력하신 값이 0입니다");
//		}
	}
	
	/*
	 * 실습 문제1 
	 * 사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 크거가 같은 경우
	 * "결과가 100 이상입니다." 아닌경우 "결과가 100보다 작습니다."
	 * */
	public void practice1() {
		System.out.print("첫번째 정수를 입력하세요");
		int number1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요");
		int number2 = sc.nextInt();
		String result = (number1 * number2) >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다";
		System.out.println(result);
	}
	
	/*
	 * 실습2
	 * 사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면
	 * "알파벳 대문자이다." 아닌경우 "알파벳 대문자가 아니다." 출력
	 * */
	public void practice2() {
		System.out.print("문자를 한개만 입력하세요 >");
		//char word = '\u0000';
		char word = sc.nextLine().charAt(0); // charAt(0) : 문자 하나만 가져오기
		String result = word>= 'A' && word <= 'Z'? "알파벳 대문자이다.":"알파벳 대문자가 아니다";
		System.out.println(result);
		
	}
	/*
	 * 실습3
	 * 두 정수를 입력받고 + 또는 -를 입력받아서 계산을 출력
	 * 단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다." 출력
	 * 
	 * 예시)
	 *  첫번째 수 >3
	 *  두번째 수 >4
	 *  연산자 입력(+ 또는 -) > +
	 *  3+4=7
	 *  연산자 입력(+ 또는 -) > -
	 *  3-4=-1
	 *  연산자 입력(+ 또는 -) > *
	 *  잘못입력했습니다.
	 *  
	 * */
	public void practice3() {
		System.out.print("첫번째 정수를 입력하세요");
		int numb1 = Integer.parseInt(sc.nextLine());
		//String numb1 = sc.nextLine();
		// String -> int
		//int numb1_2 = Integer.parseInt(numb1);
		
		System.out.print("두번째 정수를 입력하세요");
		int numb2 = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자(+ 또는 -)를 입력하세요");
		char calc = sc.nextLine().charAt(0);
		
		String result = calc == '+' ? String.format("%d + %d = %d", numb1, numb2, (numb1 + numb2))
				      : calc == '-' ?  String.format("%d - %d = %d", numb1, numb2, (numb1 - numb2)): "연산자를 잘못입력하셨습니다";
		//String result = calc == '+' ? numb1 + "+" + numb2 + "=" + (numb1 + numb2) : calc == '-' ?  numb1 + "-" + numb2 + "=" + (numb1 - numb2): "연산자를 잘못입력하셨습니다";
		//String result = calc.equals("+") ? "numb1 + numb2 = " + (numb1 + numb2) : calc.equals("-") ? "numb1 - num2 = " + (numb1 - numb2): "연산자를 잘못입력하셨습니다";
		
	    System.out.println(result);
		
		// 또 다른 방법
	    System.out.printf("%d %c %d = %d", numb1, calc, numb2, calc =='+' ? (numb1 + numb2) : (numb1 - numb2));
	    // =>이거를 if문으로
	    if(calc == '+' || calc == '-') {
	    	System.out.printf("%d %c %d = %d", numb1, calc, numb2, calc =='+' ? (numb1 + numb2) : (numb1 - numb2));
	    } else {
	    	System.out.println("연산자를 잘못입력하셨습니다");
	    }
	    
	}
	
}
