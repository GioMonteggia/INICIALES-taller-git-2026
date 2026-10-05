package com.gio.cs2api.model;

public class Pistola extends Arma {

    private String modoDisparo;
    private int cargador;

    public Pistola(String nombre, float precio) {
        super(nombre, precio, 35, 1.0f, 12);
        this.modoDisparo = "Semiautomático";
        this.cargador = 12;
    }

    public Pistola(String nombre, float precio, int dano, int cargador) {
        super(nombre, precio, dano, 1.0f, cargador);
        this.modoDisparo = "Semiautomático";
        this.cargador = cargador;
    }

    @Override
    public String disparar() {
        consumirMunicion();
        return obtenerNombre() + " dispara.";
    }

    public String disparar(int distancia) {
        consumirMunicion();
        return obtenerNombre() + " dispara a " + distancia + " metros.";
    }

    public String getModoDisparo() {
        return modoDisparo;
    }

    public int getCargador() {
        return cargador;
    }
}
