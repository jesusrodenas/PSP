/**
 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author JESUS
 *
 */
public class Ejercicio8 {

	/**
	 * 1) Crea una clase Java cuyo método main:
	 * 		1.1)Cree un objeto ProcessBuilder a través del cual consultar las variables de entorno.
	 * 		1.1) Cree un segundo objeto ProcessBuilder para lanzar un proceso que muestre la ayuda del sistema para el comando ls (ls --help). Antes de lanzarlo, deben listarse los argumentos de la llamada.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ProcessBuilder pEnv = new ProcessBuilder();
		Map<String, String> vbles = pEnv.environment();
		System.out.println(vbles);
		
		List<String> lCommand = new ArrayList<String>();
		lCommand.add("CMD");
		lCommand.add("/C");
		lCommand.add("DIRR");
		
		ProcessBuilder pb = new ProcessBuilder(lCommand);
		System.out.println(pb.command());
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
