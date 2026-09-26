package com.gio.cs2api.model;

public abstract class Granada extends Arma {

    private String tipoGranada;
    private float radioExplosion;

    public Granada(String nombre, float precio, String tipoGranada, float radioExplosion) {
        super(nombre, precio, 0, 1.0f, 1);
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