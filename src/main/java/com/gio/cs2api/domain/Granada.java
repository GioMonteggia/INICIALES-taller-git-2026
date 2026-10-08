package com.gio.cs2api.domain;

public abstract class Granada extends Arma {

    private final String tipoGranada;
    private final float radioExplosion;
    private final long cooldownMilisegundos;
    private long ultimoLanzamiento;

    public Granada(
            String nombre,
            float precio,
            String tipoGranada,
            float radioExplosion) {

        super(nombre, precio, 0, 1.0f, 1);

        if (tipoGranada == null || tipoGranada.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de granada no puede estar vacío"
            );
        }

        if (radioExplosion < 0) {
            throw new IllegalArgumentException(
                    "El radio de explosión no puede ser negativo"
            );
        }

        this.tipoGranada = tipoGranada;
        this.radioExplosion = radioExplosion;
        this.cooldownMilisegundos = 1000;
        this.ultimoLanzamiento = 0;
    }

    @Override
    public String disparar() {
        return lanzar();
    }

    public final String lanzar() {

        if (getMunicionActual() <= 0) {
            return obtenerNombre() + ": no quedan granadas.";
        }

        long ahora = System.currentTimeMillis();

        if (ahora - ultimoLanzamiento < cooldownMilisegundos) {
            long restante =
                    cooldownMilisegundos
                            - (ahora - ultimoLanzamiento);

            return obtenerNombre()
                    + ": cooldown activo. Espere "
                    + restante
                    + " ms.";
        }

        consumirMunicion();
        ultimoLanzamiento = ahora;

        return efectoLanzamiento();
    }

    protected abstract String efectoLanzamiento();

    public String getTipoGranada() {
        return tipoGranada;
    }

    public float getRadioExplosion() {
        return radioExplosion;
    }

    public long getCooldownMilisegundos() {
        return cooldownMilisegundos;
    }

    public long getCooldownRestante() {

        long transcurrido =
                System.currentTimeMillis() - ultimoLanzamiento;

        if (ultimoLanzamiento == 0
                || transcurrido >= cooldownMilisegundos) {
            return 0;
        }

        return cooldownMilisegundos - transcurrido;
    }
}e
