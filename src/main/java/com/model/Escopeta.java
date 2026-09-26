package com.gio.cs2api.model;

public class Escopeta extends Arma {

    private int cartuchos;
    private float dispersion;

    public Escopeta(String nombre, float precio) {
        super(nombre, precio, 80, 3.0f, 8);
        this.cartuchos = 8;
        this.dispersion = 1.5f;
    }

    @Override
    public String disparar() {
        consumirMunicion();
        return obtenerNombre() + " dispara una ráfaga de escopeta.";
    }

    public int getCartuchos() {
        return cartuchos;
    }

    public float getDispersion() {
        return dispersion;
    }
}