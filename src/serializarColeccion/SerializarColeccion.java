package serializarColeccion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializarColeccion {
	public static void main(String[] args) {
		String rutaArchivo = "lista_personas.dat";

		// 1. Crear el ArrayList y poblarlo con datos
		ArrayList<String> listaOriginal = new ArrayList<>();
		listaOriginal.add("Carlos");
		listaOriginal.add("Ana");
		listaOriginal.add("Luisa");

		// 2. Guardar el ArrayList en un archivo (writeObject)
		guardarLista(listaOriginal, rutaArchivo);

		// 3. Leer el ArrayList desde el archivo (readObject)
		ArrayList<String> listaLeida = leerLista(rutaArchivo);

		// 4. Mostrar el resultado por consola
		if (listaLeida != null) {
			System.out.println("Lista leída con éxito: " + listaLeida);
		}
	}

	// Método para escribir el objeto
	public static void guardarLista(ArrayList<String> lista, String archivo) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {

			oos.writeObject(lista); // Aquí se realiza la magia
			System.out.println("ArrayList guardado correctamente.");

		} catch (IOException e) {
			System.out.println("Error al guardar el archivo: " + e.getMessage());
		}
	}

	// Método para leer el objeto
	@SuppressWarnings("unchecked")
	public static ArrayList<String> leerLista(String archivo) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {

			// Leemos el objeto y hacemos el casteo (cast) a ArrayList
			return (ArrayList<String>) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
			return null;
		}
	}
}
