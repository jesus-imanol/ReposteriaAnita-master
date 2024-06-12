package com.jesuscast.reposteriaanita.models;

public class Carlota extends Producto {
    private String tipo;
    public Carlota(String nombreProducto, int cantidad, double precio,String tipo) {
        super(nombreProducto, cantidad, precio);
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
