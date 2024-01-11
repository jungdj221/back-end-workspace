package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문
	 *
	 * switch(조건식) {
	 * 		case 값1 :
	 * 			조건식이 결과가 값1과 같은 경우 실행
	 * 			break;
	 * 		case 값2 :
	 * 			조건식 결과가 값2와 같은 경우 실행
	 * 			break;
	 * 		default :
	 * 			조건식의 결과가 일피하는 case문이 없을 때 실행
	 * }
	 * 
	 * - case문의 수는 제한이 없다 
	 * - 조건식의 결과는 정수, 문자, 문자열이어야 한다.
	 * - 조건문을 빠져나가혀면 break가 필요.
	 * - default문은 생략 가능하다
	 * */
	public void method1() {
		/*
		 * 숫자를 입력받아
		 * 1일 경우 빨간색입니다
		 * 2일 경우 파란색입니다
		 * 3일 경우 초록색입니다
		 * 잘못입력했을경우 잘목입력하셨습니다
		 * */
		System.out.print("숫자를 입력해주세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(num == 1) System.out.println("빨간색입니다");
		else if(num == 2) System.out.println("파란색입니다");
		else if(num == 3) System.out.println("초록색입니다");
		else System.out.println("잘못입력하셨습니다"); // 한줄처리도 가능

		
		switch(num) {
			case 1 : System.out.println("빨간색입니다");
			break;
			case 2 : System.out.println("파란색입니다");
			break;
			case 3 : System.out.println("초록색입니다");
			break;
			default : System.out.println("잘못입력하셨습니다");
		}
	}
	
	/*주민등록번호를 입력받아서 남자인지 여자인지 출력 
	 * 주민번호 입력 > 100000-3123456
	 * 남자
	 * */
	public void practice1() {
		System.out.print("주민번호를 입력해주세요 : ");
		char PplId = sc.nextLine().charAt(7);
		//int PplId = Integer.parseInt(sc.nextLine());
		
		switch(PplId) {
			case '1' : System.out.println("남자");
				break;
			case '2' : System.out.println("여자");
				break;
			case '3' : System.out.println("남자");
				break;
			case '4' : System.out.println("여자");
				break;
			default : System.out.println("등록되지않은 주민번호입니다.");
		
		}
		
		System.out.print("주민번호를 입력해주세요 : ");
		char PplId1 = sc.nextLine().charAt(7);
		//int PplId = Integer.parseInt(sc.nextLine());
		
		String result = "";
		switch(Integer.parseInt(String.valueOf(PplId1))) {
			case 1 :
			case 3 : System.out.println("남자");
				break;
			case 2 :
			case 4 : System.out.println("여자");
				break;
			default : System.out.println("등록되지않은 주민번호입니다.");
		
		}
		System.out.println(result);
	}
	
	/*
	 * 등급별 권한
	 * 1 : 관리권한, 글쓰기권한, 읽기권한
	 * 2 : 글쓰기권한, 읽기권한
	 * 3 : 읽기권한
	 * 등급입력 > 1 >
	 * 관리권한, 글쓰기권한, 읽기권한
	 * */
	public void practice2() {
		System.out.print("등급을 등록해주세요 : ");
		int number = Integer.parseInt(sc.nextLine());
		
		switch(number) {
			case 1 : System.out.println("관리권한, 글쓰기권한, 읽기권한");
			break;
			case 2 : System.out.println("글쓰기권한, 읽기권한");
			break;
			case 3 : System.out.println("읽기권한");
			break;
			default : System.out.println("없는 등급입니다.");
		}
		
		switch(number) {
		case 1 : System.out.println("관리권한");
		case 2 : System.out.println("글쓰기권한");
		case 3 : System.out.println("읽기권한");
		break;
		default : System.out.println("없는 등급입니다.");
	}
	}
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
		//b.method1();
		//b.practice1();
		b.practice2();
	}

}
