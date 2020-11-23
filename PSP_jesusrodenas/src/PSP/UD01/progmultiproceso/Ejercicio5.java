/**
 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author JESUS
 *
 */
public class Ejercicio5 {

	/**  
	 * Crea una clase Java cuyo método main lance un comando que provoque errores y pinte por pantalla la descripción del error.
	 * 
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
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);	
			System.out.println("La salida ha sido: ");
			
			InputStream errStream = p.getErrorStream();
			br = new BufferedReader(new InputStreamReader(errStream));
			
			String linea = "";
			while ((linea = br.readLine()) !=null){
				System.out.println(linea);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
