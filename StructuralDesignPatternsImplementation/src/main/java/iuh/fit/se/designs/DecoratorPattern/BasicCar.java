package iuh.fit.se.designs.DecoratorPattern;

public class BasicCar implements Car {
	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}
}
