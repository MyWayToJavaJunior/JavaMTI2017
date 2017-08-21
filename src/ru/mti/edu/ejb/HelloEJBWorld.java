package ru.mti.edu.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloEJBWorld
 */
@Stateless
@LocalBean
public class HelloEJBWorld implements HelloWorld{

    /**
     * Default constructor. 
     */
    public HelloEJBWorld() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String helloWorld() {
		return "Hello World";
	}

}
