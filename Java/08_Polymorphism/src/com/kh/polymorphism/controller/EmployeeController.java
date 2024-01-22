package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {
	// 매개변수와 리턴값 뭘로 처리를 해야하는지
	// 이름으로 사람찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {	
		
		for(Employee employee : empArr) {
			if(employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}
	
	//찾은 사람의 연봉
	public int getAnnualSalary(Employee result/*담아낼때의 매개변수명이기에 result 대신 e로 해도됨. 단 밑에거 전부 result. -> e.으로 바꾸기*/) {
		int annualSalary = result.getSalary()*12;
		if(result instanceof Engineer) {
			Engineer engineer = (Engineer) result; // 부모(Employee) -> 자식으로(Engineer) : 강제 형변환
			return annualSalary + engineer.getBonus();
		} // return을 만나는 순간 if문을 나가므로 else는 없어도 아래것이 알아서 출력됨
		return annualSalary;
		
	}
	
	// 연봉총합
	public int getAllSalary(Employee[] empArr) {
		int sumSalary = 0;
		for(Employee employee : empArr) {
			 sumSalary += getAnnualSalary(employee);
		}
		return sumSalary;
		
	}
}

