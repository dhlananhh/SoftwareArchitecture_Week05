package iuh.fit.se.designs.tests;

import iuh.fit.se.designs.AbstractFactoryPattern.ComputerFactory;
import iuh.fit.se.designs.AbstractFactoryPattern.PCFactory;
import iuh.fit.se.designs.AbstractFactoryPattern.ServerFactory;
import iuh.fit.se.designs.models.Computer;

public class TestDesignPatterns {
	public static void main(String[] args) { 
        testAbstractFactory(); 
    } 

	private static void testAbstractFactory() {
        try {
            Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
            Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
            System.out.println("AbstractFactory PC Config::" + pc);
            System.out.println("AbstractFactory Server Config::" + server);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
