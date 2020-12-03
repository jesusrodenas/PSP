/**
 * 
 */
package PSP.UD01.examen.ejercicio2;

/**
 * Clase que simulará el microprocesador (que supondremos de un único núcleo) de nuestro equipo.
 * 
 * @author JESUS
 *
 */
public class Microprocesador {
	
	// Variable que representará al proceso que está ocupando el micro.
	private static Proceso procesoEnEjecucion;
	
	/** Getter del proceso que está ocupando el micro
	 * @return the procesoEnEjecucion
	 */
	public static Proceso getProcesoEnEjecucion() {
		return procesoEnEjecucion;
	}

	/** setter del proceso que está ocupando el micro.
	 * @param procesoEnEjecucion the procesoEnEjecucion to set
	 */
	public static void setProcesoEnEjecucion(Proceso procesoEnEjecucion) {
		Microprocesador.procesoEnEjecucion = procesoEnEjecucion;
	}
	
	/**
	 * Esta clase realizará ejecutará un ciclo del proceso que se encuentra activo y verifica el estado del mismo.
	 */
	public static void ejecutaCiclo() {
		// Apartado 1
		// Ejecuta un ciclo del proceso que se encuentra activo.
		procesoEnEjecucion.ejecutoCiclo();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		PlanificadorRR.verificaEstado();
	}

	private Microprocesador() {		
	}
}