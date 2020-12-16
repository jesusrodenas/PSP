/**
 * 
 */
package PSP.UD02.progmultihilo;

/**
 * @author JESUS
 *
 */
public class TestingDaemonThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new EjemploDaemonThread().start();

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            // Código de interrupción.
        }
        System.out.println("Hilo principal (main) finalizado.") ;
	}
}