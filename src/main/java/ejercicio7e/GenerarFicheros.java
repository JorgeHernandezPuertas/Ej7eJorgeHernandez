/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7e;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author jorge
 */
public class GenerarFicheros {

    // Main
    public static void main(String[] args) {

        // Genero las 50 facturas
        List<Factura> listaFacturas = generarFacturas(50);

        // Creo las carpeta xml y csv si no estan creadas
        crearDirectorio("./xml");
        crearDirectorio("./csv");

        // Escribo el fichero.csv en su carpeta
        escribirFichero("./csv/facturas.csv", listaFacturas);
        generarArchivoXML(listaFacturas, "./xml/facturas.xml");

        // Creo una carpeta facturascsv para guardas cada factura individual
        String rutaIni = "./facturas.csv/";
        String rutaFin = "";
        crearDirectorio(rutaIni);
        // Creo las facturas
        for (Factura f : listaFacturas) {
            rutaFin = rutaIni + f.getCodigo();
            escribirFichero(rutaFin, f);
        }

    }

    // Método que genera las facturas que quieras en una lista y lo devuelve
    private static List<Factura> generarFacturas(int cantidad) {
        List<Factura> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(new Factura());
        }
        return lista;
    }

    // Método para crear un directorio si no existe ya
    private static void crearDirectorio(String rutaDir) {
        Path pathDir = Paths.get(rutaDir);
        File f = new File(rutaDir); // Creo el file para ver si existe
        if (!f.exists()) { // Controlo que el directorio no esté ya creado
            try {
                Files.createDirectory(pathDir);
            } catch (IOException ioe) {
                System.out.println("Ha habido un problema creando el directorio.");
                System.out.println(ioe.toString());
            }
        }
    }

    // Método para escribir un fichero con una lista
    private static void escribirFichero(String ruta, List<Factura> lista) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            for (Factura f : lista) {
                flujo.write(f.toString());
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero generado con éxito.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    // Método para escribir un fichero con un archivo (sobrecargo el método)
    private static void escribirFichero(String ruta, Factura factura) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            flujo.write(factura.toString());
            flujo.newLine();
            flujo.flush();
            System.out.println("Fichero generado con éxito.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    // Método para generar un archivo xml
    private static void generarArchivoXML(List<Factura> lista, String ruta) {
        File archivo = new File(ruta);

        try {
            JAXBContext contexto = JAXBContext.newInstance(ListaFacturas.class);
            Marshaller serializador = contexto.createMarshaller();
            serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            serializador.marshal(new ListaFacturas(lista), archivo);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }

    }

}
