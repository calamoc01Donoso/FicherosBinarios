package randoAccesFile;
/*
 * @author Celia Alamo Calle 
 * Descripcion: Programa que escriba en un fichero Aleatorio a traves de  array
 * */

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class LeerFicheroAleatorio2 {

	public static void main(String[] args) throws IOException {
	File ruta = new File("AleatorioEmpleado.dat"); 
	RandomAccessFile rando = new RandomAccessFile(ruta, "rw");
	
	// nota: mismo numero  de posicion en cada array
	String apellidos [] = {"Alamo", "Calle", "Sanche", "Lopez"}; 
	int departamento [] = {1,10,20,3}; 
	Double salario [] = {100.45,25.56,10.56,59.80}; 
	
	// objeto  buffer de la clase StringBuffer
	
	StringBuffer buffer ; 
	int numero= apellidos.length; 
	
	// bucle  para recorrer el array 
	for(int i=0; i<numero; i++) {
		rando.writeInt(i + 1);
		//pasamos el array apellido
		buffer = new StringBuffer(apellidos[i]); 
		
		//Limitamos  los bytes 
		buffer.setLength(10); 
		
		//insertamos apellido
		rando.writeChars(buffer.toString());
		//insertamos departamento
		rando.writeInt(departamento[i]);
		//insertamos salario
		rando.writeDouble(salario[i]);
	}
	
	rando.close(); //cerramos  programa
	}

}
