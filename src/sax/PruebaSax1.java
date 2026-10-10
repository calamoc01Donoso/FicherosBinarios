package sax;

import java.io.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.*;

import org.xml.sax.InputSource;


public class PruebaSax1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException  {
		
		XMLReader procesadorXml = XMLReaderFactory.createXMLReader(); 
		
		GestionContenido gestor = new GestionContenido(); 
		procesadorXml.setContentHandler(gestor);
		
		InputSource ficheroXML =  new InputSource("empleados.xml"); 
		procesadorXml.parse(ficheroXML);

	}

}

class GestionContenido extends DefaultHandler{
	
	public GestionContenido() {
	
		super(); //Accedemos a los  contrustores  de la clase padre  
	}
	
	public void startDocument() {
		System.out.println("Comienzo del documento XML"); 
	}
	
	public void endDocument() {
		System.out.println("Final del documento XML"); 
	}
	
	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\tPrincipio  del Elemento: %s %n", nombre); 
	}
	
	public void endElement(String uri, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\tFin  del Elemento: %s %n", nombre); 
	}
	
	public void characters(char[] ch, int inicio, int longitud) 
		throws SAXException{
			String car =  new String(ch, inicio, longitud); 
			//Quitamos el salto de linea 
			car = car.replaceAll("[\t\n]", ""); 
			System.out.printf(" \tCaracteres: %s %n", car); 
		}
	}
	
	
	
	

