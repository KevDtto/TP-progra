package juego;

public class Obstaculos {
	public Obstaculos2[] obstaculos2;
	private double distancia;

	public Obstaculos(int tamanio) {
		this.obstaculos2 = new Obstaculos2[tamanio];
	}

	public void generarObs() {
		if (this.obstaculos2[0] == null) {
			this.obstaculos2[0] = new Obstaculos2(220, 200, 120);
		}
		if (this.obstaculos2[1] == null) {
			this.obstaculos2[1] = new Obstaculos2(220, 450, 120);
		}
		if (this.obstaculos2[2] == null) {
			this.obstaculos2[2] = new Obstaculos2(560, 200, 120);
		}
		if (this.obstaculos2[3] == null) {
			this.obstaculos2[3] = new Obstaculos2(560, 450, 120);
		}
//		if(this.obstaculos2[4] == null){
//			this.obstaculos2[4] = new Obstaculos2(700, 500, 140);
//		}

	}

	public boolean colisiona(double radio1, double radio2, double dist) {
		return (radio1 + radio2) > dist;
	}

	public void distancia(double x1, double y1, double x2, double y2) {
		this.distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	// getters and setters
	public Obstaculos2[] getObstaculos2() {
		return obstaculos2;
	}

	public void setObstaculos2(Obstaculos2[] obstaculos2) {
		this.obstaculos2 = obstaculos2;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

}
