/**
 * 
 */
package PSP.UD01.examen.ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lanzo un proceso echo que pinte la ejecución de la variable.
 * @author JESUS
 *
 */
public class ProcesoEcho implements IProcesoJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Preparo el proceso de windows.
		List<String> lCmdWin = new ArrayList<String>();		
		lCmdWin.add("CMD");
		lCmdWin.add("/C");
		lCmdWin.add("echo");
		lCmdWin.add("%PATH%");
		
		/* Para linux sería
		 * 	List<String> lCmdLinux = new ArrayList<String>();	
		 *  lCmdLinux.add("/bin/bash");
		 *  lCmdLinux.add("-c");
		 *  lCmdLinux.add("echo $MI_NOMBRE");
		 */
		
		// Instancio el ejecutor de procesos.
		ProcessBuilder pb = new ProcessBuilder(lCmdWin);
		
		// Preparo el entorno para la ejecución de procesos java.
		pb.environment().put("CLASSPATH", ProcesoEcho.class.getClassLoader().getResource("").getPath());
		
		// Heredo la salida estandar de la clase en ejecución.
		pb.inheritIO();
		
		// Ejecuto el proceso.
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}