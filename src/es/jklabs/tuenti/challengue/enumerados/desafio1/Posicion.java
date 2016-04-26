package es.jklabs.tuenti.challengue.enumerados.desafio1;

/**
 * Created by juanky on 26/04/16.
 */
public enum  Posicion {
	NORTE(0,-1), ESTE(1,0), SUR(0,1), OESTE(-1,0);

	private int ejeX;
	private int ejeY;

	Posicion(int x, int y) {
		ejeX = x;
		ejeY = y;
	}

	public int getEjeX() {
		return this.ejeX;
	}

	public int getEjeY() {
		return ejeY;
	}
}
