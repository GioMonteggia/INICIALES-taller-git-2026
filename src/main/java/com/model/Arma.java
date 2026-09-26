package com.gio.cs2api.model;

public abstract class Arma {

    private String nombre;
    private float precio;
    private int dano;
    private float peso;
    private int municionMax;
    private int municionActual;

    public Arma(String nombre, float precio, int dano, float peso, int municionMax) {
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