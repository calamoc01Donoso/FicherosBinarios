package dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 
import java.io.*;


public class EmpleadosUno {

	public static void main(String[] args) throws IOException {
		File archivo =  new File ("AleatorioEmpleado.dat"); 
		RandomAccessFile ficheroarchivo = new RandomAccessFile(archivo, "r");
		
		// variables 
		int id, departamento;  
		int posicion = 0; 
		Double salario ; 
		char apellido [] = new char [10]; 
		char aux; 
		
		DocumentBuilderFactory factor  = DocumentBuilderFactory.newInstance(); 
		
		// excepcion general 
		try {
			
			DocumentBuilder construir = factor.newDocumentBuilder();
			DOMImplementation implementa = construir.getDOMImplementation(); 
			Document documento = implementa.createDocument(null, "Empleados", null);
			
			documento.setXmlVersion("1.0");
			
			for(;;) {
				
				ficheroarchivo.seek(posicion); 
				id = ficheroarchivo.readInt(); 
				
				// recorremos con un bucle  los apellidos
				
				for(int i = 0; i< apellido.length; i++) {
					aux = ficheroarchivo.readChar(); 
					apellido[i] = aux; 
				}
				//transformamos un String
				String  apellidos = new String(apellido); 
				departamento = ficheroarchivo.readInt(); 
				salario = ficheroarchivo.readDouble(); 
				
				// condicion de si el id es  mayor que 0 
				if(id > 0) {
					
					Element nodo =  documento.createElement("empleado");
					
					documento.getDocumentElement().appendChild(nodo); 
					
					// añado los elementos 
					CrearElemento("id", Integer.toString(id), nodo, documento);
					CrearElemento("apellido", apellidos.trim(), nodo, documento);
					CrearElemento("departamento", Integer.toString(departamento), nodo, documento);
					CrearElemento("salario", Double.toString(salario), nodo, documento);
				}
				
				// me posiciono en el empelado 
				posicion = posicion + 36; 
				if (ficheroarchivo.getFilePointer() == ficheroarchivo.length()) {
					break;
				}
			}// fin del for infinito 
			
			Source source = new DOMSource(documento); 
			
			File  archivonuevo = new File ("Empleados.xml");
			Result resultado = new StreamResult (archivonuevo); 
			
			Transformer transformar = TransformerFactory.newInstance().newTransformer(); 
			transformar.transform(source, resultado);
			
		}catch (Exception e) {
			System.out.println("Error: "+ e); 
		}
		ficheroarchivo.close(); 

	}
	
	//metodo de añadir elemento
	public static void CrearElemento(String datosEmpleado, String valor, Element raiz, Document document) {
		Element elemento = document.createElement(datosEmpleado); 
		Text text = document.createTextNode(valor); 
		raiz.appendChild(elemento); 
		elemento.appendChild(text); 
	}

}
