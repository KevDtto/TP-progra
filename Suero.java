package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Suero {
	private double x
	;
	private double y;
	private double radio;
	private double distancia;
	private Image image = Herramientas.cargarImagen("Suero.png");
	private Image aux = this.image;

	public Suero(/*double x, double y,*/ double radio) {
//		this.x = x;
//		this.y = y;
		this.radio = radio;
	}

	public void dibujar(Entorno e) {
		e.dibujarCirculo(this.x, this.y, this.radio, Color.CYAN);
	}

	public void dibujar2(Entorno e) {
		if (this.image != null) {
			e.dibujarImagen(image, x, y, 0, 0.1);
		}else {
			e.dibujarImagen(aux, x, y, 0, 0.1);
		}
		
	}
//	public boolean colision(double x1, double y1, double x2, double y2, double dist) {
//		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
//	}

	public Image getAux() {
		return aux;
	}

	public void setAux(Image aux) {
		this.aux = aux;
	}

	public boolean colisiona(double radio1, double radio2, double dist) {
		return (radio1 + radio2) > dist;
	}

	public void distancia(double x1, double y1, double x2, double y2) {
		this.distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

//	getters and setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
