/**
 * 
 */
package PSP.UD01.progmultiproceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import PSP.UD00.recursos.Cadenas;

/**
 * @author JESUS
 *
 */
public class Ejercicio3 {

	/**
	 * Crea una clase Java cuyo método main lance un proceso que liste los ficheros del directorio actual y los guarde en un fichero de texto
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
		BufferedWriter bw = null;
		
		try {
			p = rt.exec(comando);		
		
			InputStream is = p.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			
			bw = new BufferedWriter(
					new FileWriter(
							Cadenas.getCadenaFichero("salida_comando_" + comando.replace('/',  '_'))));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				bw.write(linea);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
