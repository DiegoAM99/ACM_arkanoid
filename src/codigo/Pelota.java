package codigo;
/*
 * Autor: Diego Álvarez
 * 
 * La clave pelota es la que vamos a usar
 * Tiene dos constructores
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{
	double xVelocidad = 2; // velocidad de la bola en el eje X
	double yVelocidad = -2; // velocidad de la bola en el eje Y

	/**
	 * Este es el constructor básico, que es idéntico
	 * al de la clase GOval
	 * @param _ancho
	 * @param _alto
	 */
	public Pelota(double _ancho, double _alto){
		super(_ancho,_alto);
	}
	/**
	 * Este es el constructor dabuti que permite
	 * pasar al color como parámetro
	 * @param _ancho
	 * @param _color
	 */
	public Pelota(double _ancho, Color _color){
		super(_ancho,_ancho);
		if (_ancho <=0){
			this.setSize(1, 1);
		}
		this.setFillColor(_color);
		this.setFilled(true);
	}
	/**
	 * Se encarga de mover a la pelota y chequear si ha habido colisión
	 */
	public void muevete(Arkanoid _arkanoid){
		//chequea si ha chocado con las paredes izq o derecha
		if(this.getX()+ this.getWidth() >= _arkanoid.getWidth()|| this.getX()<0 ){
			xVelocidad*= -1;
		}
		//chequea si ha chocado con el techo
		if(this.getY()<0 ){
			yVelocidad*= -1;
		}
		if(chequeaColision(getX(), getY(), _arkanoid)){//chequeo la esquina superior izq
			if(chequeaColision(getX()+ getWidth(), getY(), _arkanoid)){//chequeo la esquina superior derecha
				if(chequeaColision(getX(), getY()+ getHeight(), _arkanoid)){//chequeo la esquina inferior izq
					if(chequeaColision(getX() + getWidth(), getY()+ getHeight(), _arkanoid)){//chequeo la esquina inferior derecha

					}
				}
			}
		}	
		//voya crear un método chequeaColision generico
		//que sirva para comprobar los choques entre la bola y los ladrillos
		//y la bola y el cursor


		move(xVelocidad, yVelocidad);

	}

	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado = true;
		GObject auxiliar;
		auxiliar = _arkanoid.getElementAt(posX, posY);

		if(auxiliar instanceof Ladrillo){
			if (auxiliar.getY() == posY || auxiliar.getY() + auxiliar.getHeight()== posY){
				yVelocidad *= -1;
			}
			else if(auxiliar.getX() == posX || auxiliar.getX() + auxiliar.getWidth() == posX){
				xVelocidad *= -1;
			}
			_arkanoid.remove(auxiliar);
			noHaChocado = false;
		}
		else if (auxiliar instanceof Barra){
			yVelocidad *= -1;
			noHaChocado = false;
		}
		return noHaChocado;
	}




}
