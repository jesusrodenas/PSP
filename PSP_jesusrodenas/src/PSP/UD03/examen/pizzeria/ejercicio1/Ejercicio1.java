/**
 * 
 */
package PSP.UD03.examen.pizzeria.ejercicio1;

import PSP.UD03.examen.pizzeria.cliente.ClienteServicio;

/**
 * @author JESUS
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteServicio cs = new ClienteServicio();

		Integer idEstablecimientoUno = cs.nuevoEstablecimiento("Establecimiento uno");
		Integer idEstablecimientoDos = cs.nuevoEstablecimiento("Establecimiento dos");
		Integer idEstablecimientoTres = cs.nuevoEstablecimiento("Establecimiento tres");
		
		Integer idPedidoE1_1 = cs.nuevoPedido(idEstablecimientoUno);
		Integer idPedidoE1_2 = cs.nuevoPedido(idEstablecimientoUno);
		Integer idPedidoE2 = cs.nuevoPedido(idEstablecimientoDos);
		Integer idPedidoE3 = cs.nuevoPedido(idEstablecimientoTres);
		
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_1, "CARBONARA");
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_1, "CARBONARA");
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_1, "CARBONARA");
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_1, "BARBACOA");
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_1, "BARBACOA");
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_1, "CASA");
		
		cs.anadirProducto(idEstablecimientoUno, idPedidoE1_2, "MARGARITA");
		
		cs.anadirProducto(idEstablecimientoDos, idPedidoE2, "EXTRAQUESO");
		cs.anadirProducto(idEstablecimientoDos, idPedidoE2, "4ESTACION");		
				
	}

}
