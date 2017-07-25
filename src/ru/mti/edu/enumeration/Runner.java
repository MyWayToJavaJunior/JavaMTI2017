package ru.mti.edu.enumeration;

public class Runner {

	public static void main(String[] args) {
		LightColor greenColor = LightColor.GREEN;
		LightColor redColor = LightColor.RED;
		
		System.out.println(greenColor.name());
		
		LightColor yellow = Enum.valueOf(LightColor.class, "YELLOW");
//		LightColor yellow = LightColor.valueOf("YELLOW");
		yellow.print();
		
		LightColor y = LightColor.YELLOW;
		
		System.out.println(yellow == y);
		
		switch(yellow){
			case GREEN : break;
			default : { 
				
				break; 
			}
		}
	}

}
