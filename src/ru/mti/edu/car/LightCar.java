package ru.mti.edu.car;

public class LightCar extends Auto implements Moveable, Repairable, NewMoveable {

	private int weight;
	
	public LightCar(int w) {
		this.weight = w;
		Auto.markName = "Audi";
	}
	
	public LightCar() {
		super(1000);
		System.out.println("LightCar!!");		
	}
	
	@Override
	public void move(){
		System.out.println(this.weight);
	}
	
	public void repair() {
		
	}
	
	@Override
	public void move(String city){
		
	}

	@Override
	public void move(int distance) {
		Moveable.super.move(distance);
	}
}
