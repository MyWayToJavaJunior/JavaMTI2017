package ru.mti.edu.car;

public interface Moveable {
	public static final int a = 5;
	
	void move();
	
	default void move(int distance){
		System.out.println("Move with offset " + distance + "kms");
	}
	
	default void move(String city){
		System.out.println("Move to " + city);
	}
}
