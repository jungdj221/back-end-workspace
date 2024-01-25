package com.kh.example.practice1;

import java.util.Set;
import java.util.TreeSet;

public class Application {
	
	public static void main(String[] args) {
		/*
		 * 
		 * ArrayList<Integer> aLotto = new ArrayList<>();
		 * aLotto.add(2);
		 * aLotto.add(1);
		 * aLotto.add(0);
		 * ArrayList<Integer> aLotto2 = new ArrayList<>();
		 * aLotto2.add(2);
		 * aLotto2.add(0);
		 * aLotto2.add(1);
		 * Collections.sort(aLotto2) list를 쓸경우 이렇게 정렬을 해줘야됨 index가 있으므로
		 *  아래의 경우 autoLotto 와 myLotto들다 Collections.sort로 정렬해야 됨
		 * 
		 * 
		 * while(autoLotto.size() < 6) {// "결국 배열의 사이즈가 6이면 멈춘다"이기에 while로 됨
		 *		int random = (int)(Math.random()*45 +1);
		 *		if(!lotto.contains(random)) => 새로운random이 기존과 겹치지 않으면! 			
		 *		autoLotto.add(random); => 추가한다. list사용시 주의해야할점 중복을 피해야함.
		 *	}
		 * */
		//기계 로또
		TreeSet<Integer/*int는 안됨 class타입인 Interger로*/> autoLotto = new TreeSet();
		
		while(autoLotto.size() < 6) {// "결국 배열의 사이즈가 6이면 멈춘다"이기에 while로 됨
			int random = (int)(Math.random()*45 +1);			
			autoLotto.add(random);
		}
		
		int count = 0;
		while(true) {
			TreeSet<Integer> myLotto = new TreeSet<>();
			
			while(myLotto.size() < 6) {
				int random = (int)(Math.random()*45 +1);			
				myLotto.add(random);
			}
			count++;
			
			System.out.println("로또 번호 : " + autoLotto);
			System.out.println("내 번호 : " + myLotto);
			
			// 멈추는 조건 : 로또 번호와 내 번호가 정확히 일치
			if(autoLotto.equals(myLotto)) {
				System.out.println("횟수 : " + count);
				break;
			}
			
		}
		
	}

}
