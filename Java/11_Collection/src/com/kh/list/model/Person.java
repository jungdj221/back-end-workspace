package com.kh.list.model;

public class Person {

	private String name;
	private String addr;
	private int age;
	
	
	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
	} // 생성자 생성


	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	
}
