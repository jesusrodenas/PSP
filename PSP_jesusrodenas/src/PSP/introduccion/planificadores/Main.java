/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSP.introduccion.planificadores;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author JESUS
 */
public class Main {   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*
       preparaMicroprocesador();
       PlanificadorFCFS.sirve();
       */
    	//Cambio 
    	preparaMicroprocesadorSTF();
        PlanificadorSTF.sirve();
    } 
    
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
