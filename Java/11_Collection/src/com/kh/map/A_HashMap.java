package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * Map
 * - key-value 쌍으로 저장
 * - 순서 없음
 * - 중복 : 키(key) 중복안됨, 값(value) 중복됨
 * 
 * HashMap
 * - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * 
 * */
public class A_HashMap {

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
		//a.method1();
		a.method2();
	}

	public void method1() {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);
		
		System.out.println(map);
		
		// 1. 키만 가져오기
		Set<String> key = map.keySet(); // set 중복허용 안됨 기억하기
		System.out.println(key);
		
		// 2. 값만 가져오기
		Collection<Integer> col = map.values();
		System.out.println(col);
		
		// 3. 키에 해당하는 value값 가져오기
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name + " : " + map.get(name));
		}
		System.out.println("-----------");
		for(String i : key) {
			System.out.println(i + " : " + map.get(i));
		}
		/*
		 * 4. entrySet
		 * - Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진)를
		 * 	 Set 컬렉션에 담아서 변환
		 * - 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
		 * */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println(entrySet);
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+ " : " + entry.getValue());
		}
	}
	
	public void method2() {
		Map<String, Snack> map = new HashMap<>();
		// 키는 중복 안됨
		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콜달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 900));
		
		System.out.println("과자의 개수 : " + map.size()); // 9
		// 웨하스에 뭐가 들었을까?
		System.out.println(map.get("웨하스")); // 딸기 put은 sql의 update와 같은 수정역할
		
		// 키값으로 삭제하기 -꼬깔콘
		map.remove("꼬깔콘");
		System.out.println(map.size());
		System.out.println(map);
		
		
		System.out.println("--------------------");
		// 1. 홈런볼게 해당하는 과자 정보
		System.out.println(map.get("홈런볼"));
		// 2. 후렌치파이의 맛정보 출력
		System.out.println("--------------------");
		System.out.println("후렌치파이 맛 : " + map.get("후렌치파이").getFlavor());
		// 3. 모든 과자의 칼로리 총합과 평균 출력
		System.out.println("--------------------");
		
		// key로 하기
		int sumCal = 0;		
		Set<String> keySet = map.keySet(); // 키만 들어 있는 Set!
		System.out.println("keySet : " + keySet);
		for(String key : keySet) {
			Snack snack = map.get(key);
			sumCal += snack.getCalorie();
		}
		System.out.println("모든 과자의 칼로리 총합 칼로리 : " + sumCal);
		System.out.println("모든 과자의 칼로리 평균 칼로리 : " + sumCal/map.size());
		
		// entry
		int sumCal2 = 0;
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		for(Entry<String, Snack> entry : entrySet) {
			Snack snack = entry.getValue();
			sumCal2 += snack.getCalorie();
		}
		System.out.println("모든 과자의 칼로리 총합 칼로리 : " + sumCal2);
		System.out.println("모든 과자의 칼로리 평균 칼로리 : " + sumCal2/map.size());
		
		// 내가 한 방식
		int sum3 = 0;
		for(Snack snack : map.values()) {
			sum3 += snack.getCalorie();
		}
		System.out.println("모든 과자의 칼로리 총합 칼로리 : " + sumCal2);
		System.out.println("모든 과자의 칼로리 평균 칼로리 : " + sumCal2/map.size());

		//모든 Entry 객체 삭제
		map.clear();
		System.out.println("비어있는지 : " + map.isEmpty());
		System.out.println(map);
		
		
	}
}
