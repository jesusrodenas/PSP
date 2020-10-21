/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSP.planificador;

import java.util.ArrayList;

import java.util.Collections;

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
    	// prueba de cambio
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
	}
}
