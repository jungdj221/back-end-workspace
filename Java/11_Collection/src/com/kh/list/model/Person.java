package com.kh.list.model;

public class Person implements Comparable<Person>{

	private String name;
	private String addr;
	private int age;
	
	
	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
	} // 생성자 생성


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}

	/*
	 * compartTo : 반환되는 값을 가지고 정렬 기준을 잡는다.
	 * - 자기자신과 매개값으로 전달된 객체가 같은 타입의 객체인지 비교
	 * - 비교해서 같으면 0을 반환, 자기자신이 크다면 양의 정수(1), 작다면 음의 정수(-1) 반환
	 * */

	@Override
	public int compareTo(Person o) {
		//return this.age == o.age ? 0 : this.age > o.age ? 1 : -1;
		return this.name.compareTo(o.name); // 문자열 비교는 이렇게
	}
	
	
}
