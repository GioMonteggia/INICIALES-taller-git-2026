package com.gio.cs2api.model;

public class GranadaHumo extends Granada {

    public GranadaHumo(String nombre, float precio) {
        super(nombre, precio, "Humo", 5.0f);
    }

    @Override
    public String lanzar() {
        consumirMunicion();
        return obtenerNombre() + " lanza humo.";
    }
}