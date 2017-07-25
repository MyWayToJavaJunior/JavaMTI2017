package ru.mti.edu.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DivisionException {
	
//	private static Connection con;
	
	static {
//		try {
//			Class.forName("");// ojdbc driver loading
//			con = DriverManager.getConnection("");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int a = 5 / 0;
	}

	{
//		Class.forName("");// ojdbc driver loading
//		con = DriverManager.getConnection("");
	}
	
	public DivisionException()/* throws ClassNotFoundException, SQLException */ {
		
	}
	
	public static void main(String[] args) throws Exception {
//		if (args.length < 2) return;
		
//		if (b == 0) {
//			System.out.println("Делить на ноль нельзя");
//		}
//		else {
//			System.out.println("Result : " +  (a / b));
//		}
		int a = Integer.decode(args[0]),
				b = Integer.decode(args[1]);
		System.out.println(calculate(a, b));
		
//		System.out.println("Вызова не было, если бы не try-catch");
		new DivisionException();
	}
	
	public static int calculate(int a, int b){
		if ( a == 100 && b == 100){
			throw new IllegalArgumentException();
		}
		try {
			return a / b;
		}
		catch(ArrayIndexOutOfBoundsException e){
			//System.out.println("Произошло обращение к элементу с несуществующим индексом");
			return -1;
		}
		catch(ArithmeticException | NullPointerException | ClassCastException e){
			System.out.println("Делить на ноль нельзя");
			return -2;
		}
		catch(Throwable th){
			th.printStackTrace();
			return Integer.MIN_VALUE;
		}
//		finally {
//			return 13;
//		}
	}

}
