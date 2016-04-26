package es.jklabs.tuenti.challengue.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by juanky on 26/04/16.
 */
public class FileUploader {
	private static final Logger LOG = Logger.getLogger(FileUploader.class.getName());
	private static List<String> lineas;

	public static void cargarFichero(String fileName) {
		try {
			FileReader fr = new FileReader((new File(fileName)));
			BufferedReader br = new BufferedReader(fr);
			lineas = new ArrayList<String>();
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
		} catch (FileNotFoundException e) {
			LOG.log(Level.SEVERE, "Archivo no encontrado", e);
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Lectura del documento", e);
		}
	}

	public static List<String> getLineas() {
		return lineas;
	}
}
