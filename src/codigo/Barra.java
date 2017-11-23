package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/**
 * 
 * @author Diego �lvarez
 *
 *la clase Barra es la que dibuja el cursor del juego
 */
public class Barra extends GRect{
	/**
	 * Crea el cursor del juego
	 * @param width-> el ancho del cursor
	 * @param height -> el alto del cursor
	 * @param _color -> color del cursor
	 */
	public Barra(double width, double height, Color _color) {
		super(width, height);
		setFilled(true);
		setFillColor(_color);
	}
	/**
	 * mueveBarra reposiciona la barra en la coordenada
	 * en la que est�
	 * @param posX la posicion X del raton. La Y la obtiene de la 
	 * propia barra
	 * @param anchoPantalla porque asi no tengo que pasar nada m�s
	 */
	public void mueveBarra(int posX, int anchoPantalla){
		if (posX + getWidth() < anchoPantalla){
			setLocation(posX, getY());
		}
	}
}
