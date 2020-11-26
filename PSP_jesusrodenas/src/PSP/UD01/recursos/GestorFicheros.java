package PSP.UD01.recursos;

import java.io.FileWriter;
import java.io.IOException;

import PSP.UD00.recursos.Cadenas;

public class GestorFicheros {
	public static void escribe(char letra) throws IOException, InterruptedException{
		FileWriter fw = new FileWriter(Cadenas.getCadenaFichero("ejercicio12.txt"), true);
		fw.write(letra);
		Thread.sleep(500);
		fw.close();
	}
}
