package ru.mti.edu;

import java.math.BigDecimal;
import java.math.BigInteger;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		// here 
		/* multi-line comment*/
		
		byte b = (byte) 1270;
		short s = 1270;
		int index = 1;
		long lIndex = 2560000000L;
		char c = 100;
		
		float f = 3.14f;
		double d = 10000.45643;
		
		BigInteger big = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000");
		BigDecimal decimal = new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000.100");
		
		Integer i = index;
//		i = null; // NPE
		index = i;
		
		System.out.println(big);
		
		String sLine = "Hello World";
		
		char character = '\u0102';
		
		System.out.println(character);
		
		String camelCase = "Camel Case" +
				" \n new Line";
		System.out.println(camelCase);
	}
}
