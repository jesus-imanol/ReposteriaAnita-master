package com.jesuscast.reposteriaanita.models;

public class Cupcake extends Producto {
    private String relleno;
    private String desing;
    public Cupcake(String nombreProducto, int cantidad, double precio,String relleno, String desing) {
        super(nombreProducto, cantidad, precio);
        this.relleno = relleno;
        this.desing = desing;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getDesing() {
        return desing;
    }

    public void setDesing(String desing) {
        this.desing = desing;
    }
}
