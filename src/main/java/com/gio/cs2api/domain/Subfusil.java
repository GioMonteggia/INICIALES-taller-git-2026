package com.gio.cs2api.domain;

public class Subfusil extends Arma {

    private final String modoDisparo;
    private final int cargador;

    public Subfusil(String nombre, float precio) {
        super(nombre, precio, 30, 2.0f, 30);
        this.modoDisparo = "Automático";
        this.cargador = 30;
    }

    @Override
    public String disparar() {
        consumirMunicion();
        return obtenerNombre() + " dispara en modo automático.";
    }

    public String getModoDisparo() {
        return modoDisparo;
    }

    public int getCargador() {
        return cargador;
    }
}
