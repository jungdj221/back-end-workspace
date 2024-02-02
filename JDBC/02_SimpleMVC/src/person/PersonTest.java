package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Serverinfo;
import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	PersonController pc = new PersonController();
	public static void main(String[] args) {
		PersonTest pt = new PersonTest();
		try {
			
			
			
			// person 테이블에 추가
//			pt.addPerson(111, "김강우", "서울");
//			pt.addPerson(222, "고아라", "제주도");
//			pt.addPerson(333, "강태주", "경기도");
			
			// person 테이블에서 데이터 수정
//			pt.updatePerson(111, "제주도");
			
			// person 테이블에서 데이터 삭제
//			pt.removePerson(333);
			
			// person 테이블에 있는 데이터 전체 보여주기
//			pt.searchAllPerson();
			
			// person 테이블에 데이터 한개만 가져오기
			pt.searchPerson(111);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)
	public void addPerson(int id, String name, String address) throws SQLException {
	
		if(pc.addPerson(id, name, address) == 1) System.out.println(name + "님, 회원가입 완료");
		
	}
	
	public void updatePerson(int id, String address) throws SQLException {

		int result = pc.updatePerson(id, address);
		if(result == 1) System.out.println(result + "명 수정완료");
	}
	
	public void removePerson(int id) throws SQLException {
		
		int result = pc.removePerson(id);
		if(result == 1) System.out.println(result + "명 삭제완료");
	}
	
	public void searchAllPerson() throws SQLException {

		// 실행
		ArrayList<Person> personList =  pc.searchAllPerson();
		for(Person p : personList) {
			System.out.println(p);
			System.out.println(p.getId() + ", " + p.getName() + ", " + p.getAddress());
		}
		
		
	}
	
	public void searchPerson(int id) throws SQLException {
		Person p = pc.searchPerson(id);
		System.out.println(p);

		}
	}


