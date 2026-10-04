package randoAccesFile;
/*
 * @author Celia Alamo Calle 
 * Descripcion: Programa que escriba en un fichero Aleatorio a traves de  array
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

		// Iniciamos la posicion en 0
		posicion = 0;

		for (;;) {
			// nos posicionamos en la posicion 0
			ficherorando.seek(posicion);
			// obtenemos el id de empleado
			id = ficherorando.readInt();

			// recorremos el apellido

			for (int i = 0; i < apellidos.length; i++) {
				// leemo el apellido con el auxiliar
				aux = ficherorando.readChar();

				// guardamos en el array
				apellidos[i] = aux;
			}
			// transformamos el array a String

			String apellidoss = new String(apellidos);
			departamento = ficherorando.readInt();
			salario = ficherorando.readDouble();

			// condicion si id es menos que 0

			if (id > 0) {
				//mostramos en pantalla con formato 
				System.out.printf("ID: %s, Apellido: %s, Departamentos: %s, Salario: %.2f %n", 
						id, apellidoss.trim(), departamento, salario);

				posicion = posicion + 36;

				if (ficherorando.getFilePointer() == ficherorando.length()) {
					break;
				}

			}

		} // fin del for

		ficherorando.close(); // cerramos programa
	
	} // fin de main

}//fin de la clase LeerFichero
