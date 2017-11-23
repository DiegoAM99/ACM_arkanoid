package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

/*
 * Autor:Diego Álvarez
 * 
 * El Arkanoid pero orientado a objetos
 */

import acm.graphics.*;
public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1= new Pelota(20, Color.BLUE);
	//Pelota pelota2 = new Pelota (30, Color.GREEN);
	Barra barra1 = new Barra(60, 15, Color.RED);
	int anchoLadrillo = 27;
	int altoLadrillo = 15;
	int espacioMenu = 200;
	
	int puntuación = 0;
	Marcador marcador = new Marcador(20, 40);
	
	public void init(){
		addMouseListeners();
		setSize(600,600);
		GRect lateral = new GRect (3, getHeight());
		lateral.setFilled(true);
		add(lateral, getWidth() - espacioMenu - lateral.getWidth() - pelota1.getWidth(), 0);
		add(pelota1, 0, getHeight()*0.60 - pelota1.getWidth());
		//add(pelota2, 0, getHeight()*0.75 - pelota1.getWidth());
		add(barra1, 0, getHeight()*0.80);
	}

	public void run(){
		dibujaNivel01();
		marcador.dibuja(this);
		while (true){
			pelota1.muevete(this);
			//pelota2.muevete(this);
			pause(7);
		}
		
	}

	public void mouseMoved(MouseEvent _evento){
		barra1.mueveBarra(_evento.getX(), getWidth());
	}
	private void dibujaNivel01(){
		for (int j=0; j < 14; j++){
			for(int i=j; i < 14; i++){
				Ladrillo miLadrillo = new Ladrillo(anchoLadrillo*i - anchoLadrillo*j/2, altoLadrillo*j + altoLadrillo, anchoLadrillo, altoLadrillo, Color.CYAN);
				add((miLadrillo));
				pause(7);
			}
		}
	}
}
