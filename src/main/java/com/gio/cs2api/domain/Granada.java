package com.gio.cs2api.domain;

public abstract class Granada extends Arma {

    private final String tipoGranada;
    private final float radioExplosion;

    public Granada(String nombre, float precio, String tipoGranada, float radioExplosion) {
        super(nombre, precio, 0, 1.0f, 1);

        if (tipoGranada == null || tipoGranada.isBlank()) {
            throw new IllegalArgumentException("El tipo de granada no puede estar vacío");
        }

        if (radioExplosion < 0) {
            throw new IllegalArgumentException("El radio de explosión no puede ser negativo");
        }

        this.tipoGranada = tipoGranada;
        this.radioExplosion = radioExplosion;
    }

    @Override
    public String disparar() {
        return lanzar();
    }

    public abstract String lanzar();

    public String getTipoGranada() {
        return tipoGranada;
    }

    public float getRadioExplosion() {
        return radioExplosion;
    }
}
