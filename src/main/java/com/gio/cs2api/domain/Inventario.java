package com.gio.cs2api.domain;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private final List<Arma> armas;

    public Inventario() {
        this.armas = new ArrayList<>();
    }

    public void agregarArma(Arma arma) {

        if (arma == null) {
            throw new IllegalArgumentException(
                    "No se puede agregar un arma nula"
            );
        }

        armas.add(arma);
    }

    public String dispararArma(int posicion) {

        Arma arma = obtenerArma(posicion);

        return arma.disparar();
    }

    public String recargarArma(int posicion) {

        Arma arma = obtenerArma(posicion);

        return arma.recargar();
    }

    public List<String> dispararTodas() {

        List<String> resultados = new ArrayList<>();

        for (Arma arma : armas) {
            resultados.add(arma.disparar());
        }

        return resultados;
    }

    public List<String> recargarTodas() {

        List<String> resultados = new ArrayList<>();

        for (Arma arma : armas) {
            resultados.add(arma.recargar());
        }

        return resultados;
    }

    public List<String> mostrarTienda() {

        List<String> productos = new ArrayList<>();

        for (Arma arma : armas) {
            productos.add(
                    arma.obtenerNombre()
                            + " - "
                            + arma.obtenerPrecio()
            );
        }

        return productos;
    }

    public int cantidadArmas() {
        return armas.size();
    }

    public Arma obtenerArma(int posicion) {

        if (posicion < 0 || posicion >= armas.size()) {
            throw new IndexOutOfBoundsException(
                    "La posición del arma no existe"
            );
        }

        return armas.get(posicion);
    }

    public List<Arma> getArmas() {
        return List.copyOf(armas);
    }
}
