package com.gio.cs2api.model;

public class GranadaIncendiaria extends Granada {

    public GranadaIncendiaria(String nombre, float precio) {
        super(nombre, precio, "Incendiaria", 3.0f);
    }

    @Override
    public String lanzar() {
        consumirMunicion();
        return obtenerNombre() + " lanza fuego.";
    }
}