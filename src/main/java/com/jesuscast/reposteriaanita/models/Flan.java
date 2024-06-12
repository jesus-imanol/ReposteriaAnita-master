package com.jesuscast.reposteriaanita.models;

public class Flan extends Producto {
    private String desing;
    private String size;
    public Flan(String nombreProducto, int cantidad, double precio,String desing, String size) {
        super(nombreProducto, cantidad, precio);
        this.desing = desing;
        this.size=size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDesing() {
        return desing;
    }

    public void setDesing(String desing) {
        this.desing = desing;
    }
}
