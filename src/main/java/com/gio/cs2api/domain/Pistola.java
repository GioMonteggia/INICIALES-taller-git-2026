package com.gio.cs2api.domain;

public class Pistola extends Arma {

    private final String modoDisparo;
    private final int cargador;

    public Pistola(String nombre, float precio) {
        super(nombre, precio, 35, 1.0f, 12);
        this.modoDisparo = "Semiautomático";
        this.cargador = 12;
    }

    public Pistola(String nombre, float precio, int dano, int cargador) {
        super(nombre, precio, dano, 1.0f, cargador);

        if (dano <= 0) {
            throw new IllegalArgumentException("El daño de la pistola debe ser mayor que 0");
        }

        if (cargador <= 0) {
            throw new IllegalArgumentException("El cargador de la pistola debe ser mayor que 0");
        }

        this.modoDisparo = "Semiautomático";
        this.cargador = cargador;
    }

    @Override
    public String disparar() {
        consumirMunicion();
        return obtenerNombre() + " dispara.";
    }

    public String disparar(int distancia) {
        if (distancia < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa");
        }

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
