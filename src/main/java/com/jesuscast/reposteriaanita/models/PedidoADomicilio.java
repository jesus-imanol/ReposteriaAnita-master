package com.jesuscast.reposteriaanita.models;

import com.jesuscast.reposteriaanita.models.Pedido;

import java.time.LocalDate;
import java.time.LocalTime;

public class PedidoADomicilio extends Pedido {
    private String nombreDomicilio;
    private double costoEnvio;
    private String referencia;
    public PedidoADomicilio(){}
    public PedidoADomicilio(String nombreCliente, LocalDate fechaDeEntrega, LocalTime horaDeEntrega, String productDesing, String status,String nombreProducto, String nombreDomicilio, double costoEnvio, String referencia) {
        super(nombreCliente, fechaDeEntrega, horaDeEntrega, productDesing, status, nombreProducto);
        this.nombreDomicilio = nombreDomicilio;
        this.costoEnvio = costoEnvio;
        this.referencia = referencia;
    }

    public String getNombreDomicilio() {
        return nombreDomicilio;
    }

    public void setNombreDomicilio(String nombreDomicilio) {
        this.nombreDomicilio = nombreDomicilio;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public String getReferncia() {
        return referencia;
    }

    public void setReferncia(String referncia) {
        this.referencia = referncia;
    }
}
