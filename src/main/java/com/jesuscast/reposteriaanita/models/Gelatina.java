package com.jesuscast.reposteriaanita.models;

public class Gelatina extends Producto {
    private String size;
    private String tipo;
    public Gelatina(String nombreProducto, int cantidad, double precio,String size, String tipo) {
        super(nombreProducto, cantidad, precio);
        this.size = size;
        this.tipo = tipo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
