package iuh.fit.se.designs.AbstractFactoryPattern;

import iuh.fit.se.designs.models.Computer;
import iuh.fit.se.designs.models.PC;

public class PCFactory implements ComputerAbstractFactory {
	private String ram; 
	private String hdd; 
	private String cpu; 
	
	public PCFactory(String ram, String hdd, String cpu){ 
		this.ram=ram; 
		this.hdd=hdd; 
		this.cpu=cpu; 
	} 

	@Override
	public Computer createComputer() {
		return new PC(ram,hdd,cpu); 
	}

}
