package PSP.UD00.flujos.salida.caracteres.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author JESUS
 *
 */
public class EjemploFileWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileWriter fw = null;
		String contenido = "Este es el contenido de mi fichero";
		
		try {
			fw = new FileWriter("prueba_ficheros.txt");
			for(char c : contenido.toCharArray())
				fw.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
