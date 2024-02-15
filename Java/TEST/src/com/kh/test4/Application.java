package com.kh.test4;

import com.kh.test4.model.Person;

public class Application {

	public static void main(String[] args) {

		Person[] pArr = new Person[3];
		
		pArr[0] = new Person("person1");
		pArr[1] = new Person("person2");
		pArr[2] = new Person("person3");
		
		
		for(int i=0; i < pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
	}

}
