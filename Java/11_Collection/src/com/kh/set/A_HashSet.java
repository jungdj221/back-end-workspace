package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.set.model.Person;

/*
 * Set의 특징
 * - 중복 없음
 * - 순서 없다
 * */

//HashSet : Set 인터페이스를 구현한 대표적인 컬렉션 클래스

public class A_HashSet {

	
	
	public static void main(String[] args) {
		 A_HashSet a = new A_HashSet();
		 //a.method1();
		 a.method2();
	}

	public void method1() {
		Set<String> set = new HashSet<>();
		
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		set.add("라미란");
		set.add("라미란"); //중복값은 추가 안됨
		
		System.out.println(set);
		System.out.println(set.size());
		System.out.println("라미란이 포함되어 있는가? :" + set.contains("라미란"));
		
		set.remove("박병은");
		System.out.println(set);
		
		set.clear();
		System.out.println("비어있는지 ? " + set.isEmpty());
	}
	
	public void method2() {
		HashSet<Person> set = new HashSet<>();
		
		set.add(new Person("라미란", 48));
		set.add(new Person("공명", 29));
		set.add(new Person("염혜란", 47));
		set.add(new Person("박병은", 46));
		set.add(new Person("라미란", 48));
		set.add(new Person("라미란", 48));
		
		// 객체의 주소값을 가지고 비교하기 때문에 모두 다른 객체로 인식해서 중복 제거안됨.
		// -->객체에 hashCode, equals 메서드 재정의 자동생성, toString하듯이 하면됨.
		System.out.println(set);
		// 인덱스가 없기에 기존for문으로는 안되지만, 향상된 for문으로 출력 가능
		for(Person p : set) {
			System.out.println(p);
		}
		
		/*
		 * Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 * */
		System.out.println("------------");
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) { // 읽어올 요소가 있는지 확인
			System.out.println(it.next()); // 다음 요소를 읽어옴
		}
	}
}







