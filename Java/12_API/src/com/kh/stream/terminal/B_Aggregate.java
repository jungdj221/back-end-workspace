package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class B_Aggregate {

	public static void main(String[] args) {
		B_Aggregate b = new B_Aggregate();
//		b.method1();
		b.method2();
	}
	
	/*
	 * 기본 집계
	 * - 최종 처리 기능으로 요소들을 개수, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 갑으로 산출하는 역할
	 * - count : 요소의 개수 리턴. return the number of elements
	 * - sum : 요소들의 합계 리턴. return the sum of elements
	 * - average : 요소들의 평균 리턴. return
	 * - max : 최대 요소 리턴
	 * - min : 최소 요소 리턴
	 * - findFirst : 첫번째 요소 리턴
	 * */
	public void method1() {
		int[] array = {1, 2, 3, 4, 5, 6};
		
		long count = Arrays.stream(array).count();
		System.out.println("개수 : " + count);
		
		int sum = Arrays.stream(array).sum();
		System.out.println("sum : " + sum);
		
		/*
		 * Optional class
		 * - 스트림의 최종결과 값을 저장하는 객체
		 * - 단순히 값만 저장하는 것이 아니아, 값의 존재 여부를 확인하고
		 * 	 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있는 객체
		 * */
		
		OptionalDouble avg = Arrays.stream(array).average();
		double avgResult = avg.getAsDouble();
		//get : 저장되어 있는 값을 얻기 위해 사용
		System.out.println("average : " + avg.getAsDouble());
		
		OptionalInt max = Arrays.stream(array).max();
		int maxResult = max.orElse(0);
		// orElse : get과 동일하게 저장되어 있는 값을 얻어오는 메서드로
		//			값이 저장되어 있지 않을 경우 디폴드 값을 지정
		System.out.println("max : " + max.getAsInt());
		
		OptionalInt min = Arrays.stream(array).min();
		// isPresent : 값이 저장되어 있는지 검사
		if(min.isPresent()) {
			System.out.println("min : " + min.getAsInt());
		} else {
			System.out.println("데이터가 없음");
		}
	
		OptionalInt ff = Arrays.stream(array).findFirst();
		// ifPresent : 값이 저장되어 있을 경우 값 처리(if + isPresent)
		ff.ifPresent(value -> System.out.println(value));
		System.out.println("findFirst : " + ff.getAsInt());
		
	}
	
	/*
	 * 커스텀 집계
	 * - 스트림에서 기본 집계 메서드를 제공하지만 다양한 집계 결과물을 만들 수 있도록
	 * 	 reduce 메서드를 제공한다.
	 * */
	public void method2() {
		int[] values = {1, 2, 3, 4, 5, 6};
		
		// 1 x 2 x 3 x 4 x 5 x 6
		int result = Arrays.stream(values)
							.reduce((x, y) -> x * y).getAsInt();
		System.out.println(result);
	}

}
