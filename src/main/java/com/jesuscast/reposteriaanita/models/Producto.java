package com.jesuscast.reposteriaanita.models;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

public class Producto {
    protected String id;
    protected String nombreProducto;
    protected int cantidad;
    protected double precio;
    private boolean status;

    public Producto(String nombreProducto, int cantidad, double precio) {
        this.id = UUID.randomUUID().toString();
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.status = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    public void sumarCantidad(int cantidad){
        this.cantidad=this.cantidad+cantidad;
    }
    public boolean restarCantidad(int cantidad){
        boolean fallo;
        if(cantidad<=this.cantidad){
            this.cantidad=this.cantidad-cantidad;
            fallo=true;
        }
        else {
            fallo=false;
        }
        return fallo;
    }

}
