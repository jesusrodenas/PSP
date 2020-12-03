/**
 * 
 */
package PSP.UD01.examen.ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * El main de la clase Ejercicio1 lanzará todos estos procesos recorriendo una colección de 
 * IProcesoJava y usando el cálculo automático de nombre canónico y ruta de clases, respectivamente:
 * 
 * - nombre_objeto.getClass().getCanonicalName();
 * - Ejercicio1.class.getClassLoader().getResource("").getPath();
 * 
 * @author JESUS
 *
 */
public class Ejercicio1 {
	public static void main(String[] args) {
		List<IProcesoJava> procesos = new ArrayList<IProcesoJava>();
		
		// Añado cada uno de los procesos.
		procesos.add(new ProcesoFirefox());
		procesos.add(new ProcesoEscritor());
		procesos.add(new ProcesoEcho());
		procesos.add(new ProcesoDirectorios());
		
		// Creo lista de strings que voy a reutilizar.
		List<String> lCommand = new ArrayList<String>();
		
		for (IProcesoJava p : procesos) {
			// limpio el comando anterior.
			lCommand.clear();
			
			// preparo mi comando para lanzar una clase java.
			lCommand.add("java");
			
			// Le paso como parámetro el qualified name del objeto.
			lCommand.add(p.getClass().getCanonicalName());
			
			// Instancio el ejecutador de comandos.
			ProcessBuilder pb = new ProcessBuilder(lCommand);
			
			// Preparo el classpath con la ubicación de los binarios del proyecto.
			pb.environment().put("CLASSPATH", Ejercicio1.class.getClassLoader().getResource("").getPath());
			
			// Heredo la salida estandar del proceso actual (Ejecicio1) para poder mostrar por pantalla cuando 
			// se requiera el valor de la variable PATH.
			pb.inheritIO();
			
			// Ya puedo lanzar el proceso objeto de la iteración en curso.
			try {
				pb.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
