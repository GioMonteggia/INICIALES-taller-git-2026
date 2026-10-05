package com.gio.cs2api.model;

/**
 * Especialización de Arma que faltaba en la jerarquía: el rifle.
 *
 * <p>Se agrega como archivo nuevo, sin tocar las clases que ya estaban.
 * Aporta un constructor simple (el rifle de fábrica) y uno sobrecargado
 * para que el llamador elija el daño y el cargador.</p>
 */
public class Rifle extends Arma {

    private final int cargador;
    private final float precision;

    /** Constructor simple: el rifle con su daño y su cargador de fábrica. */
    public Rifle(String nombre, float precio) {
        this(nombre, precio, 36, 30);
    }

    /** Constructor sobrecargado: el llamador decide el daño y el cargador. */
    public Rifle(String nombre, float precio, int dano, int cargador) {
        super(nombre, precio, dano, 3.7f, cargador);
        if (cargador <= 0) {
            throw new IllegalArgumentException("El cargador no puede ser 0 o negativo");
        }
        if (dano <= 0) {
            throw new IllegalArgumentException("El daño no puede ser 0 o negativo");
        }
        this.cargador = cargador;
        this.precision = 0.85f;
    }

    @Override
    public String disparar() {
        return disparar(100);
    }

    /**
     * Sobrecarga de disparar(): la misma acción indicando a qué distancia se dispara.
     * El daño se atenúa con la distancia, nunca baja de la mitad.
     */
    public String disparar(int distancia) {
        if (distancia < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa");
        }
        consumirMunicion();
        float factor = Math.max(0.5f, 1f - distancia / 100f);
        int danioEfectivo = Math.round(getDano() * factor * precision);
        return obtenerNombre() + " dispara a " + distancia + " m y causa "
                + danioEfectivo + " de daño.";
    }

    public int getCargador() {
        return cargador;
    }

    public float getPrecision() {
        return precision;
    }
}