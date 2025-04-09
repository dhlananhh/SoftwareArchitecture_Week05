package iuh.fit.se.designs.tests;

import iuh.fit.se.designs.BridgePattern.GreenColor;
import iuh.fit.se.designs.BridgePattern.Pentagon;
import iuh.fit.se.designs.BridgePattern.RedColor;
import iuh.fit.se.designs.BridgePattern.Shape;
import iuh.fit.se.designs.BridgePattern.Triangle;

public class BridgePatternTest {
	public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}
