package com.gio.cs2api.domain;

public class Escopeta extends Arma {

    private final int cartuchos;
    private final float dispersion;

    public Escopeta(String nombre, float precio) {
        super(nombre, precio, 80, 3.0f, 8);
        this.cartuchos = 8;
        this.dispersion = 1.5f;
    }

    public Escopeta(String nombre, float precio, int dano, int cartuchos, float dispersion) {
        super(nombre, precio, dano, 3.0f, cartuchos);

        if (dano <= 0) {
            throw new IllegalArgumentException("El daño de la escopeta debe ser mayor que 0");
        }

        if (cartuchos <= 0) {
            throw new IllegalArgumentException("Los cartuchos deben ser mayores que 0");
        }

        if (dispersion <= 0) {
            throw new IllegalArgumentException("La dispersión debe ser mayor que 0");
        }

        this.cartuchos = cartuchos;
        this.dispersion = dispersion;
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
