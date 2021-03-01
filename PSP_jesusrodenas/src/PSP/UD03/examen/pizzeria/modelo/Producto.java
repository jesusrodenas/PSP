/**
 * 
 */
package PSP.UD03.examen.pizzeria.modelo;

/**
 * @author JESUS
 *
 */
public class Producto {
	private String codProducto;
	private String nombreProducto;
	
	public Producto(String codProducto, String nombreProducto) {
		this.codProducto = codProducto;
		this.nombreProducto = nombreProducto;		
	}

	// GETTERS Y SETTERS
	/**
	 * @return the codProducto
	 */
	public String getCodProducto() {
		return codProducto;
	}

	/**
	 * @param codProducto the codProducto to set
	 */
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
}
