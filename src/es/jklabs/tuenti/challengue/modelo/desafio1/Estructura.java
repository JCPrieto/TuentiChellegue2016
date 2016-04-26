package es.jklabs.tuenti.challengue.modelo.desafio1;

import es.jklabs.tuenti.challengue.enumerados.desafio1.Posicion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanky on 26/04/16.
 */
public class Estructura {
	private Mesa referencia;
	private List<Mesa> mesas;
	private int numMesas;

	public Estructura(){
		numMesas = 0;
		mesas = new ArrayList<Mesa>();
	}

	public void addMesa(Posicion posicion) {
		if (referencia == null) {
			referencia = new Mesa(1, 1);
			mesas.add(referencia);
		} else {
			Mesa nueva = new Mesa(referencia.getX()+posicion.getEjeX(), referencia.getY()+posicion.getEjeY());
			if (posicion.equals(Posicion.NORTE)) {
				referencia.setNorte(nueva);
				nueva.setSur(referencia);
			} else if (posicion.equals(Posicion.ESTE)) {
				referencia.setEste(nueva);
				nueva.setOeste(referencia);
			} else if (posicion.equals(Posicion.SUR)) {
				referencia.setSur(nueva);
				nueva.setNorte(referencia);
			} else if (posicion.equals(Posicion.OESTE)) {
				referencia.setOeste(nueva);
				nueva.setEste(referencia);
			}
			mesas.add(nueva);
			referencia = nueva;
		}
		numMesas++;
	}

	public Long getNumSitios() {
		Long num = 0L;
		for (Mesa mesa : mesas) {
			if (mesa.getNorte() == null) {
				num++;
			}
			if (mesa.getEste() == null) {
				num++;
			}
			if (mesa.getSur() == null) {
				num++;
			}
			if (mesa.getOeste() == null) {
				num++;
			}
		}
		return num;
	}

	public int getNumMesas() {
		return numMesas;
	}

	public void setNumMesas(int numMesas) {
		this.numMesas = numMesas;
	}

	public void quitarMesa(Posicion posicion) {
		if (mesas.size() > 1) {
			Mesa ultima = mesas.get(mesas.size()-1);
			mesas.remove(ultima);
			ultima = mesas.get(mesas.size()-1);
			if (posicion.equals(Posicion.NORTE)) {
				ultima.setNorte(null);
			} else if (posicion.equals(Posicion.ESTE)) {
				ultima.setEste(null);
			} else if (posicion.equals(Posicion.SUR)) {
				ultima.setSur(null);
			} else if (posicion.equals(Posicion.OESTE)) {
				ultima.setOeste(null);
			}
			referencia = ultima;
			numMesas--;
		}
	}
}
