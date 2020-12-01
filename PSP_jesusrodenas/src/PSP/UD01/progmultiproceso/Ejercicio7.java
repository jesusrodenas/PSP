/**

 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.IOException;

/**
 * @author JESUS
 *
 */
public class Ejercicio7 {

	/**
	 * Crea una clase Java cuyo método main lance la aplicación de Firefox haciendo uso de ProcessBuilder y pasándole una URL como parámetro.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "firefox";
		String comandoWindows = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		
		String comando = comandoWindows;
		
		try {
			ProcessBuilder pb = new ProcessBuilder(comando, "iescristobaldemonroy.es");
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
