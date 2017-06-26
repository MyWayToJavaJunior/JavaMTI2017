package ru.mti.edu;

public class HumanRunner {

	public static void main(String[] args) {
		Human me = new Human(30, "Ivanov Ivan", 90);
		me.setAge(30);
		Human me2 = new Human(30, "Ivanov Ivan", 90);
		Human petrov = new Human(20, "Petrov Petr", 60);
		
//		Student s = (Student) petrov;
		
		System.out.println("Equals 1 :" + (me == me2));
		System.out.println("Equals 2 :" + me.equals(me2)); 
		
		Human sidorov = new Student("Sidorov Ivan", 90);
		
		petrov.go();
		sidorov.go();
	}
}
