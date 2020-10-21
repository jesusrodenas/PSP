package PSP.planificador;


public class Proceso{
	public String nombre;
	public int duracion;
	
	
	public Proceso(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}	

}
