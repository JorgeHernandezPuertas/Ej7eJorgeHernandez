/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7e;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
import java.util.stream.DoubleStream;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author jorge
 */
public class Factura {
    
    private static final double MIN_IMPORTE = 100, MAX_IMPORTE = 1000;
    private static int contador = 0;
    private static Random aleatorio = new Random();
    
    // atributos
    private String codigo;
    private LocalDate fechaEmision;
    private String descripcion;
    private double totalImporteFactura;

    // Constructores
    public Factura() {
        this.codigo = String.valueOf(++contador);
        this.fechaEmision = LocalDate.now();
        this.descripcion = RandomStringUtils.randomAlphabetic(8);
        // Cojo un double aleatorio del doublestream que he generado con el rango
        this.totalImporteFactura = aleatorio.
                doubles(1, MIN_IMPORTE, MIN_IMPORTE).
                findAny().getAsDouble();
    }

    public Factura(String codigo, LocalDate fechaEmision, String descripcion, double totalImporteFactura) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
        this.totalImporteFactura = totalImporteFactura;
    }

    // getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTotalImporteFactura() {
        return totalImporteFactura;
    }

    public void setTotalImporteFactura(double totalImporteFactura) {
        this.totalImporteFactura = totalImporteFactura;
    }

    // equals y tostring
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factura other = (Factura) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    // tostring
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo).append(";");
        sb.append(fechaEmision).append(";");
        sb.append(descripcion).append(";");
        sb.append(totalImporteFactura);
        return sb.toString();
    }
    
    
}
