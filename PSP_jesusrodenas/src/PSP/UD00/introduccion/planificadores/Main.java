/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSP.UD00.introduccion.planificadores;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author JESUS
 */
public class Main {   
	/**
	 * Este main llamará a los métoso del Planificador FCFS o del planificador STF en función lo que se desee.
	 * Para ello se comentan las líneas que no se quieran ejecutar.
	 * @param args
	 */
	public static void main(String[] args) {
		
		preparaMicroprocesadorFCFS();
		PlanificadorFCFS.sirve();
		
    	preparaMicroprocesadorSTF();
        PlanificadorSTF.sirve();    	
    } 
    
	/**
	 * Prepara el microprocesador para la ejecución del algoritmo FCFS.
	 * Inserta 5 procesos de duración aleatoria y los desordena. Seguidamente los inserta en la cola de preparados.
	 */
    public static void preparaMicroprocesadorFCFS(){
        ArrayList<Proceso> procesos = new ArrayList<Proceso>();
        
        for (int i=1; i<=5; i++){
        	Proceso pi = new Proceso("P_" + i, ((int) Math.floor(Math.random()*4+1)) * 1000);
            procesos.add(pi);
        }
        
        Collections.shuffle(procesos);
        
        for(Proceso p : procesos){
             PlanificadorFCFS.put(p);               
        } 
    }
    
    /**
     * Prepara el microprocesador para la ejecución del algoritmo STF.
     * Inserta 5 procesos de duración aleatoria y lo ordena en función de la duración de su ejecución.
     */
    private static void preparaMicroprocesadorSTF () {
		for (int i = 1; i <= 5; i++) {
			Proceso pi = new Proceso( "p" + i, ((int) Math.floor(Math.random()*4+1)) * 1000 );
			PlanificadorSTF.put(pi);
		}
		
		Collections.sort(PlanificadorSTF.procesos, new Comparator<Proceso>() {
			@Override
			public int compare(Proceso p1, Proceso p2) {
				return p1.duracion - p2.duracion;
			} });
	}
}
