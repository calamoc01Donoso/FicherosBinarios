package ejerciciosAleatorio;
import java.io.File;
import java.io.RandomAccessFile;

public class Actividad31 {
    public static void main(String[] args) {
    	
        if (args.length < 2) {
            System.out.println("Uso: java ModificarSalario <ID> <Importe>");
            return;
        }

        int idBuscado = Integer.parseInt(args[0]);
        double importe = Double.parseDouble(args[1]);

        File fichero = new File("AleatorioEmpleado.dat");

        try (RandomAccessFile file = new RandomAccessFile(fichero, "rw")) {
            // El registro 'id' está en la posición (id - 1) * 52
            long posicion = (long) (idBuscado - 1) * 52;

            if (posicion >= file.length()) {
                System.out.println("El identificador no existe.");
                return;
            }

            file.seek(posicion);
            int id = file.readInt();

            if (id == 0 || id == -1) { // Si id no existe o está borrado
                System.out.println("El identificador no existe.");
                return;
            }

            // Leer apellido (36 bytes = 18 caracteres char)
            char[] apellidoArr = new char[18];
            for (int i = 0; i < 18; i++) {
                apellidoArr[i] = file.readChar();
            }
            String apellido = new String(apellidoArr).trim();

            // Saltar el departamento (int = 4 bytes) para llegar al salario
            file.skipBytes(4);

            // Leer salario antiguo
            long posSalario = file.getFilePointer(); // Guardar posición donde empieza el salario
            double salarioAntiguo = file.readDouble();

            // Calcular nuevo salario y escribirlo
            double salarioNuevo = salarioAntiguo + importe;
            file.seek(posSalario);
            file.writeDouble(salarioNuevo);

            System.out.println("Apellido: " + apellido);
            System.out.println("Salario Antiguo: " + salarioAntiguo);
            System.out.println("Salario Nuevo: " + salarioNuevo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}