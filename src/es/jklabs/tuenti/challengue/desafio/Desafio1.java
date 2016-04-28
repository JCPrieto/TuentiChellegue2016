package es.jklabs.tuenti.challengue.desafio;

import es.jklabs.tuenti.challengue.service.FileUploader;
import es.jklabs.tuenti.challengue.service.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by juanky on 26/04/16.
 */
public class Desafio1 {
	private static Logger LOG = Logger.getLogger(Desafio1.class.getName());

	public static void run() {
		Integer numPruebas = Integer.valueOf(FileUploader.getLineas().get(0));
		List<Long> soluciones = new ArrayList<Long>();
		for (int i = 1; i <= numPruebas; i++) {
				Long comensales = Long.valueOf(FileUploader.getLineas().get(i));
			Long solucion;
			if (comensales == 0L) {
				solucion = 0L;
			} else if (comensales < 4L) {
				solucion = 1L;
			} else {
				if ((comensales - 2) % 2 == 0) {
					solucion = (comensales - 2) / 2;
				} else {
					solucion = (comensales - 1) / 2;
				}
			}
			soluciones.add(solucion);
		}
		try {
			FileWriter.escribir(soluciones, Desafio1.class.getSimpleName());
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Escribir solucion", e);
		}
	}
}
