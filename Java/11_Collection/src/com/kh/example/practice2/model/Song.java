package com.kh.example.practice2.model;

public class Song{

	private String title;
	private String singer;
	
	
	public Song() {
	}
	public Song(String singer, String title) {
		this.singer = singer;
		this.title = title;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return  singer + " - "+ title;
	}
//	@Override
//	public int compareTo(Song o) {
//		return this.title.compareTo(o.title);
//	}
	
//	@Override
//	public int compareTo(Song o) {
//		return this.getSinger().compareTo(o.getSinger());
//	}
	/* 오름차순과 내림차순 처리를 따로 TitlAscending/artistDescending에서 했으므로, Song에서는 더이상
	 * implements Comparable<Song>이 필요없음
	 */
	
	
}
