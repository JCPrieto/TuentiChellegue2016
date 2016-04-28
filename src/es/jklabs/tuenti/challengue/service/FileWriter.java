package es.jklabs.tuenti.challengue.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by juanky on 28/04/16.
 */
public class FileWriter {
	public static void escribir(List<Long> soluciones, String name) throws IOException {
		File f = new File("soluciones/Solucion " + name + ".txt");
		f.getParentFile().mkdirs();
		java.io.FileWriter fr = new java.io.FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fr);
		int count = 1;
		for (Long solucion : soluciones) {
			bw.write("Case #" + count++ + ": " + solucion);
			bw.newLine();
		}
		bw.close();
		fr.close();
	}
}
