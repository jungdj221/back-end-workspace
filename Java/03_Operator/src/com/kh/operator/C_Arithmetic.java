package com.kh.operator;

public class C_Arithmetic {

	/*
	 * 산술연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지
	 * */
	
	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
		//c.method1();
		c.method2();
	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(" + : " + (num1 + num2)); // 13
		System.out.println(" - : " + (num1 - num2)); // 7
		System.out.println(" * : " + (num1 * num2)); // 30
		System.out.println(" / : " + (num1 / num2)); // 7
		System.out.println(" % : " + (num1 % num2)); // 1
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b; // (a=6) + (b=10) = (c=16)
		int d = c / a; // (c=16)/(a=6) = d=2
		int e = c % a; // (c=16) % (a=6) = (e= 4)
		int f = e++; // (e=f=4)// 여기이후로 e=5
		int g = (--b) + (d--); // (b=9) + (d=2) = (g=11) // 여기이후로 d=1
		int h = 2; // h=2
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); // ((a=6) + (b=9)) / ((c=15) / (f=4))* ((g=11) - (d=1)) % ((e=6) + (h=2))
															   //= 6 + 9 / (15 / 4) * (11 - 1) % (6 + 2)= 12
		System.out.println(i); // 12
	}

}
