package com.kh.condition;

import java.util.Scanner;

public class A_If {
	Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if(조건식){ 조건식이 참(true)일 때 실행 }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자 주로 사용
	 */
	public void method1() {

		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		System.out.print("성적을 입력하시오 : ");
		int score = Integer.parseInt(sc.nextLine());
		if (score >= 60) { // 중괄호없이도 작동은 되나, 중괄호가 있어야 중괄호내의 결과값이 일관 도출됨.
							// if문 내의 print가 한줄에 들어가는 경우는 사용해도 상관없음. 두줄이상이면 두번째 print는 if문 바깥의 문이 됨.
			System.out.println("합격입니다");
		} else {
			System.out.println("재시험 수고요");
		}

		/*
		 * if-else문 if(조건식){ 조건식이 참일때 실행 } else{ 조건식이 거짓일때 실행 }
		 */
	}

	public void method2() {
		System.out.print("성적을 입력하시오 : ");
		int score = Integer.parseInt(sc.nextLine());
		if (score >= 60) { // 중괄호없이도 작동은 되나, 중괄호가 있어야 중괄호내의 결과값이 일관 도출됨.
							// if문 내의 print가 한줄에 들어가는 경우는 사용해도 상관없음. 두줄이상이면 두번째 print는 if문 바깥의 문이 됨.
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격");
		}

		// 삼항연산자
		String result = score >= 60 ? "합격입니다." : "불합격";
		System.out.println(result);
		System.out.println(score >= 60 ? "합격입니다." : "불합격");
	}

	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		System.out.print("이름을 입력하시오 : ");
		String name = sc.nextLine();
		// System.out.println("name의 주소값 : " + System.identityHashCode(name));
		// System.out.println("name의 주소값 : " + System.identityHashCode("정동준"));
		// System.out.println(name.equals("정동준")); // true

