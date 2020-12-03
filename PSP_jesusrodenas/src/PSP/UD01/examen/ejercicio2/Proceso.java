package PSP.UD01.examen.ejercicio2;

/**
 * Clase que representará la información de los procesos que tenemos en nuestro sistema.
 * @author JESUS
 *
 */
public class Proceso {
	
	/**
	 * Variables que almacenarán la duración total del proceso y el tiempo que le resta para su finalización, respectivamente.
	 */
	private int duracionTotal;
	private int tiempoRestante;
	
	/**
	 * Los procesos del escenario planteado se llaman desde P_A hasta P_E
	 */
	private String letra;
	
	/**
	 * Constructor de la clase.
	 * @param duracionTotal
	 * @param letra
	 */
	public Proceso(int duracionTotal, String letra) {
		this.duracionTotal = duracionTotal;
		this.tiempoRestante = duracionTotal;
		this.letra = letra;
	}
	
	/**
	 * Ejecución de un ciclo por parte del proceso.
	 */
	public void ejecutoCiclo() {
		this.tiempoRestante--;
	}
	
	/**
	 * Nos devuelve la información de cuánto tiempo le resta al proceso para finalizar.
	 * @return
	 */
	public int tiempoRestante() {
		return this.tiempoRestante;
	}
	
	@Override
	public String toString() {
		String mensaje = "[P_" + this.letra + " (" + this.duracionTotal + ", " + this.tiempoRestante + ")]";
		return mensaje;
	}
}
