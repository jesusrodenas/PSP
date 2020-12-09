package PSP.UD01.recursos;

public class UD01Ej12ProcEscritorB {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; (i < 50 && !GestorFicheros.ocupado); i++) {
			GestorFicheros.ocupado = true;
			System.out.println(i);
			Thread.sleep(50);
			GestorFicheros.ocupado = false;		
		}
	}
}
