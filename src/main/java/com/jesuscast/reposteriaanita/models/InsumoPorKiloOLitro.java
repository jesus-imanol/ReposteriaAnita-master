package com.jesuscast.reposteriaanita.models;

public class InsumoPorKiloOLitro extends Insumo {
    private double cantidad;

    public InsumoPorKiloOLitro(String nombre,String uniidadDeMedidad, double cantidad) {
        super(nombre,uniidadDeMedidad);
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public void sumarCantidad(double cantidad){
        this.cantidad=this.cantidad+cantidad;
    }
    public boolean restarCantidad(double cantidad){
        boolean fallo;
        if(cantidad <= this.cantidad){
            this.cantidad=this.cantidad-cantidad;
            fallo=true;
        }
        else {
            fallo=false;
        }
        return fallo;
    }

}
