package iuh.fit.se.designs.tests;
import iuh.fit.se.designs.builders.Computer;

public class TestBuilderPattern {
	public static void main(String[] args) {
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        System.out.println("HDD: " + comp.getHDD());
        System.out.println("RAM: " + comp.getRAM());
        System.out.println("Graphics Card Enabled: " + comp.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + comp.isBluetoothEnabled());
    }
}
