package ru.mti.edu.enumeration;

public enum LightColor {

	RED("r"), YELLOW("y"), GREEN("g");
	
	private String code;
	
	LightColor(String c){
		this.code = c;
	}
	
	public void print(){
		System.out.println(code);
	}
}
