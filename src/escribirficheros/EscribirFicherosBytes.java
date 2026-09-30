package escribirficheros;
/**
 * @author Celia Álamo Calle 
 * 
 * Descripcion : Escribir bytes en un fichero y visualizarlos
 * */
import java.io.*; 
public class EscribirFicherosBytes {

	public static void main(String[] args) throws IOException {
		
		File  archivo = new File(".", "FicheroBytes.dat"); 
		
		// creamos el objeto  de salida 
		FileOutputStream escribir =  new FileOutputStream(archivo); 
		
		//Creamos el objeto mostras de FileInputStream 
		FileInputStream mostrar = new FileInputStream(archivo);
		
		// variable posicion llamada i de tipo entero 
		int i; 
		// escribimos en bytes 
		for( i = 0; i<100; i++) {
			escribir.write(i);
		}
		
		escribir.close();
		
		// visulizamos  ficheros 
		
		while( (i = mostrar.read()) !=-1) {
			System.out.println(i); 
		}
		
		mostrar.close();
	}

}


