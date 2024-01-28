package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Song;

public class SongController {

	private Song s = new Song();
	
	public String case1(String singer, String title) {
		s.setSinger(singer);
		s.setTitle(title);
		return "추가 성공";
	}
}
