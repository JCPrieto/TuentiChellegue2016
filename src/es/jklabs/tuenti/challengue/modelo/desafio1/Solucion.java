package es.jklabs.tuenti.challengue.modelo.desafio1;

/**
 * Created by juanky on 26/04/16.
 */
public class Solucion {
	private int numMesas;
	private Long sitios;

	public Solucion(int numMesas, Long sitios) {
		this.numMesas = numMesas;
		this.sitios = sitios;
	}

	public int getNumMesas() {
		return numMesas;
	}

	public void setNumMesas(int numMesas) {
		this.numMesas = numMesas;
	}

	public Long getSitios() {
		return sitios;
	}

	public void setSitios(Long sitios) {
		this.sitios = sitios;
	}
}
