/**
 * 
 */
package PSP.UD02.examen.ejercicio1;

/**
 * @author JESUS
 *
 */
public class Cliente implements Runnable{
	String nombreCliente;
	int numKmCarrera;	
	private Taxi taxi;
	
	Cliente(String nombreCliente, int numMetrosCarrera, Taxi taxi){
		this.nombreCliente = nombreCliente;
		this.numKmCarrera = numMetrosCarrera;
		this.taxi = taxi;
	}

	public void run() {
		taxi.inicioTrayecto(this.nombreCliente, this.numKmCarrera);
		taxi.finalizarTrayecto(this.nombreCliente);
	}
}
