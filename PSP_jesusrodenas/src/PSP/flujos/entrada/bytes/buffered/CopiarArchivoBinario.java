package PSP.flujos.entrada.bytes.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author JESUS
 *
 */
public class CopiarArchivoBinario {

	public static void main(String[] args) {
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		// Vamos a definir bloques de 16KB
		final int TAM = 1024 * 16;

		try {
			bin = new BufferedInputStream(new FileInputStream("imagenes/original.png"));
			bout = new BufferedOutputStream(new FileOutputStream("imagenes/copia.jpg"));
			
			int cantidadBytesleidos = 0;
			byte[] buffer = new byte[TAM];
			int i = 1;

			while ((cantidadBytesleidos = bin.read(buffer, 0, TAM)) != -1) {
				bout.write(buffer, 0, cantidadBytesleidos);
				System.out.println("Leidos " + cantidadBytesleidos + " Bytes en la iteración " + i++ + "-ésima.");				
			}
			
			System.out.println("Ha finalizado la copia del fichero.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bin != null)
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bout != null)
				try {
					bout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
