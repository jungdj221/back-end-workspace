// 클래스이름 : com.kh.practice.VariablePractice
//FQCN(Fully Qualified Class Name)
package com.kh.practice;
import java.util.Scanner;
public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();
		v.method3();
				
	}
	

	public void method1() {
		System.out.println("-1번----------------------------");
		int AdultPrice = 10000;
		int TeenPrice = 7000;
		int adultCount = 2;
		int teenCount =3;
		
		int adultTotal = AdultPrice*adultCount;
		int teenTotal =  TeenPrice*teenCount;
		System.out.printf("성인 %d명 : %d원\n", teenCount, teenCount*AdultPrice);
		System.out.printf("성인 %d명 : %d원\n\n", teenCount, teenCount*TeenPrice);
		System.out.printf("총 금액 : %d원\n",adultTotal + teenTotal );
		//System.out.println("성인 2명 : " + adultTotal + "원");
		//System.out.println("성인 3명 : " + teenTotal + "원");
		//System.out.println("총 금액 : " + (AdultPrice*2 + TeenPrice*3) + "원");
		System.out.println("-------------------------------");
	}
	
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		int temp = x;
		//final int xOrignal = 5;
		//final int yOriginal = 7;
		//final int zOriginal = 9;
		x = y;
		y = z;
		z = temp; // 맨 처음 x는 y값(7)로 치환됐으므로
		System.out.println("-2번----------------------------");
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
		System.out.println("-------------------------------");
	}
	public void method3() {
		System.out.println("-3번----------------------------");
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		System.out.println("첫번째 문자 : " + word.charAt(0));
		System.out.println("마지막 문자 : " + word.charAt(word.length()-1));
		System.out.println("-------------------------------");
	}
}
