package PSP.UD00.introduccion.planificadores;

import java.util.LinkedList;
import java.util.Queue;
/**
 * La clase PlanificadorFCFS tiene dos funciones principales:
 * 	- Hace las veces de clase envoltorio, gestionará la cola de preparados.
 * 	- A través del método sirve, se ejecutan todos los procesos de la cola hasta finalizarla en orden FCFS.
 * A través de su método get, ofrecerá al microprocesador el procesos candidatos a ser ejecutado de su cola.
 * Al tratarse de un FCFS, el proceso candidatos será el que entró en primer lugar.
 * 
 * @author JESUS
 */
public class PlanificadorFCFS {
	/**
	 * Colección que almacena la cola de preparados.
	 */
    private static Queue<Proceso> queue;
    
    static{
        queue = new LinkedList<Proceso>();
    }
    
    /**
     * 
     * @return Proceso candidato a ser ejecutado: Al tratarse de un FCFS, el proceso candidato será el que entró en primer lugar.
     */
    public static Proceso get(){
    	// Obtiene la primera posición de la cola y elimina el proceso de la cola de preparados.
    	Proceso aux = queue.poll();
        long inicio, fin;
        // Si nos ha devuelto null, es que la cola de preparados está vacía.
        if (aux!=null){
            try {
                inicio = System.currentTimeMillis();
                System.out.println("Inicio del proceso " + aux.nombre + "||" + inicio);
                Thread.sleep(aux.duracion);
                fin = System.currentTimeMillis();
                System.out.println("Fin del proceso " + aux.nombre + "||" + fin);
                System.out.println("** Duración del hilo (" + aux.duracion +") " + aux.nombre + " ||" + (fin-inicio));
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("Planificador sin procesos.");
        }
        return aux;
    }
    
    /**
     * 
     * @param pi Proceso a insertar en la cola de preparados. Al tratarse de un cola se hará en último lugar.
     */
    public static void put(Proceso pi){
        queue.add(pi);
    }
    
    /**
     * Obtiene todo los procesos uno a uno hasta finlizar la cola. Es decir, llama al método get tantas veces como procesos 
     * hay en la cola de preparados.
     */
    public static void sirve(){
        while (get()!=null);
    }
}
