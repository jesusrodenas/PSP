package PSP.UD01.examen.ejercicio2;

/**
 * Clase que supondrá una abstracción del tiempo que sucede entre el inicio 
 * de nuestro problema y la finalización del mismo.
 * 
 * @author JESUS
 *
 */
public class ContadorTiempo extends Thread {

	/**
	 * Variable que nos permitirá simular el paso en segundos.
	 */
	private static int tiempo;

	/**
	 * Constructor privado e implementación del patrón singleton para el ContadorTiempo.
	 * @return ct El único ContadorTiempo de nuestro problema.
	 */
	private static ContadorTiempo ct;
	private ContadorTiempo(int t) {
		tiempo = t;
	}
	public static ContadorTiempo getInstance() {
		if (ct==null) {
			ct = new ContadorTiempo(tiempo);
		}
		return ct;
	}
	
	/**
	 * Método que activa el reloj.
	 */
	@Override
	public synchronized void start() {
		tiempo = 1;
		PlanificadorRR.cicloDelQuantum = 1;
		
		while (true) {		
			PlanificadorRR.entradas(tiempo);
			// Apartado 1.
			// Ejecutará la planificación del algoritmo planificador.
			PlanificadorRR.planifica();		
			
			// Apartado 2.
			// Simula una ejecución del microprocesador.			
			Microprocesador.ejecutaCiclo();
			
			/**
			 * Pinta por pantalla la situación actual.
			 */
			pinta();				
			
			/**
			 * En el momento que no existan procesos en la cola de preparados 
			 * y el proceso en ejecución tenga tiempo restante cero, 
			 * romper la espera activa (while(true)) 
			 */
			// Apartado 3.
			// Condición del if.
			// Bajo las dos condiciones que debe pararse el reloj por considerarse finalizada toda la planificaión son:
			// - No queda ningun proceso en la cola de preparados por ocupar el micro.
			// - El proceso que está en posesión del micro ha finalizado su ejecución, es decir, no le resta tiempo de ejecución.
			if (PlanificadorRR.preparados.size()==0 && Microprocesador.getProcesoEnEjecucion().tiempoRestante()==0) {
				break;
			}				
			tiempo++;				

		}
	}
	
	/** 
	 * Pinta por pantalla la situación actual:
	 * 	- Instante de tiempo.
	 *  - Proceso en ejecución.
	 *  - Cola de preprados.
	 */
	public static void pinta() {
		StringBuilder mensaje = new StringBuilder("");
		mensaje.append("Instante:" + tiempo  + ". ");
		mensaje.append("Proceso en Ejecución: " + Microprocesador.getProcesoEnEjecucion() + ". ");
		mensaje.append("Cola de preparados: " + PlanificadorRR.preparados);
		
		System.out.println(mensaje);		
	}
}
