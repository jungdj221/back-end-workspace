package com.kh.loop;

import java.util.Scanner;

public class C_For {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * for문
	 * 
	 * for(초기식;조건식;증감식){
	 * 
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복실행하는 구문
	 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값을 대입
	 * - 조건식 : 결과가 true이면 실행코드를 실행, false이면 실행하지 않고 반복문을 빠져나간다
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	 * */

	// 1 ~ 5 출력, 5 ~ 1 출력

	public void method1() {
		for(int i = 1; i <=5; i++) {
			System.out.println(i);
		}
		for(int i = 5; i > 0; i--) {
			System.out.println(i);
		}
	}
	
	public void method2() {
		//1~10 사이의 홀수만 출력
		for(int i = 1; i <=10; i++) {
			if(i % 2 != 0) {
				System.out.println(i);
			}
		}
		for(int i =1; i <= 10; i += 2) {
				System.out.println(i);
		}
	}
	
	public void method3() {
		// 1 ~ 10 사이의 짝수만 출력
		for(int i = 1; i <=10; i ++) {
			if(i % 2 ==0) {
				System.out.println(i);
				}
			}
		
		for(int i = 1; i <=10; i++) {
			if(i % 2 != 0) continue;
			System.out.println(i);
		}
	}
	/*
	 * continue문
	 * - continue문은 반복문 안에서 사용
	 * - 반복문 안에서 continue를 만나면 "현재 구문" 종료
	 * - 반복문을 빠져나가는 건 아님 다음 반복을 계속 수행
	 * */
	
	public void method4() {
		// 1~10의 합계
		int sum = 0;
		for(int i = 1; i <= 10; i ++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 1부터 사용자가 입력한 수까지의 합계
		System.out.print("마지막수를 입력하세요 : ");
		int num = sc.nextInt();
		int sum2 = 0;
		for(int i =1; i <= num; i++) {
			sum2 += i;
		}
		System.out.println(sum2);
	}
	
	
	public void method5() {
		//1부터 랜덤값까지의 합계
		
		/*
		 * java.lang.Math 클래스에서 제공하는 random() method
		 * 호출할때마다 매번 다른 랜덤값을 얻어낼 수 있음
		 * */
		double random = Math.random(); // 0.0 <= random < 1.0
		random = Math.random() * 10; // 0.0 <= random < 10.0
		random = Math.random() * 10 +1; // 1.0 <= random < 11.0
		System.out.println((int)random); // 1 ~ 10까지의 랜덤값
		
		int num = (int) random;
		int sum = 0;
		for(int i =1; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	public void method6() {
		// 사용자에게 입력받은 문자열을 세로로 출력
		System.out.print("입력하세요 : ");
		String str = sc.nextLine();
		
//		for(int i = 0; i <= str.length()-1; i ++){
//			System.out.println(str.charAt(i));
//		}
		/*
		 * 향상된 for문
		 * for(데이터타입 변수 : 배열){
		 * 		변수 : 배열의 값을 하나씩 가지고 옴
		 * }
		 * */
		
		/*
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬것이 문자열
		 * 
		 * - String.charAt(int index) : 인덱스에 있는 문자를 char 형식으로 변환
		 * - String.toCharArray() : 모든 문자가 들어있는 char[] 형식의 데이터를 반환
		 * */
		char[] arr = str.toCharArray();
		System.out.println(arr);
		for(char ch : str.toCharArray()) {
			System.out.println(ch);
		}
	}
	
	public void method7() {
		for(int i = 1; i <= 9; i ++) {
			System.out.println("2 X " + i + "= " + (2*i));
		}
	}
	
	//중첩 for문
	//2 ~ 9단 출력
	public void method8() {
		for(int i =1; i <= 9; i ++) {
			for(int j = 2; j <= 9; j++) {
				System.out.println(j + " X " + i + "= " + (j*i));
			}
		}
	}
	
	public void method9() {
		/*
		 *  *****
		 *  *****
		 *  *****
		 *  *****
		 * */
		for(int i = 1; i <= 5; i ++) {
			for(int j = 1; j <=5; j++) {		
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
	
	public void method10() {
		/*
		 * 1***
		 * *2**
		 * **3*
		 * ***4
		 * */
		for(int i = 1; i <= 4; i ++) {

			for(int j = 1; j <=4; j++) {
				if(i == j) System.out.print(i);
				else System.out.print("*");
			}

			System.out.println(" ");
		}
	}
	
	public void method11() {
		/*
		 *  *
		 *  **
		 *  ***
		 *  ****
		 *  *****
		 * */
		for(int i = 1; i <= 5; i ++) {
			for(int j = 1; j <=5; j++) {
				if(i >= j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println(" ");
		}
		
	}
	
	public void mothod12() {
		/*     * i=1 j=4
		 *    ** i=2 j=3
		 *   *** i=3 j=2
		 *  **** i=4 j=1
		 * *****
		 * */
		for(int i = 1; i <= 5; i ++) {
			for(int j = 5; j >=1; j--) {
				if(i >= j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		C_For c = new C_For();
		//c.method1();
		//c.method2();
		//c.method3();
		//c.method4();
		//c.method5();
		//c.method6();
		//c.method6();
		//c.method7();
		//c.method8();
		//c.method9();
		//c.method10();
		//c.method11();
		c.mothod12();
		//c.method13();
	}

}
