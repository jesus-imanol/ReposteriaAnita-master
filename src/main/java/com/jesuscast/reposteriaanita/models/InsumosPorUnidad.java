package com.jesuscast.reposteriaanita.models;

import com.jesuscast.reposteriaanita.models.Insumo;

public class InsumosPorUnidad extends Insumo {
    private int cantidad;
    public InsumosPorUnidad(){}

    public InsumosPorUnidad(String nombre, String unidadDeMedidad, int cantidad) {
        super(nombre,unidadDeMedidad);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidadPorUnidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
