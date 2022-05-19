package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Mikasa mikasa;
	private Suero suero;
	private Tiempo tiempo;
	private Image imageFondo;
	private Titan titan;
	private Disparo disparo;
	private Obstaculos obstaculos;

	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N - Apellido1 - Apellido2 -Apellido3 - V0.01",
				800, 600);
		this.mikasa = new Mikasa(400, 300, 40, 0);
		this.suero = new Suero(0, 0, 0);
		this.tiempo = new Tiempo(true, 0);
		this.titan = new Titan(300, 100, 120, 0);
		this.disparo = new Disparo(0, 0, 10, 5, 0);
		this.imageFondo = Herramientas.cargarImagen("FondoSeis.jpg");
		this.obstaculos = new Obstaculos(4);
		this.obstaculos.generarObs();

		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...

		if (tiempo.isInicia()) {
//			dibujar
			entorno.dibujarImagen(this.imageFondo, 400, 400, 0, 1.7);
//			mikasa.dibujar(entorno);
			mikasa.dibujar2(entorno);
//			titan.dibujar(entorno);

			titan.moverTitan();
			titan.direccionTitan(mikasa.getX(), mikasa.getY());
			
//			instrucciones
			if (entorno.estaPresionada('w'))
				mikasa.moverAdelante();

			if (entorno.estaPresionada('a'))
				mikasa.moverIzquierda();

			if (entorno.estaPresionada('s'))
				mikasa.moverAtras();

			if (entorno.estaPresionada('d'))
				mikasa.moverDerecha();

//			if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
//				disparo.dibujar(entorno);
//				disparo.moverBala();
//			}

			if (suero.colision(mikasa.getX(), mikasa.getY(), suero.getX(), suero.getY(), suero.getRadio())) {
				suero.setX(0);
				suero.setY(0);
				suero.setRadio(0);
			}

			if (tiempo.getContar() == 0.015 || (int) tiempo.getContar() == 19) {
				suero.setX(Math.random() * 800);
				suero.setY(Math.random() * 600);
				suero.setRadio(30);
			}

			mikasa.distancia(mikasa.getX(), mikasa.getY(), titan.getX(), titan.getY());

//			if (titan.colisiona(mikasa.getRadio(), titan.getRadio(), mikasa.getDistancia())
//					&& mikasa.getDistancia() <= 68) {
//				if (mikasa.getX() <= titan.getX() && mikasa.getY() <= titan.getY()) {
//					mikasa.setX(mikasa.getX() - 2);
//					mikasa.setY(mikasa.getY() - 2);
//				} else if (mikasa.getX() >= titan.getX() && mikasa.getY() >= titan.getY()) {
//					mikasa.setX(mikasa.getX() + 2);
//					mikasa.setY(mikasa.getY() + 2);
//				} else if (mikasa.getX() >= titan.getX() && mikasa.getY() <= titan.getY()) {
//					mikasa.setX(mikasa.getX() + 2);
//					mikasa.setY(mikasa.getY() - 2);
//				} else if (mikasa.getX() <= titan.getX() && mikasa.getY() >= titan.getY()) {
//					mikasa.setX(mikasa.getX() - 2);
//					mikasa.setY(mikasa.getY() + 2);
//				}
//			}



//			por cada obstaculo chequea la distancia entre el titan y el obs, si el metodo colisiona es true,
//			y la distancia entre los circulos es menor a 100, resta o suma en sus respectivos X e Y. del titan
			for (Obstaculos2 obs : this.obstaculos.getObstaculos2()) {
				obstaculos.distancia(obs.getX(), obs.getY(), titan.getX(), titan.getY());
				if (obstaculos.colisiona(obs.getRadio(), titan.getRadio(), obstaculos.getDistancia())
						&& obstaculos.getDistancia() <= 120) {
					if (titan.getX() <= obs.getX() && titan.getY() <= obs.getY()) {
						titan.setX(titan.getX() - 2);
						titan.setY(titan.getY() - 2);
						titan.direccionTitan(obs.getX(), obs.getY());
					} else if (titan.getX() >= obs.getX() && titan.getY() >= obs.getY()) {
						titan.setX(titan.getX() + 2);
						titan.setY(titan.getY() + 2);
						titan.direccionTitan(obs.getX(), obs.getY());
					} else if (titan.getX() >= obs.getX() && titan.getY() <= obs.getY()) {
						titan.setX(titan.getX() + 2);
						titan.setY(titan.getY() - 2);
						titan.direccionTitan(obs.getX(), obs.getY());
					} else if (titan.getX() <= obs.getX() && titan.getY() >= obs.getY()) {
						titan.setX(titan.getX() - 2);
						titan.setY(titan.getY() + 2);
						titan.direccionTitan(obs.getX(), obs.getY());
					}
				}
				obs.dibujar(entorno);
//				obs.dibujar2(entorno);

			}
			titan.dibujar2(entorno);
//			lo mismo pero con mikasa
			for (Obstaculos2 obs : this.obstaculos.getObstaculos2()) {
				obstaculos.distancia(obs.getX(), obs.getY(), mikasa.getX(), mikasa.getY());
				if (obstaculos.colisiona(obs.getRadio(), mikasa.getRadio(), obstaculos.getDistancia())
						&& obstaculos.getDistancia() <= 100) {
					if (mikasa.getX() <= obs.getX() && mikasa.getY() <= obs.getY()) {
						mikasa.setX(mikasa.getX() - 2);
						mikasa.setY(mikasa.getY() - 2);
					} else if (mikasa.getX() >= obs.getX() && mikasa.getY() >= obs.getY()) {
						mikasa.setX(mikasa.getX() + 2);
						mikasa.setY(mikasa.getY() + 2);
					} else if (mikasa.getX() >= obs.getX() && mikasa.getY() <= obs.getY()) {
						mikasa.setX(mikasa.getX() + 2);
						mikasa.setY(mikasa.getY() - 2);
					} else if (mikasa.getX() <= obs.getX() && mikasa.getY() >= obs.getY()) {
						mikasa.setX(mikasa.getX() - 2);
						mikasa.setY(mikasa.getY() + 2);
					}
				}
			}


			if (((int) tiempo.getContar() > 10 && (int) tiempo.getContar() < 18)
					|| ((int) tiempo.getContar() > 20 && (int) tiempo.getContar() < 28)) {
				suero.dibujar(entorno);
			}

//			controla el fin del juego
//			if ((int) tiempo.getContar() > 40) {
//				this.tiempo = new Tiempo(false, 0);
//			}

			tiempo.setContar(0.015);

//			imprime el tiempo
//			System.out.println(tiempo.getContar());
			// genera obstaculos

		} else {
			entorno.cambiarFont("Arial", 32, Color.WHITE);
			entorno.escribirTexto("GAME OVER", 300, 300);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
