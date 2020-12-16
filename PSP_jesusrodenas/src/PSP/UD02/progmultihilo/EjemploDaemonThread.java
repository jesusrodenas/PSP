/**
 * 
 */
package PSP.UD02.progmultihilo;

/**
 * @author JESUS
 *
 */
public class EjemploDaemonThread extends Thread {
	public EjemploDaemonThread() {
        // false -- No es un hilo de usuario, por tanto debe finalizarse explícitamente.
        // true  -- Es un hilo creado por y para el usuario y debe finalizar con la JVM, es decir, el main.
        setDaemon(false); 
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hilo " + ((isDaemon()==true)?"demonio. ":"sin fin. ") +count++);
 
            try {
                sleep(5000);
            } catch (InterruptedException e) {
               // Añadiríamo código de interrupción.
            }
        }
    }
}
