package ejerciciosAleatorio;
/*
 * @auto Celia Alamo 
 * @Descripcion: crear un programa java que  al ejecutarlo en lina de comando consultado los datos 
 * */
import java.io.File;
import java.io.RandomAccessFile;

public class Actividad31 {
    public static void main(String[] args) {
    	
    	//si los datos pasado por programa es menor que 2 
        if (args.length < 2) {
            System.out.println(" Modificar Salario id y importe");
            return;
        }

        int idBuscado = Integer.parseInt(args[0]);
        double importe = Double.parseDouble(args[1]);

        File fichero = new File("AleatorioEmpleado.dat");

        try (RandomAccessFile ficherorando = new RandomAccessFile(fichero, "rw")) {
        	
            // El registro 'id' está en la posición (id - 1) * 52
            int posicion = (idBuscado - 1) * 52;

            if (posicion >= ficherorando.length()) {
                System.out.println("El identificador no existe.");
                return;
            }

            ficherorando.seek(posicion);
            int id = ficherorando.readInt();

            if (id == 0 || id == -1) { // Si id no existe o está borrado
                System.out.println("El identificador no existe.");
                return;
            }

            // Leer apellido (36 bytes = 18 caracteres char)
            char[] apellidoArr = new char[18];
            for (int i = 0; i < 18; i++) {
                apellidoArr[i] = ficherorando.readChar();
            }
            String apellido = new String(apellidoArr).trim();

            // Saltar el departamento (int = 4 bytes) para llegar al salario
            ficherorando.skipBytes(4);

            // Leer salario antiguo
            int nuevosalario= (int) ficherorando.getFilePointer(); // Guardar posición donde empieza el salario 
            double salarioAntiguo = ficherorando.readDouble();

            // Calcular nuevo salario y escribirlo
            double salariosNuevo = salarioAntiguo + importe;
            
            ficherorando.seek(nuevosalario);
            ficherorando.writeDouble(salariosNuevo);

            System.out.println("Apellido: " + apellido);
            System.out.println("Salario Antiguo: " + salarioAntiguo);
            System.out.println("Salario Nuevo: " + salariosNuevo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}