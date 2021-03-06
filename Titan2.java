package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Titan2 {
	double x;
	double y;
	double radio;
	double angulo;
	Image image = Herramientas.cargarImagen("titan2.png");

	public Titan2(double x, double y, double radio, double angulo) {
		this.x = x;
		this.y = y;
		this.radio = radio;
		this.angulo = angulo;
	}

//	public void dibujar(Entorno e) {
//		e.dibujarCirculo(this.x, this.y, this.radio, Color.RED);
//	}

	public void dibujar2(Entorno e) {
		e.dibujarImagen(image, x, y, 0, 0.15);
	}

	public void moverTitan() {
		this.x -= Math.cos(this.angulo) * 1;
		this.y -= Math.sin(this.angulo) * 1;
	}

	public void direccionTitan(double x, double y) {
		double dx = this.x - x;
		double dy = this.y - y;
		this.angulo = Math.atan2(dy, dx);
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

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
