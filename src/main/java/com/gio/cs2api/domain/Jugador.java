package com.gio.cs2api.domain;

import java.util.List;

public class Jugador {

    private final String nombre;
    private final Inventario inventario;

    public Jugador(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del jugador no puede estar vacío"
            );
        }

        this.nombre = nombre;
        this.inventario = new Inventario();
    }

    public void agregarArma(Arma arma) {
        inventario.agregarArma(arma);
    }

    public String dispararArma(int posicion) {
        return inventario.dispararArma(posicion);
    }

    public String recargarArma(int posicion) {
        return inventario.recargarArma(posicion);
    }

    public List<String> dispararTodas() {
        return inventario.dispararTodas();
    }

    public List<String> recargarTodas() {
        return inventario.recargarTodas();
    }

    public List<String> mostrarTienda() {
        return inventario.mostrarTienda();
    }

    public int cantidadArmas() {
        return inventario.cantidadArmas();
    }

    public String getNombre() {
        return nombre;
    }

    public Inventario getInventario() {
        return inventario;
    }
}
