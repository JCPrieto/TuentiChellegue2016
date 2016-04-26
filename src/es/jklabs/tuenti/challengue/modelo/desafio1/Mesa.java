package es.jklabs.tuenti.challengue.modelo.desafio1;

/**
 * Created by juanky on 26/04/16.
 */
public class Mesa {
	private int x;
	private int y;
	private Mesa norte;
	private Mesa sur;
	private Mesa este;
	private Mesa oeste;

	public Mesa(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setNorte(Mesa norte) {
		this.norte = norte;
	}

	public Mesa getNorte() {
		return norte;
	}

	public void setSur(Mesa sur) {
		this.sur = sur;
	}

	public Mesa getSur() {
		return sur;
	}

	public void setEste(Mesa este) {
		this.este = este;
	}

	public Mesa getEste() {
		return este;
	}

	public void setOeste(Mesa oeste) {
		this.oeste = oeste;
	}

	public Mesa getOeste() {
		return oeste;
	}
}
