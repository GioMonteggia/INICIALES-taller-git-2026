package com.gio.cs2api.domain;

public abstract class Arma {

    private final String nombre;
    private final float precio;
    private final int dano;
    private final float peso;
    private final int municionMax;
    private int municionActual;

    public Arma(String nombre, float precio, int dano, float peso, int municionMax) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if (dano <= 0) {
            throw new IllegalArgumentException("El daño debe ser mayor que 0");
        }

        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }

        if (municionMax <= 0) {
            throw new IllegalArgumentException("La munición máxima debe ser mayor que 0");
        }

        this.nombre = nombre;
        this.precio = precio;
        this.dano = dano;
        this.peso = peso;
        this.municionMax = municionMax;
        this.municionActual = municionMax;
    }

    public abstract String disparar();

    public String recargar() {
        municionActual = municionMax;
        return nombre + " recargada.";
    }

    public String obtenerPrecio() {
        return "Precio: $" + precio;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getDano() {
        return dano;
    }

    public float getPeso() {
        return peso;
    }

    public int getMunicionMax() {
        return municionMax;
    }

    public int getMunicionActual() {
        return municionActual;
    }

    protected void consumirMunicion() {
        if (municionActual > 0) {
            municionActual--;
        }
    }
}
