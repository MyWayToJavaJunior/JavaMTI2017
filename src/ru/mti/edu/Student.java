package ru.mti.edu;

public class Student extends Human {

	int course;
	
	public Student(String fullName, double w) {
		super(18, fullName, w);
	}
	
	void study(){
		
	}
	
	@Override
	public void go() {
		System.out.println("Run");
	}
}
