package PSP.UD01.recursos;

import java.io.IOException;

public class UD01Ej12ProcEscritorB {
	public static void main (String[] args) {
		try {
			escribeBs();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void escribeBs() throws IOException, InterruptedException{
		System.out.println("Comienzo a escribir b's");		
		for (int i=0; i<5; i++) {
			GestorFicheros.escribe('b');
		}
		System.out.println("Finalizo escribir b's");	
	}
}
