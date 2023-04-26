/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7e;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Usuario {

    private static Scanner teclado = new Scanner(System.in);
    private static File dirFacturas = new  File("./facturascsv");
    
    public static void main(String[] args) {

        // Pregunto que factura quiere ver el usuario
        String respuesta = preguntarFactura();
        
        // Leo la factura desde el fichero
        Factura factura = leerFactura(respuesta);
        
        // Muestro la factura por pantalla
        System.out.println("La factura elegida es:");
        System.out.println(factura);
        System.out.println("----------------------------------------------");
        
        // Borro el archivo de la factura leida
        File archivoFactura = new File(respuesta);
        archivoFactura.delete();
        
        // Muestro el contenido del directorio para comprobar que se ha borrado
        System.out.println("El contenido del directorio ahora es:");
        listarFacturas();

    }

    // Método para preguntar al usuario que factura leer
    private static String preguntarFactura() {
        String respuesta = "";
        do {

            System.out.println("Introduce la ruta de la factura que quieres ver:");
            System.out.println("----------------------------------------------");
            listarFacturas();
            System.out.println("----------------------------------------------");
            respuesta = teclado.nextLine();
            if (!existeFactura(respuesta)) {
                System.out.println("Introduce una ruta que exista.");
            }
            System.out.println("----------------------------------------------");
        } while (!existeFactura(respuesta));
        return respuesta;
    }

    // Método para ver listar las facturas de la carpeta facturascsv
    private static void listarFacturas() {
        if (dirFacturas.exists()) {
            File[] facturas = dirFacturas.listFiles();
            int contador = 0;
            for (File f : facturas) {
                System.out.print(f + " ");
                contador++;
                if (contador % 5 == 0) {
                    System.out.println("");
                }
            }
            System.out.println("");
        }
    }

    // Método que comprueba si la respuesta es alguna factura que exista en el directorio
    private static boolean existeFactura(String respuesta) {
        File[] facturas = dirFacturas.listFiles();
        List<String> lista = new ArrayList<>();
        for (File f : facturas) {
            lista.add(f.getPath());
        }
        return lista.contains(respuesta);
    }

    private static Factura leerFactura(String ruta) {
        Factura factura = null;
        String linea = "";
        String[] tokens;
        try ( Scanner flujo = new Scanner(new FileReader(ruta))) {
            linea = flujo.nextLine();
            tokens = linea.split(";");
            factura = new Factura(tokens[0], LocalDate.parse(tokens[1]), 
                    tokens[2], Double.parseDouble(tokens[3]));
        } catch (FileNotFoundException e) {
            System.out.println("Ha habido un error leyendo la factura");
            System.out.println(e.getMessage());
        }
        return factura;
    }
}
