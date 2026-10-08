package com.gio.cs2api.domain;

public class GranadaSenuelo extends Granada {

    public GranadaSenuelo(String nombre, float precio) {
        super(nombre, precio, "Senuelo", 2.5f);
    }

    @Override
    protected String efectoLanzamiento() {
        return obtenerNombre() + " lanza una granada señuelo.";
    }
}
