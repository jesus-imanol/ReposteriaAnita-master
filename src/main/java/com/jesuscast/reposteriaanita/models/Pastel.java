package com.jesuscast.reposteriaanita.models;

public class Pastel extends Producto {
    private int cantidadPersonas;
    private String relleno;
    private String desing;
    public Pastel(String nombreProducto, int cantidad, double precio,int cantidadPersonas, String relleno, String desing) {
        super(nombreProducto, cantidad, precio);
        this.cantidadPersonas = cantidadPersonas;
        this.relleno = relleno;
        this.desing = desing;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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
