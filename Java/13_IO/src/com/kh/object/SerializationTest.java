package com.kh.object;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

import com.kh.object.model.Person;

public class SerializationTest {

	public static void main(String[] args) {

		SerializationTest s = new SerializationTest();
		//s.fileSave();
		//s.fileRead();
		s.objectsSave();
		s.objectsRead();
	}
	
	String fileName = "src/Person.obj";
	
	// 직렬화(serialization) : 객체를 데이터 스트림으로 만드는 것
	public void fileSave() {
		try(// 1. 스트림 생성
			// FileOutputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
			// ObjectOutpuStream : 객체 단위로 출력시에 사용되는 보조 바이트 스트링 클래스
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
				
				){
			// 2. 파일에 저장할 객체 생성
			Person p = new Person("제니", 28, "jennierubyjane");
			
			// 3. 파일에 데이터(객체) 저장
			oos.writeObject(p);
			System.out.println("person.obj 파일에 정보 저장");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 역직렬화(deserialization) : 저장된 내용이나 전송받은 내용을 다시 복원
	public void fileRead() {
		
		try(// 1. 스트림 생성
			// FileInputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
			//ObjectInputStream : 객체 단위로 출력 시에 사용되는 보조 바이트 스트림 클래스
			FileInputStream fs = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fs);
			//ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
				){
			// 2. 보조 스트림에 담겨진 객체 가져오기
			Person p = (Person) ois.readObject();
			System.out.println(p);
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 여러 객체를 저장 (for문 이용)
	public void objectsSave() {
		List<Person> list = Arrays.asList(
				new Person("제니", 28, "jennierubyjane"),
				new Person("지수", 29, "sooyaaa__"),
				new Person("로제", 26, "roses_are_rosie"),
				new Person("뷔", 28, "thv"),
				new Person("지민", 28, "j.m")
				);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			// 파일 저장할 객체 생성
			Person p = new Person();
			//System.out.println("새로운 객체 : " + p);
			// 파일 저장(oos.writeObject(list.get(0 ~ 1)))
			for(Person pIn : list) {
				oos.writeObject(pIn);
			}
			System.out.println("person.obj 파일에 정보저장");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일에 저장한 데이터 읽기 (반복문 : 무한루프 + try~catch)
	public void objectsRead() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));){
			// 보조 스트림에 담긴 객체 가져오기(ois.readObject()는 계속 가져오기만 함)
			while(true) {
				Person p = (Person) ois.readObject();
				System.out.println(p);
			}
		}/*catch(Exception e) {
			가장 최상위 Exception으로 하면 다 잡기는 하나 따른게 틀렸을 때 왜 틀렸는지 말 안해줌 
		}*/catch(EOFException e) {// 하위클래스이기에 먼저 와야 상위클래스인IOException가 안 잡아먹음
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
