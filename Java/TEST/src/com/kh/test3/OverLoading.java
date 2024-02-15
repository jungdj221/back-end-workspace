package com.kh.test3;

//public class OverLoading {

//	public void test() {} // 기본 형태, 가장 마지막과 duplicated
//	public void test(String str) {} // 전달받는 매개변수명이 다르나, 변수타입이 같음
//	public void test(int i) {} // 전달받는 변수 타입의 종류와 개수가 같음
//	public void test(String s) {} // 전달받는 매개변수명이 다르나, 변수타입이 같음
//	public void test(char ch) {} // 전달받는 매개변수가 char타입인 것은 이것 하나만 있음.
//	public void test(String str, int i) {}// 통과
//	public void test(int i, String str) {}// 입력받는 변수 타입과종류가 같으나, 입력받는 순서가 다름. 그래서 안 겹침
//	private void test(int i) {}
//	public int test() { //  return타입이 다르더라도,기본형태와 같아서 duplicated.
//		return 0;
//	}
//}

public class OverLoading {

	public void test() {} 
	public void test(double du) {}
	public void test(int i, int j) {}
	public void test(String s) {} 
	public void test(char ch) {} 
	public void test(String str, int i) {}
	public void test(int i, String str) {}
	private void test(int i) {}
	public int test(int a, int b, int c) { 
		return a + b + c;
	}
}
