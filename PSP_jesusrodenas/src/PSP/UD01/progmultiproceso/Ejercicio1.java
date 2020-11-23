/**
 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.IOException;

/**
 * @author JESUS
 *
 */
public class Ejercicio1 {

	/**
	 * Crea una clase Java cuyo método main lance la aplicación de Firefox.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "firefox iescristobaldemonroy.es";
		String comandoWindows = "C:\\Program Files\\Mozilla Firefox\\firefox.exe iescristobaldemonroy.es";
		
		String comando = comandoWindows;
		
		try {
			rt.exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
