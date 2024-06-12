package com.jesuscast.reposteriaanita.models;

public class PostreFrutas extends Producto {
    private String size;

    public PostreFrutas(String nombreProducto, int cantidad, double precio, String size) {
        super(nombreProducto, cantidad, precio);
        this.size = size;
    }

    public String getDesing() {
        return size;
    }

    public void setDesing(String desing) {
        this.size = desing;
    }
}
