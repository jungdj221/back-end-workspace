package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.controller.SongController;
import com.kh.example.practice2.model.Song;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private SongController control1 = SongController.getInstance();
	
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
					addLastList();
					break;
				case 2:
					addFirstList();
					break;
				case 3:
					printAll();
					break;
				case 4:
					SearchSong();
					break;
				case 5:
					removeSong();
					break;
				case 6:
					updateSong();
					break;
				case 7:
					ascTitle();
					break;
				case 8:
					descArtist();
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
			}
				
			}catch(NumberFormatException e) {
				System.out.println("잘못입력하셨습니다 : " + e.getMessage());
				//만일 while문 전체가 try문에 들어갈경우
				// catch에서 mainMenu(); 재호출
			}
		}
	}
	
	
	
	// 1. 마지막 위치에 곡 추가
	public void addLastList() { //add는 자동으로 곡을 뒤쪽에 추가해줌
		System.out.println("******마지막 위치에 곡 추가******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		// Song song = new Song(artist, title))
		// application에서 입력받은 두 값을 control로 보내기
		boolean result = control1.addLastList(artist, title);
		if(result) System.out.println("추가 성공");
		else System.out.println("추가실패");
		
		
	}
	
	// 2. 첫 위치에 곡 추가
	public void addFirstList() {
		System.out.println("******첫 위치에 곡 추가******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		Song song = new Song(artist, title);
		boolean result = control1.addFirstList(artist, title);
		if(result) System.out.println("추가 성공");
		else System.out.println("추가실패");
	}
	
	// 3. 전체 곡 목록 출력
	public void printAll() {
		System.out.println("******전체 곡 목록 출력******");
		for(Song listAll : control1.printAll()) {
			System.out.println(listAll);
		}
		
	}

	// 4. 특정 곡 검색
	public void SearchSong() {
		System.out.println("******특정 곡 검색******");
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
	
		Song song = control1.SearchSong(search);
		if(song!=null)System.out.println(song + " 을 검색 했습니다.");
		else System.out.println("키워드에 맞는 곡이 없습니다.");
	}
	
	// 5. 특정 곡 삭제
	public void removeSong() {
		System.out.println("******특정 곡 삭제******");
		System.out.print("삭제할 곡 명 : ");
		String removeSong = sc.nextLine();
//		for(int i=0; i<songList.size(); i++) {
//			if(songList.get(i).getTitle().equals(removeSong)) {
//				System.out.println(songList.get(i) + "을 삭제 했습니다.");
//				songList.remove(i);
//				break;
//			} else if(i == songList.size()-1) {
//				System.out.println("삭제할 곡이 없습니다");
//			}
//		}

		control1.removeSong(removeSong);
		if(removeSong!=null) System.out.println(removeSong + " 을 삭제 했습니다.");
		else System.out.println("삭제할 곡이 없습니다.");
		
		
	}
	
	// 6. 특정 곡 수정
	public void updateSong() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String searchSong = sc.nextLine();
		
//		for(int i=0; i<songList.size(); i++) {
//			if(songList.get(i).getTitle().equals(searchSong)) {
//				System.out.print("수정할 가수 명: ");
//				String updateSinger = sc.nextLine();
//				System.out.print("수정할 곡 명 : ");
//				String updateTitle = sc.nextLine();
//				System.out.println(songList.get(i) +  "의 값이 변경되었습니다.");
//				songList.set(i, new Song(updateSinger,updateTitle));
//				break;
//			}else if(i == songList.size()-1) {
//				System.out.println("수정할 곡이 없습니다.");
//			}
//		}
		System.out.print("수정할 곡 명 : ");
		String updateTitle = sc.nextLine();
		System.out.print("수정할 가수 명: ");
		String updateSinger = sc.nextLine();
		
		
		Song update = new Song(updateTitle, updateSinger);
		control1.updateSong(searchSong, update);
		
		if(searchSong!=null) System.out.println(searchSong + "의 값이 변경되었습니다.");
		else System.out.println("수정할 곡이 없습니다.");
		
	}
	
	// 7. 오름차순 정렬
	public void ascTitle() {
		System.out.println("******곡 명 오름차순 정렬******");
		
		for(Song s : control1.ascTitle()) {
			System.out.println(s);
		}
		
	}
	
	// 8. 가수명 내림차순
	public void descArtist() {
		System.out.println("******가수 명 내름차순 정렬******");
		
		for(Song s : control1.descArtist()) {
			System.out.println(s);
		}
	}
	

}
