package com.kh.lang;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C_Date {

	public static void main(String[] args) {
		C_Date c = new C_Date();
		c.method1();
	}
	
	/*
	 * Date
	 * - java.util 패키지에 속한 날짜와 시간을 다룰 목적으로 만들어진 클래스(JDK 1.0)
	 * - Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 * */
	public void method1() {
		// 기본 생성자로 객체를 생성하면현재 시스템의 시간에 대한 정보를 가지고 객체를 생성
		Date today = new Date();
		System.out.println(today); //지금날짜 출력됨
		
		Date when = new Date(0);
		System.out.println(when);//Thu Jan 01 09:00:00 KST 1970
		
		System.out.println("getTime : " + today.getTime());
		
		//Deprecated된 기능들
		System.out.println("getYear : " + (today.getYear() + 1900) + "년");
		System.out.println("getmonth : " + (today.getMonth() + 1) + "월");
		System.out.println("getDate : " + today.getDate() + "일");
		System.out.println("getHours : " + today.getHours() + "시");
		System.out.println("getMinues : " + today.getMinutes() + "분");
		System.out.println("getSeconds : " + today.getSeconds() + "초");
	
		// SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록 (h: 1~12, H : 0~23)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
		//2024년 1월 26일 (금) 오후 4시 25분 30초
		String formatDate = sdf.format(today);
		System.out.println(formatDate);
	}

}
