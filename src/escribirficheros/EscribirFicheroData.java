package escribirficheros;

import java.io.*;


public class EscribirFicheroData {

	public static void main(String[] args) throws IOException {
	File  archivo = new File(".", "FicheroData.dat"); 
		
		// creamos el objeto  de salida 
		FileOutputStream escribir =  new FileOutputStream(archivo); 
		DataOutputStream dataSalida = new DataOutputStream(escribir); 
		
	
		
		String nombre[] = {"Celia", "Leo","Eva","hugo"};  
		// variable posicion llamada i de tipo entero 
		int edades[]= {12, 15, 16, 17}; 
		// escribimos en bytes 
		for( int i = 0; i<edades.length; i++) {
			/*transformacion unicode   es decir permitiendo que se pueda entender en todo sitios */
			dataSalida.writeUTF(nombre[i]); // escribe en cadena de  formato de 
			dataSalida.writeInt(edades[i]);// escribe en formato entero 
		}
		
		dataSalida.close();
		
		
		
		
	}

	}


