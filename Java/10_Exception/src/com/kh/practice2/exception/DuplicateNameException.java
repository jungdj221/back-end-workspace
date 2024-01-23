package com.kh.practice2.exception;

public class DuplicateNameException extends Exception{

	public DuplicateNameException() {
		this("중복된 사림이 있어서 에러 발생");
	}

	public DuplicateNameException(String message) {
		super(message);
		
	}

	
	
}
