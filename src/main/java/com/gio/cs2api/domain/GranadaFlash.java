package com.gio.cs2api.domain;

public class GranadaFlash extends Granada {

    public GranadaFlash(String nombre, float precio) {
        super(nombre, precio, "Flash", 4.0f);
    }

    @Override
    public String lanzar() {
        consumirMunicion();
        return obtenerNombre() + " lanza una flash.";
    }
}