		if (name.equals("정동준")) { // false
			// String -> 참조형 변수 (클래스 변수)는 주소값을 저장
			System.out.println("본인입니다.");
		} else {
			System.out.println("본인이 아닙니다.");
		}
	}

	public void method4() {

		// 입력받은 숫자가 0보다 크면 양수 "양수", 0이면 "0이다", 작으면 "음수"출력
		System.out.print("숫자를 입력하세요 : ");
		int number = Integer.parseInt(sc.nextLine());

		// 삼항연산자
		String result = number > 0 ? "양수입니다." : number == 0 ? "0입니다." : "음수입니다.";
		System.out.println(result);

		// else if
		if (number > 0) {
			System.out.println("양수입니다.");
		} else if (number == 0) { // if문은 중첩 가능
			System.out.println("0입니다.");
		} else {
			System.out.println("음수입니다.");
		}

	}

	/*
	 * if-else if-else문 if(조건식1) { 조건식1이 참일때 결과1 } else if(조건식2){ 조건식1이 거짓이며, 조건식2가
	 * 참일때 결과2 } else{ } 조건식1, 조건식2 모두 false일때만 결과3
	 */
	public void method5() {
		// 입력받은 숫자가 0보다 크면 양수 "양수", 0이면 "0이다", 작으면 "음수"출력
		System.out.print("숫자를 입력하세요 : ");
		int number = Integer.parseInt(sc.nextLine());

		// 삼항연산자
		String result = number > 0 ? "양수입니다." : number == 0 ? "0입니다." : "음수입니다.";
		System.out.println(result);

		// else if
		if (number > 0) {
			System.out.println("양수입니다.");
		} else if (number == 0) { // if문은 중첩 가능
			System.out.println("0입니다.");
		} else {
			System.out.println("음수입니다.");
		}
	}
	/*
	 * 사용자에게 점수(0~100)를 입력받아 점수별로 등급 출력
	 * -90점이상 A등급
	 * -90점미만 80점이상 B등급
	 * -80점미만 70점이상 C등급
	 * -70점미만 60점이상 D등급
	 * -60점미만 F 등급
	 * */
	public void practice1() {
		System.out.print("점수를 입력해주세요 : ");
		int score = Integer.parseInt(sc.nextLine());
		
		String grade = "";
		if(score >= 90) {
			grade = "A등급";
		} else if (score >= 80) {
			grade = "B등급";
		} else if (score >= 70) {
			grade = "C등급";
		} else if (score >= 60) {
			grade = "D등급";
		} else {
			grade = "F등급";
		}
		System.out.println(grade);
		
//		if (score >= 90) {
//			System.out.println("A등급");
//		} else if(score >= 80) {
//			System.out.println("B등급");
//		} else if(score >= 70) {
//			System.out.println("C등급");
//		} else if (score >= 60) {
//			System.out.println("D등급");
//		} else {
//			System.out.println("F등급");
//		}
	}
	
	/*
	 * 세 정수를 입력받았을 때 짝수만 출력
	 * num1 > 3, num2 > 4, num3 > 6
	 * 4
	 * 6 출력
	 * */
	public void practice2() {
		System.out.print("첫번째 정수 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 정수 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째 정수 : ");
		int num3 = Integer.parseInt(sc.nextLine());
		
		// if문 하나 가지고
		if(num1 % 2 == 0) {
			System.out.println(num1);
			
			if(num2 % 2 ==0) {
				System.out.println(num2);
				if(num3 % 2 ==0) {
					
				}
			}else {
				
			}
		}else {
			if(num2 % 2 ==0) {
				System.out.println(num2);
			}else {
			if(num3 % 2 == 0) {
				System.out.println(num3);
			}
		}}
		
		// if ~ else if 사용 중첩구문은 없으나 비추
		if(num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
		} else if(num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 != 0) {
			System.out.println(num1);
			System.out.println(num2);
		} else if(num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 == 0) {
			System.out.println(num1);
			System.out.println(num3);
		} else if(num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 != 0) {
			System.out.println(num1);
		} else if(num1 % 2 != 0 && num2 % 2 == 0 && num3 % 2 == 0) {
			System.out.println(num2);
			System.out.println(num3);
		} else if(num1 % 2 != 0 && num2 % 2 == 0 && num3 % 2 != 0) {
			System.out.println(num2);
		} else if(num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 == 0) {
			System.out.println(num3);
		} else {
			System.out.println("입력하신 값중에 짝수가 없습니다.");
		}
		
		// 깔끔
		if(num1 % 2 == 0) System.out.println(num1);
		if(num2 % 2 == 0) System.out.println(num2);
		if(num3 % 2 == 0) System.out.println(num3);
		
	}
	
	/*
	 * 점수 한개를 입력했을때 음(minus)양(plus)영(zero), 짝(even)홀(odd) 까지 출력
	 * */
	public void practice3() {
		System.out.print("정수 하나를 입력하시오 : ");
		int number = Integer.parseInt(sc.nextLine());
		
		if(number > 0) {
			if(number % 2 == 0) {
				System.out.println(number + " is even number");
			} else if (number % 2 != 0) {
				System.out.println(number + " is odd number");
			}
				
		} else if(number == 0) {
			System.out.println(number + " is zero");
		} else {
			if(number % 2 == 0) {
				System.out.println(number + " is even number");
			} else if (number % 2 != 0) {
				System.out.println(number + " is odd number");
		}}
		
		System.out.println("Input Integer here : ");
		int num = Integer.parseInt(sc.nextLine());
		String result = "";
		String result2 = "";
		if(num > 0) {
			result = "positive";
		} else if(number < 0) {
			result = "negative";
		} else {
			result = "zero";
		}
		if(number == 0) {
			result2 ="";
		} else if(num % 2 == 0) {
			result2 = "even";
		} else {
			result2 = "odd";
		}
		System.out.println("The number is " + result + " and it is " + result2 + " nubmer");
	}
	
	public static void main(String[] args) {
		A_If a = new A_If();
		// a.method1();
		// a.method2();
		// a.method3();
		// a.method4();
		//a.method5();
		//a.practice1();
		//a.practice2();
		a.practice3();
	}

}
