package com.gio.cs2api.model;

public class Francotirador extends Arma {

    private int zoom;

    public Francotirador(String nombre, float precio) {
        super(nombre, precio, 100, 4.0f, 5);
        this.zoom = 8;
    }

    @Override
    public String disparar() {
        consumirMunicion();
        return obtenerNombre() + " realiza un disparo de precisión.";
    }

    public int getZoom() {
        return zoom;
    }

    public String activarZoom() {
        return "Zoom x" + zoom + " activado.";
    }
}