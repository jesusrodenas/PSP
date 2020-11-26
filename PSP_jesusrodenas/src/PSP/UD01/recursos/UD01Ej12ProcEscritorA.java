package PSP.UD01.recursos;

import java.io.IOException;

public class UD01Ej12ProcEscritorA {

	public static void main(String[] args) {
		try {
			escribeAes();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void escribeAes() throws IOException, InterruptedException{
		System.out.println("Comienzo a escribir a's");
		for (int i=0; i<5; i++) {
			GestorFicheros.escribe('a');
		}
		System.out.println("Finalizo escribir a's");		
	}
}
