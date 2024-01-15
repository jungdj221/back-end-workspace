package com.kh.practice;
import java.util.Scanner;
public class CastingPractice {

	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
		c.method1();
		c.method2();
	}
	public void method1() {
		System.out.println("-문제1---------------------");
		System.out.print("문자 하나를 입력하세요");
		char word = sc.nextLine().charAt(0);
		char word2 = (char)(word + 1);
		int result = word;
		System.out.println("-------------------------");
		System.out.println("문자 : " + word);
		System.out.println(word + " unicode : " + result);
		System.out.println(word2 + " unicode : " + (int)word2);
		System.out.println("-------------------------");
	}
	public void method2() {
		System.out.println("-문제2---------------------");
		System.out.print("국어 : ");
		int KrScore = sc.nextInt(); 
		System.out.print("영어 : ");
		int EnScore = sc.nextInt(); 
		System.out.print("수학 : ");
		int MathScore = sc.nextInt(); 
		
		int SumScore = (KrScore +EnScore + MathScore);
		float AvgScore = SumScore / 3;
		System.out.println("총점 : " + SumScore);
		System.out.printf("평균 : %.2f\n" ,(double)SumScore /3 );
		System.out.printf("평균 : %.2f", AvgScore);
	}
}
