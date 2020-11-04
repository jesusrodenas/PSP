package PSP.flujos.entrada.caracteres.buffered;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class EjemploBufferedWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedWriter bw = null;

		List<String> cadenas = Arrays.asList(new String[] { "Primera cadena",
				"Segunda cadena", "Tercera cadena", "Cuarta cadena." });

		try {
			bw = new BufferedWriter(new FileWriter("prueba_caracteres_buffered.txt"));
			for (String s : cadenas) {
				bw.write(s);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
