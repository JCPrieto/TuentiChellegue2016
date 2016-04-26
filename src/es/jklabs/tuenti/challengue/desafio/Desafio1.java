package es.jklabs.tuenti.challengue.desafio;

import es.jklabs.tuenti.challengue.enumerados.desafio1.Posicion;
import es.jklabs.tuenti.challengue.modelo.desafio1.Estructura;
import es.jklabs.tuenti.challengue.modelo.desafio1.Solucion;
import es.jklabs.tuenti.challengue.service.FileUploader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by juanky on 26/04/16.
 */
public class Desafio1 {
	private static Map<Long, Integer> mapaSoluciones;

	public static void run() {
		mapaSoluciones = new HashMap<>();
		for (String linea : FileUploader.getLineas()) {
			Long comensales = Long.valueOf(linea);
			Integer solucion = mapaSoluciones.get(comensales);
			if (solucion == null) {
				Solucion sol = calcular(comensales, new Estructura(), Posicion.NORTE);
				mapaSoluciones.put(comensales,sol.getNumMesas());
			}
		}
	}

	private static Solucion calcular(Long comensales, Estructura estructura, Posicion posicion) {
		estructura.addMesa(posicion);
		Long sitios = estructura.getNumSitios();
		Solucion solucion;
		if (sitios > comensales) {
			solucion = new Solucion(estructura.getNumMesas(), sitios);
		} else {
			Solucion solucionNorte = calcular(comensales, estructura, Posicion.NORTE);
			Solucion solucionEste = calcular(comensales, estructura, Posicion.ESTE);
			Solucion solucionSur = calcular(comensales, estructura, Posicion.SUR);
			Solucion solucionOeste = calcular(comensales, estructura, Posicion.OESTE);
			if (solucionNorte.getNumMesas() < solucionEste.getNumMesas()
					&& solucionNorte.getNumMesas() < solucionSur.getNumMesas()
					&& solucionNorte.getNumMesas() < solucionOeste.getNumMesas()) {
				solucion = solucionNorte;
			} else if (solucionEste.getNumMesas() < solucionSur.getNumMesas()
					&& solucionEste.getNumMesas() < solucionOeste.getNumMesas()) {
				solucion = solucionEste;
			} else if (solucionSur.getNumMesas() < solucionOeste.getNumMesas()) {
				solucion = solucionSur;
			} else {
				solucion = solucionOeste;
			}
			Integer posible = mapaSoluciones.get(solucion.getSitios());
			if (posible != null && solucion.getNumMesas()<posible) {
				mapaSoluciones.put(solucion.getSitios(), solucion.getNumMesas());
			} else if (posible == null) {
				mapaSoluciones.put(solucion.getSitios(), solucion.getNumMesas());
			}
		}
		estructura.quitarMesa(posicion);
		return solucion;
	}
}
