package PSP.UD00.introduccion.planificadores;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase PlanificadorSTF tiene dos funciones principales:
 * 	- Hace las veces de clase envoltorio, gestionará la cola de preparados.
 * 	- A través del método sirve, se ejecutan todos los procesos de la cola hasta finalizarla en orden STF.
 * A través de su método get, ofrecerá al microprocesador el procesos candidatos a ser ejecutado de su cola.
 * Al tratarse de un STF, el proceso candidato será el de menor tiempo total de ejecución.
 * 
 * @author JESUS
 */
public class PlanificadorSTF {
	/**
	 * Colección que almacena la cola de preparados.
	 */
	public static List<Proceso> procesos;
	
	static {
		procesos = new ArrayList<Proceso>();
	}

    /**
     * 
     * @return Proceso candidato a ser ejecutado: Al tratarse de un STF, el proceso candidato será el de menor tiempo total de ejecución.
     */
	public static Proceso get() {
		long inicio, fin;
		Proceso p = null;
		
		try{
			p = procesos.get(0);
			procesos.remove(p);
			inicio = System.currentTimeMillis();
			System.out.println("Hora de inicio del proceso " + p.nombre + ": " + inicio + "." + p.duracion + ".");
			Thread.sleep(p.duracion);
			fin = System.currentTimeMillis();
			System.out.println("Hora de fin del proceso " + p.nombre + ": " + fin + ".");
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return p;
	}
	
    /**
     * 
     * @param pi Proceso a insertar en la cola de preparados. Al tratarse de un cola se hará en último lugar.
     */
	public static void put(Proceso p) {
		procesos.add(p);
	}
	
    /**
     * Obtiene todo los procesos uno a uno hasta finlizar la cola. Es decir, llama al método get tantas veces como procesos 
     * hay en la cola de preparados.
     * Como se eliminan de la cola de preparados a medida que se sirven, controlamos la finalización del bucle con el tamaño del 
     * conjunto de procesos preparados.
     */
	public static void sirve() {
		
		while (procesos.size()>0) {
			get();
		}
		
		System.out.println("Planificador sin procesos.");
	}
}
