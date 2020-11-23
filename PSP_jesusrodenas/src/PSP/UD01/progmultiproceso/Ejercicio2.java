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
public class Ejercicio2 {

	/**
	 * Crea una clase Java cuyo método main lance un proceso que liste los ficheros del directorio actual y los pinte por pantalla.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "ls -help";
		String comandoWindows = "CMD /C DIR";
		
		String comando = comandoWindows;
		Process p = null;
		BufferedReader br = null; 
		
		try {
			p = rt.exec(comando);		
		
			InputStream is = p.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
