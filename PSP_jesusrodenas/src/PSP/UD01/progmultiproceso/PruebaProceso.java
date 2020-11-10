package PSP.UD01.progmultiproceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import PSP.UD00.recursos.Cadenas;

public class PruebaProceso {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comando = "ls -help";

		Process p = null;
		try {
			p = rt.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(Cadenas.getCadenaFichero("salida_comando_" + comando)));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				bw.write(linea);
				bw.newLine();
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en " + comando);
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