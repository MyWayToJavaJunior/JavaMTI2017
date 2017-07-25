package ru.mti.edu;

public class Human {

	private int age;
	String fullName;
	double weight;
	
//	public Human(){
//		
//	}
	
	public Human(int a, String f, double w){
		setAge(a);
		setFullName(f);
		setWeight(w);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int hashCode(){
		return 17 * age + fullName.hashCode() + 
				Double.valueOf(17 * weight).intValue();
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Human)) return false;
		
		Human h = (Human) obj;
		return 
				h.age == this.age &&
					h.fullName.equals(this.fullName) &&
						h.weight == this.weight;
	}
	
	public void go() {
		System.out.println("Go");
	}
	
	public void grow(){
		age++;
	}
	
	public void grow(int a){
		this.age += a;
//		this.age = this.age + a;
	}
}
