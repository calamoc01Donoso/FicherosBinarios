package dom;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LecturaEmpleadoXMl {

    public static void main(String[] args) {

        DocumentBuilderFactory factor =
                DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder contruye = factor.newDocumentBuilder();
            Document documento = contruye.parse(new File("Empleados.xml"));
            documento.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n",
                    documento.getDocumentElement().getNodeName());

            // crea una lista con todos los nodos empleado
            NodeList empleados = documento.getElementsByTagName("empleado");

            System.out.printf("Nodos empleado a recorrer: %d %n",
                    empleados.getLength());

            // recorrer la lista
            for (int i = 0; i < empleados.getLength(); i++) {

                Node emple = empleados.item(i); // obtener un nodo empleado

                if (emple.getNodeType() == Node.ELEMENT_NODE) {

                    // obtener los elementos del nodo
                    Element elemento = (Element) emple;

                    System.out.printf("ID = %s %n",
                            elemento.getElementsByTagName("id")
                                    .item(0).getTextContent());

                    System.out.printf(" * Apellido = %s %n",
                            elemento.getElementsByTagName("apellido")
                                    .item(0).getTextContent());

                    System.out.printf(" * Departamento = %s %n",
                            elemento.getElementsByTagName("departamento")
                                    .item(0).getTextContent());

                    System.out.printf(" * Salario = %s %n",
                            elemento.getElementsByTagName("salario")
                                    .item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    } // fin de main
} // fin de la clase