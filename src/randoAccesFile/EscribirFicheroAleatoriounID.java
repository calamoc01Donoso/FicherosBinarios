package randoAccesFile;
/*
 * @author Celia Alamo Calle 
 * Descripcion: Programa que escriba(mostrar en pantalla ) en un fichero Aleatorio un id  a traves de  array
 * */

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class EscribirFicheroAleatoriounID {

	public static void main(String[] args) throws IOException {
		File ruta = new File("AleatorioEmpleado.dat");
		RandomAccessFile ficherorando = new RandomAccessFile(ruta, "r");

		// nota: mismo numero de posicion en cada array
		int id, departamento, posicion;
		Double salario;
		char apellidos[] = new char[10];
	char aux; 
		
		int identidad= 4; 

		// Iniciamos la posicion en 0
		posicion =( identidad - 1 ) * 36;
		
		//recorremos apellido 
		for (int i = 0; i < apellidos.length; i++) {
			apellidos[i] = ficherorando.readChar();
		}
		
		if(posicion >= ficherorando.length()){
			
			System.out.printf("ID: %d, no existe empleado...", identidad); 
			
		}else {
			// me posiciono 
			ficherorando.seek(posicion); 
			id = ficherorando.readInt();
			
			String apellidoss = new String(apellidos);
			
			//leemos departamento y salario
			departamento = ficherorando.readInt();
			salario = ficherorando.readDouble();
			
			System.out.printf("ID: %d, Apellido: %s, Departamentos: %s, Salario: %.2f %n", 
					id, apellidoss.trim(), departamento, salario);
		}
		

		ficherorando.close(); // cerramos programa
	
	} // fin de main

}//fin de la clase LeerFichero
