package com.kh.variable;

public class A_Variable {

	/*
	 * 변수(Variable) - 값을 저장하는 공간
	 */

	public static void main(String[] args) {

		// 실행할 메소드가 있는 클래스를 생성(new)
		A_Variable variable = new A_Variable();

		// 생성한 클래스로 메소드 실행(호출)
//		variable.printValue();
		variable.variableTest();
	}

	public void printValue() {

		// 변수를 사용하지 않으면 Console에 원의 둘레와 원의 넓이를 출력
		System.out.println(10 * 2 * 3.141592);
		System.out.println(10 * 10 * 3.141592);

		System.out.println("---------------");
		// 변수를 사용하면
		int r = 10;
		double pi = 3.141592;

		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);
	}

	public void variableTest() {
		/*
		 * * 변수의 선언 자료형 변수명;
		 * 
		 * - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리르 할당받을지에 대한 정보 - 변수명 : 변수의 이름의 값을 읽고, 쓰고, 지우는
		 * 작업을 할 때 사용
		 * 
		 * * 변수의 초기화 변수명 = 값; - 변수에 처음으로 값을 저장하는 것 - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		 **/

		// 기본 자료형(Primitive type) : 실제 값을 저장
		// 1. 논리형 : 1byte(=8bit)
		boolean isTrue; // 변수선언
		isTrue = true; // 변수 초기화

		boolean isFalse = false;
		// isFalse = 1; 에러발생

		// 2. 문자형 : 2byte(=16bit)
		char ch = 'a'; // 따옴표만 됨, 쌍따옴표는 안됨
		// ch = 'ab'; 에러발생, 문자열은 한글자만옴
		
		//3. 정수형
		byte bNum = 1; // 1byte(-128~127) 256 = 2^8
		bNum = 127; // -128 ~ 127
		//bNum = 128; 에러발생 오버플로우(Overflow)
		short sNum = 128; // 2byte
		int iNum = 922337; // 4byte(기본)
		long lnum = 92233728458L; // 8 byte - 숫자 뒤에 (l or L)을 입력
		
		System.out.println(lnum);
		
		// 4. 실수형
		float fNum = 1.2F; // 4byte - 숫자 뒤에 f or F 붙여야함
		double dNum = 1.2; // 8byte (기본)
		System.out.println(fNum);
		}

}
