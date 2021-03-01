/**
 * 
 */
package PSP.UD03.examen.pizzeria.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class Pedido {
	private List<Producto> productosPedido;
	
	public Pedido(){
		productosPedido = new ArrayList<Producto>();
	}
	
	public void anadirProducto(Producto p) {
		this.productosPedido.add(p);
	}
	
	public void muestraPedido() {
		String mensaje = "Pedido: ";
		for (Producto p : productosPedido) {
			mensaje += p.getNombreProducto() + ", ";
		}
		// Elimina la última ", "
		String mensajeApresentar = mensaje.substring(0, mensaje.length()-2);
		// Añade un punto final.
		mensajeApresentar += ".";
		
		System.out.println(mensajeApresentar);
	}

	/**
	 * @return the productosPedido
	 */
	public List<Producto> getProductosPedido() {
		return productosPedido;
	}

	/**
	 * @param productosPedido the productosPedido to set
	 */
	public void setProductosPedido(List<Producto> productosPedido) {
		this.productosPedido = productosPedido;
	}
}
