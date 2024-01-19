package com.kh.array.practice2;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	
	public void mainMenu() {
		/*
		 * 회원수가 3명이 최대 등록가능
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.와 함께
		 * "1. 새 회원 등록" 하지 못하게  -> 화면상 안보이게만 처리
		 * 
		 * 1번 -> insertMember();
		 * 2번 -> updateMember();
		 * 3번 -> printAll();
		 * 9번 -> 프로그램 종료
		 * 그 외의 경우 -> 잘목 입력하셨습니다. 다시 입력해주세요.
		 * 
		 * */
		
		
		
		boolean check = true;
		while(check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는 "+ mc.count +"명입니다");
			
			if(mc.count < 3) {
				System.out.println("1. 새 회원 등록");
			}else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			
			
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴번호 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				if(mc.count < 3)insertMember();
				break;
			case 2:
				updateMember();
				break;
			case 3:
				printAll();
				break;
			case 9:
				check = false;
				break;
			}
		}
			
		
	}
	
	public void insertMember() {
		/*
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		 * "중복된 아이디입니다. 다시 입력해주세요." 출력 후 
		 * 다시 아이디 입력부터 나올 수 있게 처리
		 * */	
		///Member m = new Member();
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			if(mc.checkId(id) !=-1) {
				System.out.println("중복된 아이디 입니다. 다시 입력해주세요.");
				insertMember();
			}else {
				System.out.print("이름 : ");
				String name =sc.nextLine();
				
				System.out.print("비밀번호 : ");
				String password = sc.nextLine();
				
				System.out.print("이메일 : ");
				String email = sc.nextLine();
				
				System.out.print("성별(M/F) : ");
				char gender = sc.nextLine().charAt(0);
				
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				
				Member m = new Member(id, name, password, email, gender, age);
				mc.insertMember(m);
			}
			
			
			
			
		
			//System.out.println("회원 수가 모두 꽊 찼기 때문에 일부 메뉴만 오픈됩니다.");
		
	}
	
//	private char charAt(String nextLine) {
//		return 0;
//	}

	public void updateMember() {
		/*
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		 * "회원정보가 없습니다." 출력 후 다시 메인 화면으로
		 * */
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		if(mc.checkId(id) == -1) {
			System.out.println("회원 정보가 없습니다");
			return; // else 쓰기 싫으면 이렇게 return으로 void 내에서 그냥 끝내버림
		}
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email= sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		
		mc.updateMember(id, name, email, password);
	}
	
	public void printAll() {
		/*
		 * 전체 회원 정보 출력
		 * */
		Member[] mArr = mc.printAll();
		for(Member m : mArr) {
			if(m!=null) System.out.println(m);
		}
	}

}
