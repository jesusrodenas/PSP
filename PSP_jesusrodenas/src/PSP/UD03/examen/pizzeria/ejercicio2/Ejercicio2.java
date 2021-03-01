/**
 * 
 */
package PSP.UD03.examen.pizzeria.ejercicio2;
import java.util.Scanner;


import PSP.UD03.examen.pizzeria.cliente.ClienteServicio;
import PSP.UD03.examen.pizzeria.modelo.Pedido;
import PSP.UD03.examen.pizzeria.modelo.Tienda;

/**
 * @author JESUS
 *
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteServicio cs = new ClienteServicio();
		Scanner teclado;
		boolean finalizar = false;
		int producto = -1;
		
		Tienda aLaCarta = new Tienda("A la carta", cs.obtenerProductos());
		Integer idTienda = cs.nuevoEstablecimiento(aLaCarta.getNombreEstablecimiento());
		aLaCarta.setIdTienda(idTienda);
		
		Pedido pedido = new Pedido();
		
		System.out.println("Establecimiento: " + aLaCarta.getNombreEstablecimiento());
		System.out.println("Iniciando su pedido");
		
		while (!finalizar) {
			System.out.println("¿Qué artículo desea?");
			aLaCarta.muestraCarta();
			teclado = new Scanner(System.in);
			
			producto = teclado.nextInt();
			pedido.anadirProducto(aLaCarta.getCarta().get(producto));			
			
			System.out.println("Producto añadido.");
			System.out.println("¿Finalizar pedido? (S/N)");
			teclado = new Scanner(System.in);
			finalizar = teclado.next().equals("S");		
			
		}
		pedido.muestraPedido();
		System.out.println("¿Registrar pedido? (S/N)");
		teclado = new Scanner(System.in);
		
		if(teclado.next().equals("S")) {
			cs.guardaPedido(aLaCarta, pedido);
			System.out.println("Pedido almacenado.");
		}else {
			System.out.println("Pedido descartado.");
		}
	}
}