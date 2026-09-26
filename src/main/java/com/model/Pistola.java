package com.gio.cs2api.model;

public class Pistola extends Arma {

    private String modoDisparo;
    private int cargador;

    public Pistola(String nombre, float precio) {
        super(nombre, precio, 35, 1.0f, 12);
        this.modoDisparo = "Semiautomático";
        this.cargador = 12;
    }

    @Override
    public String disparar() {
        consumirMunicion();
        return obtenerNombre() + " dispara.";
    }

    public String getModoDisparo() {
        return modoDisparo;
    }

    public int getCargador() {
        return cargador;
    }
}