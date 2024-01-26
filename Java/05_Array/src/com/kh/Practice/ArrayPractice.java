package com.kh.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayPractice a = new ArrayPractice();
		//a.method1();
		//a.method2();
		//a.method3();
		//a.method4(); 
		a.method5();
	}
	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 * */
	public void method1() {
		String[] fruit = new String[5];
		// String[] fruit = {"사과", "딸기", "용과", "복숭아", "바나나"};
		
		fruit[0] = "사과";
		fruit[1] = "딸기";
		fruit[2] = "용과";
		fruit[3] = "복숭아";
		fruit[4] = "바나나";
		
		// int random = (int)(Math.random()*5);
		//System.out.println(fruit[random]); 이렇게 해도 됨.
		//System.out.println(fruit[2]);
		
		// ArrayList // 배열 -> ArrayList 변환 Arrays.asList(기존에 생성한 배열 매개명)
		ArrayList<String> fruitList = new ArrayList<>(Arrays.asList(fruit));
		
		//fruitList.add("사과");
		//fruitList.add("딸기");
		//fruitList.add("용과");
		//fruitList.add("복숭아");
		//fruitList.add("바나나");
		
		int random = (int)(Math.random()*5);
		//System.out.println(fruitList.get(random));
		
		System.out.println(fruit[random]);
		
	}
	
	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후
	 * 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5
	 * 배열 0번째 인덱스에 넣을 값 : 4
	 * 배열 1번째 인덱스에 넣을 값 : -4
	 * 배열 2번째 인덱스에 넣을 값 : 3
	 * 배열 3번째 인덱스에 넣을 값 : -3
	 * 배열 4번째 인덱스에 넣을 값 : 2
	 * [4, -4, 3, -3, 2]
	 * 2
	 * */
	public void method2() {
		System.out.print("정수 : ");
		int num1 = sc.nextInt();
		int sum = 0;
		int[] arr = new int[num1];
		for(int i = 0; i < num1; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
		
		//ArrayList
		ArrayList<Integer> array = new ArrayList<>();
		System.out.print("정수 : ");
		int num2 = sc.nextInt();
		int sum2 = 0;
		for(int i = 0; i < num2; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			
			int answer = sc.nextInt();
			array.add(answer);
			sum2 += answer;
			sum2 += array.get(i); // 둘다 됨
		}
		System.out.println(array);
		System.out.println(sum2);
	}
	
	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서
	 * 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을 출력하세요.
	 * 
	 * */
	public void method3() {
		String[] uberMenu = {"순대국밥", "쌀국수", "돈까스", "짜장면", "설렁탕"};
		System.out.print("배달 시킬 메뉴 : ");
		String menu = sc.nextLine();
		//기존 for문
//		for(int i = 0; i<uberMenu.length; i++) {
//			if(menu.equals(uberMenu[i])){
//				System.out.println("배달가능");
//				break;
//			}else if(i == menu.length()-1){
//				System.out.println("배달불가능");
//			};
//		}
		
		//항샹 for문
		for(String food : uberMenu) {
			if(menu.equals(food)){
				System.out.println("배달가능");
				break;
			}else {
				System.out.println("배달불가능");
				break;
			}
		}
		// 향상for문 더 업그레이드 
		boolean check = false;
		for(String food1 : uberMenu) {
			if(menu.equals(food1)) {
				check = true;
			}
		}
		System.out.println(check? "배달 가능" : "배달 불가능");
		
		
//		if(menu.equals(uberMenu[0]) ||menu.equals(uberMenu[1])
//		 ||menu.equals(uberMenu[2])||menu.equals(uberMenu[3])
//		 ||menu.equals(uberMenu[4])) {
//			System.out.println("배달가능");
//		}
//		else System.out.println("배달불가능");
//		
		// ArrayList
		ArrayList<String> Uber = new ArrayList<>(Arrays.asList(uberMenu));
		System.out.print("배달 시킬 메뉴 : ");
		String uberUser = sc.nextLine();
		if(uberUser.equals(Uber)) System.out.println("배달가능");
		else System.out.println("배달불가능");
	}
	
	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요.
	 * 단, 원본 배열은 건드리지 않고! 
	 * 
	 * 주민등록번호 : 123456-1234567
	 * 123456-1******
	 * 
	 * */
	public void method4() {
		System.out.print("주민등록번호를 입력하세요 : ");
		String num = sc.nextLine();
		
		char[] charNum = num.toCharArray();
		String[] strNo = num.split("");
		ArrayList<String> noList = new ArrayList<>(Arrays.asList(strNo));
		
		for(int i=0; i<noList.size(); i++) {
			if(i <=7) {
				//System.out.print(strNo[i]);
				System.out.print(noList.get(i));
			}else {
				System.out.print("*");
			}
		}
		
//		char[] pinNum = new char[num.length()];
//		for(int i = 0; i <num.length(); i++) {
//			if(i<=8) {
//				pinNum[i] = num.charAt(i);
//				} // 여기까지가 주민등록번호 배열이 등록하기
//			}
//		//copy배열
//		char[] copy = new char[pinNum.length];
//			for(int i = 0; i < pinNum.length; i++) {
//				if(i<=7) {
//					copy[i] = pinNum[i];
//				}else {
//					copy[i] = '*';
//				}
//				
//		}
//			System.out.println(copy);
		
	}
	
	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요. 
	 * 
	 * 단어 입력 : programming
	 * gnimmargorp
	 * 
	 * */
	public void method5() {
		System.out.print("단어 입력 : ");
		String word = sc.next();
		String[] wordArr = word.split("");
//		for(int i=word.length()-1; i>=0; i--) {
//			System.out.println(wordArr[i]);
//		}
		
		ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
		Collections.reverse(wordList);
		for(String s : wordList) {
			System.out.print(s);
		}
		
//		char[] reverse = word.toCharArray();
//		for(int i = word.length()-1; i >= 0; i--) {
//			System.out.print(reverse[i]);
//		}
	}

}
