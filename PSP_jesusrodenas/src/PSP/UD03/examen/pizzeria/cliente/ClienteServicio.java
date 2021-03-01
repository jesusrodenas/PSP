/**
 * 
 */
package PSP.UD03.examen.pizzeria.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import PSP.UD03.examen.pizzeria.modelo.Pedido;
import PSP.UD03.examen.pizzeria.modelo.Producto;
import PSP.UD03.examen.pizzeria.modelo.Tienda;

/**
 * @author JESUS
 *
 */
public class ClienteServicio {
	// ACTUALIZA AQUÍ EL CÓDIGO DE AUTOR.
	public static final String codAutor = "PRUEBAS";
	
	// Constantes
	private static final String endPoint = "https://psp2021site.000webhostapp.com/";
	private static URL urlEndPoint;
	
	static {
		try {
			urlEndPoint = new URL(endPoint);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Ej 1
	private static final String svoNuevoEstablecimiento = "/pizzeria_psp/inicializaPizzeria.php?COD_AUTOR=" + codAutor;
	private static final String svoNuevoPedido = "/pizzeria_psp/insertaPedido.php?COD_AUTOR=" + codAutor;
	private static final String svoAnadirProducto = "/pizzeria_psp/insertaProductoPedido.php?COD_AUTOR=" + codAutor;
	
	// Ej 2
	private static final String svoConsultaProductos = "/pizzeria_psp/consultaProductos.php";
	
	// DESARROLLAMOS DOS MÉTODOS QUE NOS FACILITARÁN TAREAS RUTINARIAS
	/**
	 * (-- DEPRECATED: Al añadir el parámetro COD_AUTOR a la definición de la url del servicio, 
	 * ya no es necesario el parametro "boolean esElPrimero" ni distinguir ? de &	 
	 * Se mantiene en el comentario por si en un futuro se reincorpora )
	 * 
	 * M�todo que añadirá parámetros a una URL de la forma correcta:
	 *  - El primero con ?, el resto con &
	 *  - Todos serán clave=valor
	 *  - Reemplazará los espacios que puedan existir para eliminar errores.
	 *  
	 * (-- DEPRECATED)
	 * 
	 * M�todo que recibe una url en forma de String y le añade el parámetro recibido.
	 * @param url URL base
	 * @param nombre nombre parámetro
	 * @param valor valor del parámetro.
	 * @param esElPrimero Permitirá calcular si corresponde ? o &
	 */
	public String anadirParametro(String url, String nombre, String valor) {
		return url + "&" + nombre + "=" + valor.replaceAll(" ", "%20"); 
	}
	
	/**
	 * Devuelve un BufferedReader con el resultado de la conexión a la URL pasada como parámetro.
	 * @param url
	 * @return
	 */
	public BufferedReader conecta(URL url) {
		BufferedReader in = null;
		try {
			InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	/////////////////// EJERCICIO 1
	
	/**
	 * Invoca al servicio de añadir nuevo etablecimiento pasándole el nombre del mismo.
	 * @param nombreEstablecimiento
	 * @return
	 */
	public Integer nuevoEstablecimiento (String nombreEstablecimiento) {
		String cadenaUrl = anadirParametro(svoNuevoEstablecimiento, "NOMBRE_TIENDA", nombreEstablecimiento);
		
		String s_idTienda;
		Integer idTienda = -1;
		try {
			URL urlServicio = new URL(urlEndPoint, cadenaUrl);
			BufferedReader in = conecta(urlServicio);
			s_idTienda = in.readLine();
			idTienda = Integer.valueOf(s_idTienda);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return idTienda;
	}
	
	/**
	 * Inserta nuevo pedido en la tienda pasada como parámetro.
	 * @param idTienda
	 * @return
	 */
	public Integer nuevoPedido(Integer idTienda) {
		String cadenaUrl = anadirParametro(svoNuevoPedido, "ID_TIENDA", idTienda.toString());
		
		String s_idPedido;
		Integer idPedido = -1;
		try {
			URL urlServicio = new URL(urlEndPoint, cadenaUrl);
			BufferedReader in = conecta(urlServicio);
			s_idPedido = in.readLine();
			idPedido = Integer.valueOf(s_idPedido);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return idPedido;
	}
	
	/**
	 * Inserta nuevo producto en el pedido pasado como parámetro, cuya tienda es la pasada como parámetro.
	 * @param idTienda
	 * @param idPedido
	 * @param codProducto
	 * @return
	 */
	public boolean anadirProducto(Integer idTienda, Integer idPedido, String codProducto) {
		
		String cadenaUrl = anadirParametro(svoAnadirProducto, "ID_TIENDA", idTienda.toString());
		cadenaUrl = anadirParametro(cadenaUrl, "ID_PEDIDO", idPedido.toString());
		cadenaUrl = anadirParametro(cadenaUrl, "COD_PRODUCTO", codProducto);
		
		String estado = "KO";
		try {
			URL urlServicio = new URL(urlEndPoint, cadenaUrl);
			BufferedReader in = conecta(urlServicio);
			estado = in.readLine();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return "OK".equals(estado);
	}
	
///////////////// EJERCICIO 2
	/**
	 * Método que invoca al servicio de consulta de productos y devuelve un mapa con los mismos.
	 * @return
	 */
	public Map<Integer, Producto> obtenerProductos(){
		URL urlServicio;
		BufferedReader in = null;
		Map<Integer, Producto> carta = new HashMap<Integer, Producto>();
		
		try {
			urlServicio = new URL(urlEndPoint, svoConsultaProductos);
			in = conecta(urlServicio);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String linea;		
		int i = 1;
		try {
			while ((linea=in.readLine())!=null) {
				String[] partes = linea.split("=");
				carta.put(i++, new Producto(partes[0], partes[1]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carta;
	}
	
	/**
	 * Registra la información recibida como parámetro.
	 * @param t Tienda a registrar.
	 * @param p Pedido a registrar (contiene los productos).
	 */
	public void guardaPedido (Tienda t, Pedido p) {
		Integer idPedido = nuevoPedido(t.getIdTienda());
		
		for (Producto producto : p.getProductosPedido()) {
			anadirProducto(t.getIdTienda(), idPedido, producto.getCodProducto());
		}
	}
}
