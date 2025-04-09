package iuh.fit.se.designs.tests;

import iuh.fit.se.designs.CompositePattern.Circle;
import iuh.fit.se.designs.CompositePattern.Drawing;
import iuh.fit.se.designs.CompositePattern.Shape;
import iuh.fit.se.designs.CompositePattern.Triangle;

public class TestCompositePattern {
	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();

		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);

		drawing.draw("Red");

		drawing.clear();

		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}
}
