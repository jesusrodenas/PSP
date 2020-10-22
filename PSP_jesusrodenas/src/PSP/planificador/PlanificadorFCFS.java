/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSP.planificador;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author JESUS
 */
public class PlanificadorFCFS {
    private static Queue<Proceso> queue;
    
    static{
        queue = new LinkedList<Proceso>();
    }
    
    // Método que toma un proceso del conjunto de procesos a servir.
    public static Proceso get(){
    	Proceso aux = queue.poll();
        long inicio, fin;
        if (aux!=null){
            try {
                inicio = System.currentTimeMillis();
                System.out.println("Inicio del hilo " + aux.nombre + "||" + inicio);
                Thread.sleep(aux.duracion);
                fin = System.currentTimeMillis();
                System.out.println("Fin del hilo " + aux.nombre + "||" + fin);
                System.out.println("** Duraci�n del hilo (" + aux.duracion +") " + aux.nombre + " ||" + (fin-inicio));
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("Planificador sin procesos.");
        }
        return aux;
    }
    
    public static void put(Proceso pi){
        queue.add(pi);
    }
    
    public static void sirve(){
        while (get()!=null);
    }
}
