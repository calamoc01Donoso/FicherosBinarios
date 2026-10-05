package ejerciciosAleatorio;

/*
 * @auto Celia Alamo 
 * @Descripcion: crear un programa java que  al ejecutarlo en lina de comando reciba un identificador de empleado 
 * y lo borre , haciendo un borrador logico 
 * */
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Borrar14 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Debe introducir un parámetro: ID del empleado a borrar.");
            return;
        }

        try {
            int identidad = Integer.parseInt(args[0]); // ID a borrar

            File ruta = new File("AleatorioEmpleado.dat");
            if (!ruta.exists()) {
                System.out.println("El fichero no existe.");
                return;
            }

            RandomAccessFile file = new RandomAccessFile(ruta, "rw");

            int tamanoRegistro = 36;
            long posicion = (identidad - 1) * tamanoRegistro;

            if (posicion >= file.length() || posicion < 0) {
                System.out.printf("El ID: %d no existe.%n", identidad);
            } else {
                file.seek(posicion);

                int id = file.readInt();

                if (id == -1) {
                    System.out.printf("El ID: %d ya estaba borrado.%n", identidad);
                } else {
                    // Volvemos al inicio del registro para sobrescribirlo entero
                    file.seek(posicion);

                    // 1. Identificador = -1
                    file.writeInt(-1);

                    // 2. Apellido = String del ID borrado padded a 10 chars
                    StringBuffer buffer = new StringBuffer(String.valueOf(identidad));
                    buffer.setLength(10); // Ajusta la longitud fija
                    file.writeChars(buffer.toString());

                    // 3. Departamento = 0
                    file.writeInt(0);

                    // 4. Salario = 0.0
                    file.writeDouble(0.0);

                    System.out.printf("El empleado con ID %d ha sido borrado correctamente.%n", identidad);
                }
            }

            file.close();

        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número entero.");
        } catch (IOException e) {
            System.out.println("Error en el fichero: " + e.getMessage());
        }
    }
}