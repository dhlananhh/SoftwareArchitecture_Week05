package iuh.fit.se.designs.tests;

import iuh.fit.se.designs.DecoratorPattern.BasicCar;
import iuh.fit.se.designs.DecoratorPattern.Car;
import iuh.fit.se.designs.DecoratorPattern.LuxuryCar;
import iuh.fit.se.designs.DecoratorPattern.SportsCar;

public class DecoratorPatternTest {
	public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
