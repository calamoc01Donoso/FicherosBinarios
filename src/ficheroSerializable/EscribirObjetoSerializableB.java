package ficheroSerializable;

import java.io.*; 
public class EscribirObjetoSerializableB {

	public static void main(String[] args) throws IOException {
		
		// defino el objeto persona 
		Personass gente; 
		
		// definio los objeto de ficheros 
		File  archivo = new File(".", "FicheroSerializable.dat"); 
		FileOutputStream escribir =  new FileOutputStream(archivo); 
		ObjectOutputStream objetSalida = new ObjectOutputStream(escribir); 
		
		String nombre[] = {"Celia", "Leo","Eva","hugo"};  
		// variable posicion llamada i de tipo entero 
		int edades[]= {12, 15, 16, 17}; 
		
		for( int i = 0; i<edades.length; i++) {
		
			gente= new Personass(nombre[i], edades[i]); 
			
			objetSalida.writeObject(gente);// escribe el objeto en el fichero 
		}
		
		objetSalida.close();

	}

}
