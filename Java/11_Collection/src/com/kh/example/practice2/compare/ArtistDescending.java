package com.kh.example.practice2.compare;

import java.util.Comparator;

import com.kh.example.practice2.model.Song;

public class ArtistDescending implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		return o2.getSinger().compareTo(o1.getSinger());
	}

}
