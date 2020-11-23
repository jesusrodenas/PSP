/**
 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import PSP.UD00.recursos.Cadenas;

/**
 * @author JESUS
 *
 */
public class Ejercicio6 {

	/**
	 * Crea una clase Java cuyo método main lance un comando que provoque errores y genere un fichero con la descripción del error.
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "lsss -help";
		String comandoWindows = "CMD /C DIRRRR";
		String comando = comandoWindows;
		Process p = null;
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);	
			System.out.println("Consulte los fichero de logs para más información.");
			
			InputStream errStream = p.getErrorStream();
			br = new BufferedReader(new InputStreamReader(errStream));
			
			bw = new BufferedWriter(
					new FileWriter(
							Cadenas.getCadenaFichero("log_err_ejercicio6.txt")));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				bw.write(linea);
				bw.newLine();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
