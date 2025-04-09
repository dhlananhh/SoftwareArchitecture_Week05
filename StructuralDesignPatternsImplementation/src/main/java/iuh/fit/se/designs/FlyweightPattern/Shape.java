package iuh.fit.se.designs.FlyweightPattern;

import java.awt.Graphics;
import java.awt.Color;

public interface Shape {
	public void draw (Graphics g, int x, int y, int width, int height, Color color);
}
