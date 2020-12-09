package PSP.UD01.progmultiproceso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import PSP.UD01.recursos.UD01Ej12ProcEscritorA;
import PSP.UD01.recursos.UD01Ej12ProcEscritorB;

public class Ejercicio12 {

	public static void main(String[] args) {
		
		String procesoA = UD01Ej12ProcEscritorA.class.getCanonicalName();
		// PSP.UD01.recursos.UD01Ej12ProcEscritorA
		String procesoB = UD01Ej12ProcEscritorB.class.getCanonicalName();
		// PSP.UD01.recursos.UD01Ej12ProcEscritorB
		
		String classpath = Ejercicio12.class.getClassLoader().getResource("").getPath();
		// "/home/jesus/Documentos/git/PSP/PSP_jesusrodenas/bin";
		
		List<String> lCommandA = new ArrayList<String>();
		lCommandA.add("java");
		lCommandA.add(procesoA);
		
		List<String> lCommandB = new ArrayList<String>();
		lCommandB.add("java");
		lCommandB.add(procesoB);
		
		ProcessBuilder pbA = new ProcessBuilder(lCommandA);
		ProcessBuilder pbB = new ProcessBuilder(lCommandB);
				
		pbA.environment().put("CLASSPATH", classpath);
		pbB.environment().put("CLASSPATH", classpath);
		
		pbA.inheritIO();
		pbB.inheritIO();
		
		try {
			pbA.start();
			pbB.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
