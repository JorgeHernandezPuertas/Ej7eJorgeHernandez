/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7e;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaFacturas {
    
    // Defino que es un elemento que contiene otros elemenetos xml
    @XmlElementWrapper(name = "facturas")
    // Defino el elemento que contiene
    @XmlElement(name = "factura")
    private List<Factura> facturas;

    // constructores
    public ListaFacturas() {
    }

    public ListaFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    // getters y setters
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
}
