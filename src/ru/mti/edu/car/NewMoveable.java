package ru.mti.edu.car;

public interface NewMoveable {

	default void move(int distance){
		System.out.println("Move with offset " + distance + "kms");
	}	
}
