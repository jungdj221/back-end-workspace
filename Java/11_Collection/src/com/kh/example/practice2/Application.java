package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.model.Song;

public class Application {

	Scanner sc = new Scanner(System.in);
	ArrayList<Song> songList = new ArrayList<>();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	public void mainMenu() {
		boolean check = true;
		while(check) {
			System.out.println("=====메인메뉴=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1:
					case1();
					break;
				case 2:
					case2();
					break;
				case 3:
					case3();
					break;
				case 4:
					case4();
					break;
				case 5:
					case5();
					break;
				case 6:
					case6();
					break;
				case 7:
					case7();
					break;
				case 8:
					case8();
					break;
				case 9:
					check = false;
					break;
			}
				
			}catch(NumberFormatException e) {
				System.out.println("잘못입력하셨습니다 : " + e.getMessage());
			}
		}
	}
	
	public void case1() { //add는 자동으로 곡을 뒤쪽에 추가해줌
		System.out.println("******마지막 위치에 곡 추가******");
		System.out.print("가수 명 : ");
		String singerName = sc.nextLine();
		System.out.print("곡명 : ");
		String songName = sc.nextLine();
		songList.add(new Song(singerName, songName));
		System.out.println("추가 성공");
	}
	
	public void case2() {
		System.out.println("******첫 위치에 곡 추가******");
		System.out.print("가수 명 : ");
		String singerName = sc.nextLine();
		System.out.print("곡명 : ");
		String songName = sc.nextLine();
		songList.add(0,new Song(singerName, songName));
		System.out.println("추가 성공");
	}
	
	public void case3() {
		System.out.println("******전체 곡 목록 출력******");
		
		for(Song listAll : songList) {
			System.out.println(listAll);
		}
	}

	public void case4() {
		System.out.println("******특정 곡 검색******");
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
		
		boolean chk = false;
		for(Song nameAll : songList) {	
			//System.out.println(nameAll.getTitle().contains(search));
			if(nameAll.getTitle().contains(search)) {
				System.out.println(nameAll + " 을 검색 했습니다.");
				chk = true;
				break;
			}
		}
		if(!chk) {
			System.out.println("삭제할 곡이 없습니다");
		}
		
	}
	
	public void case5() {
		System.out.println("******특정 곡 삭제******");
		System.out.print("삭제할 곡 명 : ");
		String removeSong = sc.nextLine();
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(removeSong)) {
				System.out.println(songList.get(i) + "을 삭제 했습니다.");
				songList.remove(i);
				break;
			} else if(i == songList.size()-1) {
				System.out.println("삭제할 곡이 없습니다");
			}
		}
		
		
	}
	
	public void case6() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String searchSong = sc.nextLine();
		
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(searchSong)) {
				System.out.print("수정할 가수 명: ");
				String updateSinger = sc.nextLine();
				System.out.print("수정할 곡 명 : ");
				String updateTitle = sc.nextLine();
				System.out.println(songList.get(i) +  "의 값이 변경되었습니다.");
				songList.set(i, new Song(updateSinger,updateTitle));
				break;
			}else if(i == songList.size()-1) {
				System.out.println("수정할 곡이 없습니다.");
			}
		}
		
	}
	
	public void case7() {
		System.out.println("******곡 명 오름차순 정렬******");
		Collections.sort(songList);
	}
	
	public void case8() {
		
	}
	

}
