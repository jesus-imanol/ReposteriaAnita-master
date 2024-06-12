package com.jesuscast.reposteriaanita.models;

import java.util.UUID;

public class Cliente {
    private String id;
    private String nombre;
    private String direccion;
    private String sexo;
    private String tiempoCliente;
    private boolean status;
    public Cliente(){}

    public Cliente(String nombre, String direccion, String sexo, String tiempoCliente) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.direccion = direccion;
        this.sexo = sexo;
        this.tiempoCliente = tiempoCliente;
        this.status = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTiempoCliente() {
        return tiempoCliente;
    }

    public void setTiempoCliente(String tiempoCliente) {
        this.tiempoCliente = tiempoCliente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
