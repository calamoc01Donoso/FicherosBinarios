package ficheroSerializable;

import java.io.*; 

public class LeerObjetoSerializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Personass gente; 
		
		File  archivo = new File(".", "FicheroSerializable.dat"); 
		
		
		// creamos el objeto  de salida 
		FileInputStream escribir =  new FileInputStream(archivo); 
		ObjectInputStream dataEntrada = new ObjectInputStream(escribir); 
		
	
		
		
		try {
			
			while(true) {
				// escribimos en bytes 
				/*transformacion unicode   es decir permitiendo que se pueda entender en todo sitios */
				gente =(Personass) dataEntrada.readObject(); // escribe en cadena de  formato de 
				System.out.printf("Nombre: $s Su Edad:  %d %n"+ gente.getNombre()+ gente.getEdad()); 
			}
		}catch(EOFException e) {}
		
		dataEntrada.close();

	}

}
