package PSP.UD01.examen.ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el algoritmo planificador RR con un quantum representado en una variable estática.
 * @author JESUS
 *
 */
public class PlanificadorRR {
	
	/**
	 * Cola de procesos preparados esperando a ocupar el micro y su instanciación.
	 */
	public static List<Proceso> preparados;
	
	static {
		preparados = new ArrayList<Proceso>();
	}
	
	/**
	 * Variable para almacenar el quantum del algoritmo.
	 */
	public static int quantum;
	
	/**
	 * Variable que creamos para poder conocer en que momento dentro de un quantum nos encontramos.
	 */
	public static int cicloDelQuantum;
	
	public static void planifica() {
		/**
		 * Con este if conseguimos que la planificación únicamente se produzca cuando finaliza el instante en el que 
		 * el ciclo del quantum y el quantum sean iguales.
		 */
		if ((cicloDelQuantum+1)%quantum==0) {
			// Apartado 1
			// Consiste en implementar la lógica que aplica el planificador en cuanto a la gestión de la cola y ocupación del micro.
			// Si existen procesos en la cola de preparados, realizará planificación
			if (preparados.size()>0) {
				
				// Obtiene el proceso que está en el micro
				Proceso procSaliente = Microprocesador.getProcesoEnEjecucion();
				
				// Otorga la posesión del microprocesador al proceso que llevaba más tiempo en la cola.
				Microprocesador.setProcesoEnEjecucion(preparados.get(0));
				
				// Actualiza la cola de preparados elimando el proceso que ha pasado a ocupar el microprocesador.
				preparados.remove(0);
	
				// Si efectivamente se ha quitado proceso del micro (en el primer instante el micro está ocioso, 
				// es decir, sin proceso en ejecución
				// Y
				// A ese proceso que hemos quitado del micro todavía le resta tiempo de ejecución.
				// Entonces lo volvemos a colocar en la cola de preparados, última posición ya que ha sido el último en llegar.
				if (procSaliente!=null && procSaliente.tiempoRestante()>0) {
					preparados.add(procSaliente);
				}
			}	
		}
	}
	
	/**
	 * Este método comprobará el tiempo restante del proceso en ejecución. Si un proceso ha llegado a su finalización, 
	 * debe forzar una planificación aunque no se haya finalizado el quantum: el micro nunca puede estar ocioso.
	 * Para conseguir este efecto, reinicializamos el quantum.
	 * 
	 */
	public static void verificaEstado() {
		// Apartado 2. 
		// Control de la finalización de un proceso y reinicialización del quantum en caso de que sea necesario.
		// Si el proceso en ejecución ha finalizado su ejecución, debe forzarse una nueva planificación por parte del algoritmo, 
		// independientemente que llevara menos ciclos que el indicado en quantum ya que el micro no puede quedarse ocioso esperando
		// a la finalización del quantum.
		if (Microprocesador.getProcesoEnEjecucion().tiempoRestante() == 0) {
			cicloDelQuantum = 1;
		}else {
			// Si el ciclo del quantum iguala al quantum, es momento de volver a empezar.
			if (cicloDelQuantum==quantum) {
				cicloDelQuantum = 1;
			}else {
				// En caso contrario, avanzamos un ciclo en el quantum y continua la ejecución.
				cicloDelQuantum++;
			}
		}
	}
	
	/**
	 * Este método añadirá a nuestra cola de preparados los procesos que corresponden.
	 * 
	 * @param instanteTiempo: Instante en el que se encuentra el reloj (ciclo de CPU)
	 */
	public static void entradas (int instanteTiempo){
		// Apartado 3.
		// Método que añadirá a nuestra cola de preparados los procesos que correspondan
		switch (instanteTiempo) {
			case 1:
				preparados.add(new Proceso(5, "D"));
				break;
			case 2:
				preparados.add(new Proceso(4, "C"));
				break;
			case 3:
				preparados.add(new Proceso(5, "A"));
				break;
			case 4:
				preparados.add(new Proceso(2, "E"));
				break;
			case 6:
				preparados.add(new Proceso(1, "B"));
				break;			
		}
	}
}
