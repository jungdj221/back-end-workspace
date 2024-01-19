package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {

	private Member[] mArr = new Member[3];
	public int count = 0;
	
	/*
	 * String id, String name, String password, String email, char gender, int age
	 * */
	
	// 멤버 추가
	public void insertMember(Member m) {
//		mArr[count] = new Member(id, name, password, email, gender, age);
//		mArr[count].setId(id);
//		mArr[count].setName(name);
//		mArr[count].setPassword(password);
//		mArr[count].setEmail(email);
//		mArr[count].setGender(gender);
//		mArr[count].setAge(age);
//		count +=1;
		
		//위에거 줄이기
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
		
			
		
		
	}
	// 멤버가 index를 아이디로 아이디로 조회
	public int checkId(String id) {
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String password) {
		int index = checkId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
	}
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
}
