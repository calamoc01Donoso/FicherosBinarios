package ficheroSerializable;

import java.io.Serializable;
public class Personass implements Serializable {

	private  String nombre; 
	private int edad; 
	
	//constructor  de persona
	public Personass(String nombre, int edad) {
		this.nombre = nombre; 
		this.edad =edad; 
	}
	
	//constructor en nombre nulo ; 
	public Personass() {
		this.nombre= null; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
}
