/**
 * 
 */
package PSP.UD03.examen.pizzeria.modelo;

import java.util.Map;

/**
 * @author JESUS
 *
 */
public class Tienda {
	private String nombreEstablecimiento;
	private Integer idTienda;
	private Map<Integer, Producto> carta;
	
	public Tienda (String nombreEstablecimiento, Map<Integer, Producto> carta) {
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.carta = carta;
	}
	
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
	
	public void muestraCarta() {
		String lineaMuestra = "";
		for (Map.Entry<Integer, Producto> entry : carta.entrySet()) {
			lineaMuestra += ((Integer)entry.getKey()) + "." + ((Producto) entry.getValue()).getNombreProducto() + " ";
		}
		System.out.println(lineaMuestra);
	}

	/**
	 * @return the nombreEstablecimiento
	 */
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	/**
	 * @param nombreEstablecimiento the nombreEstablecimiento to set
	 */
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	/**
	 * @return the carta
	 */
	public Map<Integer, Producto> getCarta() {
		return carta;
	}

	/**
	 * @param carta the carta to set
	 */
	public void setCarta(Map<Integer, Producto> carta) {
		this.carta = carta;
	}

	/**
	 * @return the idTienda
	 */
	public Integer getIdTienda() {
		return idTienda;
	}
}
