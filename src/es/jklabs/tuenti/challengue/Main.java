package es.jklabs.tuenti.challengue;

import es.jklabs.tuenti.challengue.desafio.Desafio1;
import es.jklabs.tuenti.challengue.service.FileUploader;

public class Main {

    public static void main(String[] args) {
        FileUploader.cargarFichero("testInput.txt");
		Desafio1.run();
    }
}
