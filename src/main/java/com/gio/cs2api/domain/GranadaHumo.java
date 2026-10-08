package com.gio.cs2api.domain;

public class GranadaHumo extends Granada {

    public GranadaHumo(String nombre, float precio) {
        super(nombre, precio, "Humo", 3.0f);
    }

    @Override
    protected String efectoLanzamiento() {
        return obtenerNombre() + " lanza una granada de humo.";
    }
}
