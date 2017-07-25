package ru.mti.edu.car;

public abstract class Auto {

	public static String markName;
	
	public Auto(){
		System.out.println("Auto!!");
	}
	
	public Auto(int i){
		System.out.println("Auto " + i);
	}
	public abstract void move();
}
