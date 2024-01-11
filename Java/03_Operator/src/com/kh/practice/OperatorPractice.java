package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
    Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		OperatorPractice o = new OperatorPractice();
		//o.method1();
		//o.method2();
		//o.method3();
		//o.method4();
		o.method5();
		//o.method6();
				
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 키보드로 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원수를 입력하세요 : ");
		int ppl = sc.nextInt();
		System.out.print("연필 개수를 입력하세요 : ");
		int pen = sc.nextInt();
		int result = (pen / ppl);
		int trash = (pen % ppl);
		System.out.println("1인당 받는 연필수 : " + result + "자루, 남은 연필 수 : " + trash + ("자루 남음"));
	}
	
	//키보드로 입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("숫자를 입력하시오 : ");
		int numb = sc.nextInt();
		
		if(numb >= 100) {
			int result = (numb/100)*100;
			System.out.println(result);
		} else {
			System.out.println("도출값 : 0, 입력한 값이 100이하의 수 입니다.");
		}
		
		
	}
	
	//3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("값 1 >");
		int num1 = sc.nextInt();
		System.out.print("값 2 >");
		int num2 = sc.nextInt();
		System.out.print("값 3 >");
		int num3 = sc.nextInt();
		
		boolean result = num1 == num2 && num2 == num3;
		
		//String result = num1 == num2 && num2 == num3 ? "true" : "false";
		System.out.println(result);
		
	}
	
	//키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세요.
	public void method4() {
		System.out.println("정수 하나를 입력하시오 : ");
		 int num = sc.nextInt();
		String result = num == 0 ? "입력하신 값이 0입니다." : num % 2 == 0 ? "짝수입니다." : "홀수입니다.";
		System.out.println(result);
		
	}
	
	//나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method5() {
		System.out.print("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		String result = 1 < age && age <=13 ? "어린이입니다." : /*13 < age &&*/ age <=19 ? "청소년입니다." : "성인입니다.";
		System.out.println(result);
		
	}
	
	//키보드로 사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method6() {
		System.out.print("사과의 개수를 입력하세요 : ");
		int apple = sc.nextInt();
		System.out.println("바구니 하나에 몇개의 사과가 들어갈 수 있나요? : ");
		int pocket = sc.nextInt();
		int PocketNum = apple % pocket == 0 ? apple / pocket : (apple / pocket)+1;
		System.out.println(PocketNum + "개 의 바구니가 필요합니다.");
		
	}
	
}