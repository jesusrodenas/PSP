/**
 * 
 */
package PSP.UD02.examen.ejercicio1;

/**
 * @author JESUS
 *
 */
public class Taxi {
	private double precioKmCarrera = 2.5;
	private double importeCarrera = 0;
	private int numKmCarrera = 0;
	private boolean disponible = true;
	
	
	public synchronized void inicioTrayecto(String nombreCliente, int numKm) {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		disponible = false;
		System.out.println(nombreCliente + " toma el taxi.");		
		numKmCarrera = numKm;
		importeCarrera = 0;		
	}
	
	
	public synchronized void finalizarTrayecto(String nombreCliente) {
		importeCarrera = numKmCarrera * precioKmCarrera;
		System.out.println("Finaliza el trayecto de: " + nombreCliente + " (" + numKmCarrera + " kms): " + importeCarrera + " euros.");
		disponible = true;
		notifyAll();
	}
}
