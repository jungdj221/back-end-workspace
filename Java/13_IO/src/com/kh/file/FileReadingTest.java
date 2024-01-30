package com.kh.file;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 문자 기반 스트림
 * - 문자 데이터를 읽고 출력할 때 사용
 * - Reader, Writer : 문자 기반의 입출력 스트림의 최상위 클래스
 * */

public class FileReadingTest {
	
	String fileName = "src/test.txt";
	String outfileName = "src/result.txt";

	public static void main(String[] args) {
		FileReadingTest f = new FileReadingTest();
		f.fileSave();
	}
	
	public void fileSave() {
		//  FileWriter를 이용해서 파일을 생성하고 데이터를 문자 단위로 저장
		
		// try-with-resource문을 통해서 사용한 리소스를 자동으로 close()
		try(FileWriter fw = new FileWriter(fileName, true)) {
						// true면 이어쓰기, false면 한번만 해당 파일에 쓰기
			fw.write("IO 재밌나요?\n");
			fw.write("아닌가요? \n");
			fw.write("뭐가 되었든 끝납니다.\n");
			fw.write("오전 수업끝\n");
			
			fw.flush(); // 강제로 자료 출력
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			
			fw.write("IO 재밌나요?\n");
			fw.write("아닌가요? \n");
			fw.write("뭐가 되었든 끝납니다.\n");
			
			fw.flush(); // 강제로 자료 출력
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		
	}

}
