package com.gio.cs2api.domain;

public class GranadaIncendiaria extends Granada {

    public GranadaIncendiaria(String nombre, float precio) {
        super(nombre, precio, "Incendiaria", 4.5f);
    }

    @Override
    protected String efectoLanzamiento() {
        return obtenerNombre() + " lanza una granada incendiaria.";
    }
}
