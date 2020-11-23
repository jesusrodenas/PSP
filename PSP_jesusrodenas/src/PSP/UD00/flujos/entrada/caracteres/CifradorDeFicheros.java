package PSP.UD00.flujos.entrada.caracteres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author JESUS
 *
 */
public class CifradorDeFicheros {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader("pruebas_ficheros/fichero_a_cifrar.txt"));
			bw = new BufferedWriter(new FileWriter("pruebas_ficheros/fichero_cifrado.txt"));
			
			// br = new BufferedReader(new FileReader("pruebas_ficheros/fichero_cifrado.txt"));
			// bw = new BufferedWriter(new FileWriter("pruebas_ficheros/fichero_descifrado.txt"));

			String leido = null;
			
			while ((leido = br.readLine())!=null) {
				bw.write(Codificador.codifica(leido));
			}
			
			System.out.println("Ha finalizado el cifrado copia del fichero.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}
