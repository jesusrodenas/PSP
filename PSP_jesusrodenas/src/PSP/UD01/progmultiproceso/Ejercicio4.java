/**
 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.IOException;

/**
 * @author JESUS
 *
 */
public class Ejercicio4 {

	/**
	 * Crea una clase Java cuyo método main lance un comando que provoque errores y pinta por pantalla el valor devuelto por el error.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "ls --help";
		String comandoWindows = "CMD /C DIRRRR";
		String comando = comandoWindows;
		Process p = null;
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
