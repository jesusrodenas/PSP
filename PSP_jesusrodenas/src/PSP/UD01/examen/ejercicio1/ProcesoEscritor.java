/**
 * 
 */
package PSP.UD01.examen.ejercicio1;

import java.io.FileWriter;
import java.io.IOException;

import PSP.UD00.recursos.Cadenas;

/**
 * escribirá 5000 caracteres cualesquiera en un fichero alojado en
 * el raíz del proyecto (“salida_ejercicio3.txt”)
 * ****** Para la corrección se almacenará en nuestra carpeta de "prueba_ficheros". ****
 * 
 * @author JESUS
 *
 */
public class ProcesoEscritor implements IProcesoJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fw;
		try {
			fw = new FileWriter(Cadenas.getCadenaFichero("salida_ejercicio1.txt"));
			
			for (int i=1; i<=5000; i++) {
				fw.write('a');				
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
