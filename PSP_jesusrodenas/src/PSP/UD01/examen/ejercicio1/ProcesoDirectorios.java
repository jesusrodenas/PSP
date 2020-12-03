/**
 * 
 */
package PSP.UD01.examen.ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PSP.UD00.recursos.Cadenas;

/** lanzará un proceso listando los archivos del directorio actual, generando un error, 
 * controlándolo, modificando una variable privada y pintándolo en un archivo llamado “log_ejercicio1.txt”.
 * 
 * @author JESUS
 *
 */
public class ProcesoDirectorios implements IProcesoJava {

	private static boolean ejecutadoConErrores;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Inicializao dos variables que necesitaré:
		// la primera me indicará si ha sido finalizado con errores el proceso.
		ejecutadoConErrores = false;
		// la segunda me permitirá actualizar la primera cuando recoja el valor de finalización del proceso.
		int codigoSalida = 0;
		
		// Preparo el comando para windows.
		List<String> lCommand = new ArrayList<String>();
		lCommand.add("CMD");
		lCommand.add("/C");
		lCommand.add("DIRR");
		
		/* Este sería para linux
		 * lCommand.add("ls");
		 * lCommand.add("srrrrrrrrrrrc");
		 */
		
		// Instancio el ejecutador de procesos
		ProcessBuilder pb = new ProcessBuilder(lCommand);
		
		// Defino una variable que encapsulará el proceso y me permitirá tanto esperar su ejecución como capturar su 
		// valor de finanización.
		Process p = null;
		
		// Redirijo el flujo de salida al archivo de log.
		File fErr = new File(Cadenas.getCadenaFichero("log_ejercicio1.txt"));			
		pb.redirectError(fErr);
		
		// Ahora puedo ejecutar el proceso.
		try {
			p = pb.start();
			
			// Espero su ejecución y obtendo el valor de finalización.
			p.waitFor();
			codigoSalida = p.exitValue();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Actualizao la variable boolean en función del valor de finalización.
		ejecutadoConErrores = (codigoSalida!=0);		
	}

}
