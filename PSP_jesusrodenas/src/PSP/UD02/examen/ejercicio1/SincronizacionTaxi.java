/**
 * 
 */
package PSP.UD02.examen.ejercicio1;

/**
 * @author JESUS
 *
 */
public class SincronizacionTaxi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		
		Runnable javi = new Cliente ("Javier", 15, taxi);
		Runnable maria = new Cliente ("María", 8, taxi);
		Runnable antonio = new Cliente ("Antonio", 9, taxi);
		Runnable luisa = new Cliente ("Luisa", 10, taxi);
		
		Thread tJavi = new Thread(javi);
		Thread tMaria = new Thread(maria);
		Thread tAntonio = new Thread(antonio);
		Thread tLuisa = new Thread(luisa);
		
		tJavi.start();
		tMaria.start();
		tAntonio.start();
		tLuisa.start();	
	}

}
