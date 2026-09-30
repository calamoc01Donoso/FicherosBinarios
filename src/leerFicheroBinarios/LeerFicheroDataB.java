package leerFicheroBinarios;

import java.io.*; 
public class LeerFicheroDataB {

	public static void main(String[] args) throws IOException{
		File  archivo = new File(".", "FicheroData.dat"); 
		
		// creamos el objeto  de salida 
		FileInputStream escribir =  new FileInputStream(archivo); 
		DataInputStream dataEntrada = new DataInputStream(escribir); 
		
	
		
		String nombre;  
		// variable posicion llamada i de tipo entero 
		int edades; 
		try {
			
			while(true) {
				// escribimos en bytes 
				/*transformacion unicode   es decir permitiendo que se pueda entender en todo sitios */
				nombre =dataEntrada.readUTF(); // escribe en cadena de  formato de 
				edades = dataEntrada.readInt();// escribe en formato entero 
				System.out.println("Nombre: "+nombre + "Su Edad: "+ edades); 
			}
		}catch(EOFException e) {}
		
		dataEntrada.close();
		
		
		
		
	}
}


