package com.jesuscast.reposteriaanita.models;

import java.util.ArrayList;

public class ReporteVenta {
    ArrayList<Pedido> listaReporteVentas= new ArrayList<>();
    public boolean addReporteVenta(Pedido pedido){
        boolean status;
        status=listaReporteVentas.add(pedido);
        return status;
    }

    public ArrayList<Pedido> getListaReporteVentas() {
        return listaReporteVentas;
    }

    public void setListaReporteVentas(ArrayList<Pedido> listaReporteVentas) {
        this.listaReporteVentas = listaReporteVentas;
    }
}
