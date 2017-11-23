package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/**
 * 
 * @author Diego Álvarez
 *
 *la clase ladrillo sirve para dibujar los ladrillos
 *del juego
 */
public class Ladrillo extends GRect{
/**
 * 
 * @param x
 * @param y
 * @param width
 * @param height
 * 
 * futuros cambios: que admita número de golpes
 */
	public Ladrillo(double x, double y, double width, double height, Color _color) {
		super(x, y, width, height);
		setFilled(true);
		setFillColor(_color);
	}

}
