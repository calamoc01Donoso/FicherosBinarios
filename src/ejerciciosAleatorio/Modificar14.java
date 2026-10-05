package ejerciciosAleatorio;

/*
 * @auto Celia Alamo 
 * @Descripcion: crear un programa java que  al ejecutarlo en lina de comando reciba un identificador de empleado 
 * y lo modifique el importe  del empleado
 * */

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Modificar14 {

    public static void main(String[] args) {
        // Comprobamos que nos hayan pasado los 2 parámetros requeridos
        if (args.length < 2) {
            System.out.println("Debe introducir dos parámetros: ID e Importe.");
            return;
        }

        try {
            int identidad = Integer.parseInt(args[0]); // ID recibido
            double importe = Double.parseDouble(args[1]); // Importe a sumar

            File ruta = new File("AleatorioEmpleado.dat");
            if (!ruta.exists()) {
                System.out.println("El fichero no existe.");
                return;
            }

            RandomAccessFile file = new RandomAccessFile(ruta, "rw"); // Modo lectura y escritura

            // Suponemos tamaño de registro = 36 bytes (ID: 4, Apellido: 10 chars = 20, Dep: 4, Salario: 8)
            int tamanoRegistro = 36; 
            long posicion = (identidad - 1) * tamanoRegistro;

            if (posicion >= file.length() || posicion < 0) {
                System.out.printf("El ID: %d no existe en el fichero.%n", identidad);
            } else {
                file.seek(posicion);

                int id = file.readInt();

                // Si el ID es -1, significa que está borrado lógicamente
                if (id == -1) {
                    System.out.printf("El ID: %d no existe (registro borrado).%n", identidad);
                } else {
                	
                    // Leemos el apellido (10 chars)
                    char[] apellidoChars = new char[10];
                    
                    for (int i = 0; i < apellidoChars.length; i++) {
                        apellidoChars[i] = file.readChar();
                    }
                   
                    String apellido = new String(apellidoChars).trim();

                    int departamento = file.readInt();
                    double salarioAntiguo = file.readDouble();
                    double salarioNuevo = salarioAntiguo + importe;

                    // Nos volvemos a posicionar justo donde empieza el salario para sobrescribirlo
                    // Posición actual - 8 bytes que ocupa el double de salario
                    file.seek(file.getFilePointer() - 8);
                    file.writeDouble(salarioNuevo);

                    System.out.printf("Empleado ID: %d | Apellido: %s | Salario Antiguo: %.2f | Salario Nuevo: %.2f%n",
                            id, apellido, salarioAntiguo, salarioNuevo);
                }
            }

            file.close();

        } catch (NumberFormatException e) {
            System.out.println("Error: Los argumentos deben ser números válidos.");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura en el fichero: " + e.getMessage());
        }
    }
}