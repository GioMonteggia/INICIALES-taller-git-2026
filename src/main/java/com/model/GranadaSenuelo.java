package com.gio.cs2api.model;

public class GranadaSenuelo extends Granada {

    public GranadaSenuelo(String nombre, float precio) {
        super(nombre, precio, "Señuelo", 0.0f);
    }

    @Override
    public String lanzar() {
        if (getMunicionActual() == 0) {
            return obtenerNombre() + ": no quedan señuelos.";
        }
        consumirMunicion();
        return obtenerNombre() + " simula disparos falsos para distraer al enemigo.";
    }
}
