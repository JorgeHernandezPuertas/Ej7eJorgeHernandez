/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7e;

import java.time.LocalDate;

/**
 *
 * @author jorge
 */
public class Factura {
    
    private static int contador = 0;
    
    // atributos
    private String codigo;
    private LocalDate fechaEmision;
    private String descripcion;
    private double totalImporteFactira;

    // Constructores
    public Factura() {
        this.codigo = String.valueOf(++contador);
        this.fechaEmision = LocalDate.now();
        
    }

    public Factura(String codigo, LocalDate fechaEmision, String descripcion, double totalImporteFactira) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
        this.totalImporteFactira = totalImporteFactira;
    }
    
    
}
