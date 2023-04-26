/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7e;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jorge
 */
public class LeerXML {

    public static void main(String[] args) {

        try {
            // Hago el contexto con mi clase ListFacturas
            JAXBContext contexto = JAXBContext.newInstance(ListaFacturas.class);
            
            // Creo el deserializador
            Unmarshaller deserializador = contexto.createUnmarshaller();

            // Llama al método de unmarshalling con la ruta que necesito
            ListaFacturas lista = (ListaFacturas) deserializador.unmarshal(new File("./xml/facturas.xml"));

            // Paso el ListaFacturas a una lista de facturas porque no tengo tostring
            List<Factura> listaFacturas = lista.getFacturas();
            
            listaFacturas.forEach(f -> System.out.println(f));
            
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }

    }
}
