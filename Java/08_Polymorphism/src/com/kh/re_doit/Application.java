package com.kh.re_doit;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.re_doit.model.Book;
import com.kh.re_doit.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	Member member = new Member();

	int num = -1;
	
	// 책에대한 정보는 처음부터 필요함
	Book[] books = {
			new Book("맛있는 지중해식 레시피", true),
			new Book("카페 샌드위치 마스터 클래스", false),
			new Book("원피스 107", 19),
			new Book("주술회전 24", 15)
	};
			
	public static void main(String[] args) {
		
		
		
		Application app = new Application();
		app.mainMenu();
		
	}
	public void mainMenu() {
		
		
		System.out.print("이름 : ");
		member.setName(sc.nextLine()); // setter
		
		System.out.print("나이 : ");
		member.setAge(Integer.parseInt(sc.nextLine())); // setter
		
		/*
		 * for : 정해진 범위가 있을때
		 * while : 무한루프를 원할때
		 * */
		
		boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			
			switch(menu) {
			case 1:
				myPage();
				break;
			case 2:
				rentBook();
				break;
			case 3:
				check = false;
				break;
			}
			
		}
	}
	
	public void myPage() {
		System.out.println(member); // member.toString() // toString()은 생략해도 상관없음
	}
	
	public void rentBook() {
		for(int i = 0; i < books.length; i++) {
			System.out.println(i + "번 도서 : " + books[i]);
		} // toString을 지정해줘야함.
		System.out.print("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());
		
		Book selectBook = books[num]; // 사용자가 선택한 책 -> 대여할 도서 책
		
		// getter 를 이영해서 기존 책 리스트를 일단 가지고 와야 함
		Book[] newBookList = member.getBookList();
		
		for(int i =0; i < newBookList.length; i++) { // getter
			
			//System.out.println(member.getBookList()[i]); // getter
			if(newBookList[i]==null) { // getter
				// 대여 가능 공간
				
//				if(num == 0) {// 대여가능할때
					// -> 기존 쿠폰값(setter) = 기존 쿠폰값(getter) + 1
					 // setter + getter
					 // setter
//				}else if(num == 1) {
//					 
//				}else if(num == 2 && member.getAge() >= selectBook.getAccessAge()) { // getter
//					
//				}else if(num == 3 && member.getAge() >= selectBook.getAccessAge()) { // getter
//					
//				} 
				
				
				if(selectBook.isCoupon()) {
					// 내가 대여한 책의 쿠폰이 true인 경우
					member.setCoupon(member.getCoupon()+1); // 쿠폰이 true인 경우
				}
				if(member.getAge() >= selectBook.getAccessAge()) {
					// 내가 대여한 책의 접근 제한 나이보다 많은 경우
					newBookList[i] = books[num]; // 대여
				}

				break;
			}
		}
		member.setBookList(newBookList);
		
		// 대여 불가여부if문
		//  사용자 입력 age   < Book에 지정된 접근제한 age
		if((member.getAge() < selectBook.getAccessAge())) { // getter
			System.out.println("나이 제한으로 대여 불가능입니다.");
		}else {
			System.out.println("성공적으로 대여되었습니다.");
		}
		
	}

}
