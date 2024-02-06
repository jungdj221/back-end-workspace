package com.kh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.model.Book;
import com.kh.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private Book b = new Book();
	private Member m = new Member();
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	
	public static void main(String[] args) {
		Application app = new Application();
		try {
			app.mainMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mainMenu() throws SQLException {
		System.out.println("===== 도서 관리 프로그램 =====");
		
		boolean check = true;
		while(check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴번호 입력 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	
	// 1. 전체 책 조회
	public void printBookAll() throws SQLException {
		// 반복문문을 이용해서 책 리스트 출력
		ArrayList<Book> list = bc.printBookAll();
		for(Book book : list){
			System.out.println(book);
		}
		
	}
	
	// 2. 책 등록
	public void registerBook() throws SQLException {
		// 책 제목, 책 저자를 사용자에게 입력받아
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
		System.out.print("책 제목 : ");
		String title = sc.nextLine();
		System.out.print("책 저자 : ");
		String author = sc.nextLine();
		int result = bc.registerBook(title, author);
		if(result==1) System.out.println("성공적으로 책을 등록했습니다.");
		else System.out.println("책을 등록하는데 실패했습니다.");
		
		
	}
	
	// 3. 책 삭제
	public void sellBook() throws SQLException {
		// printBookAll(전체 책 조회 후)
		// 삭제할 책 번호를 선택을 사용자한테 입력 받아
		// 삭제에 성공하면 "성공적으로 책을 삭제 했습니다." 출력
		// 실패하면 "책을 삭제한느데 실패했습니다." 출력
		printBookAll();
		System.out.print("삭제할 책 번호 : ");
		int bookNo = Integer.parseInt(sc.nextLine());
		
		int result = bc.sellBook(bookNo);
		if(result==1) System.out.println( "성공적으로 책을 삭제 했습니다.");
		else System.out.println("책을 삭제하는데 실패했습니다.");
	}
	
	// 4. 회원등록
	public void registerMember() throws SQLException {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		m = new Member(id, pwd, name);
		int result = mc.registerMember(m);
		if(result==1) System.out.println("성공적으로 회원가입을 완료하였습니다.");
		else System.out.println();
		
		
	}
	
	// 5. 로그인
	public void login() {
		// 아이디 비밀번호 사용자한테 입력받아
		// 로그인 성공하면 "~~님, 환영합니다!" 출력
		// --> MemberMenu() 호출
		// 실패하면 "로그인에 실패했습니다." 출력
	}
	
	public void memberMenu() {
		boolean check = true;
		while(check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴번호 입력 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}
	
	// 1. 책 대여
	public void rentBook() {
		// printBookAll(전체 책 조회 출력 후)
		// 대여할 책 번호를 사용자한테 입력받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다."
		// 실패하면 "책을 대여하는대 실패했습니다." 출력
	}
	
	// 2. 내가 대여한 책 조회
	public void printRentBook() {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 단, 반납 기한도 같이 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	}
	
	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook(내가 대여 한 책 조회)후
		// 취소할 책 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 " 성공적으로 대여를 취소하였습니다." 출력
		// 실패하면 " 대여를 취소 하는데 실패했습니다." 출력
	}
	
	// 4. 회원탈퇴
	public void deleteMember() {
		// 회원탈퇴에 상공하면 "회원탈퇴 하였습니다." 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}
	
}
