package iuh.fit.se.designs.AbstractFactoryPattern;
import iuh.fit.se.designs.models.Computer;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory){ 
        return factory.createComputer(); 
    } 
}
