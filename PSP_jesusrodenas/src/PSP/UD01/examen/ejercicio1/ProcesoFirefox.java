/**
 * 
 */
package PSP.UD01.examen.ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que creará un proceso de apertura del navegador Firefox 
 * accediendo a una página cualquiera
 * 
 * @author JESUS
 *
 */
public class ProcesoFirefox implements IProcesoJava {
	
	public static void main(String[] args) {	
		List<String> comando = new ArrayList<String>();
		comando.add("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		comando.add("iescristobaldemonroy.es");
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
