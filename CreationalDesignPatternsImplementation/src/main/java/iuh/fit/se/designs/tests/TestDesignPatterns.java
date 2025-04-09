package iuh.fit.se.designs.tests;

import iuh.fit.se.designs.FactoryPattern.ComputerFactory;
import iuh.fit.se.designs.models.Computer;

public class TestDesignPatterns {
	public static void main(String[] args) { 
        testAbstractFactory(); 
    } 
	 
	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
	}
}
