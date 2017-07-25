package ru.mti.edu.car;

public class AutoRunner {

	public static void main(String[] args) {
		Auto auto = new FlightCar();
		Auto.markName = "VW";
		Auto taxi = new Taxi();
		
		if (auto instanceof FlightCar) {
			FlightCar car = (FlightCar) auto;
		}
		
//		Auto lightCar = new LightCar(1000);
		System.out.println("---");
		Auto lightCar = new LightCar();
		System.out.println("---");
//		lightCar.move();
		
		Auto newLightCar = new LightCar(2000);
		newLightCar.move();
		
		System.out.println("---");
		System.out.println(Auto.markName);
	}

}
