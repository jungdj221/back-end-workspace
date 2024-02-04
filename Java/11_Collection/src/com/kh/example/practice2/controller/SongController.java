package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.model.Song;

public class SongController {

	private Song s = new Song();
	private ArrayList<Song> songList = new ArrayList<>();
	
	//싱글톤 패턴(Singleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	// 1. 생성자는 private
	private SongController() {}
	
	// 2. 유일한 객체를 담을 static 변수 
	private static SongController instance;
	
	// 3. 객체를 반환하는 static 메서드
	public static SongController getInstance() {
		if(instance == null) instance = new SongController();
		return instance;
	}
	
	
	public boolean addLastList(String artist, String title) {
		if(!title.equals("")&& !artist.equals("")) {	
			return songList.add(new Song(artist, title));
		}
		return false;	
	}
	
	public boolean addFirstList(String artist, String title) {
		if(!s.getTitle().equals("")&& !s.getSinger().equals("")) {
			songList.add(songList.indexOf(0),new Song(artist, title));
			return true;
		}
		return false;
	}
	
	public ArrayList<Song> printAll() {
			return songList;
	}
	
	public Song SearchSong(String search) {
		
//		boolean chk = false;
		for(Song nameAll : songList) {	
			if(nameAll.getTitle().contains(search)) {
				return nameAll;
			}
		}
//		if(!chk) {
//			
//		}
		return null;
	}
	
	public Song removeSong(String removeSong) {
		
		for(Song song : songList) {
			if(song.getTitle().equals(removeSong)) {	
				return songList.remove(songList.indexOf(song));
				
			}
		}
		return null;
		
		
	}
	public Song updateSong(String search, Song update) {
		for(Song song : songList) {
			if(song.getTitle().equals(search)) {
				return songList.set(songList.indexOf(song), update);
			}
		}
		return null;
	}
	
	public ArrayList<Song> ascTitle() {
		
		ArrayList<Song> cloneList = (ArrayList<Song>) songList.clone();
		Collections.sort(cloneList, new TitleAscending());
		return cloneList;
	}
	
	public ArrayList<Song> descArtist() {
		
		ArrayList<Song> cloneList = (ArrayList<Song>) songList.clone();
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
		
	}
}
