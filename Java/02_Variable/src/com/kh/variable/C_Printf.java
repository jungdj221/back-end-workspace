package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {
		
		// System.out.println(출력하고자 하는 값); - 출력후 줄바꿈 발생 O
		// System.out.print(출력하고자 하는 값); - 출력만 함(줄바꿈 발생X)
		System.out.print("hello\n"); // 줄바꿈 하고싶으면 \n
		System.out.println("hello");
		
		System.out.println("-----------------");
		
		// System.out.printf("출력하고자하는 형식(포멧)",출력하고자하는는 값, 값,...);
		// 출력하고자하는 값들이 제시한 형식에 맞춰서 출력만 진행
		
		/*
		 * 포맷으로 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열, 문자도 가능
		 * */
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%
		System.out.println(iNum1 + "% " + iNum2 + "%");
		System.out.printf("%d%% %d%%\n", iNum1, iNum2); // %를 쓰기위해서는 %옆에%를 또 써줘야함 키워드로 인식안시키기 위해서
		System.out.println("---------------------");
		
		System.out.printf("%5d\n", iNum1); // 5칸 공간 확보 후 양수는 오른쪽 정렬
		System.out.printf("-%5d\n", -iNum1); // 음수 왼쪽 정렬
		System.out.printf("%5d\n", 300);
		
		System.out.println("---------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		System.out.printf("%f\t%f\n", dNum1, dNum2); // 무조건 소수점 아래 6번째 짜리까지 보여줌
		System.out.printf("%.3f\t%.2f\n", dNum1, dNum2);
		
		System.out.println("---------------------");
		
		char ch = 'a';
		String str = "Hello";
		
		System.out.printf("%c %10s %s\n",ch,str, ch); // a      Hello a 포맷수보다 적으면 오류, 많으면 넘친부분은 미포함 출력
		System.out.printf("%C %S\n", ch, str); // A HELLO 대문자로만 출력
	}

}
