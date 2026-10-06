package com.gio.cs2api.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RifleTests {

    @Test
    void constructorSimpleUsaElRifleDeFabrica() {
        Rifle rifle = new Rifle("AK-47", 2700f);

        assertEquals(30, rifle.getMunicionMax());
        assertEquals(36, rifle.getDano());
        assertEquals(30, rifle.getCargador());
    }

    @Test
    void constructorSobrecargadoUsaLoQuePasaElLlamador() {
        Rifle rifle = new Rifle("M4A4", 3100f, 33, 20);

        assertEquals(20, rifle.getMunicionMax());
        assertEquals(33, rifle.getDano());
    }

    @Test
    void ningunaFirmaDejaElRifleEnUnEstadoImposible() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rifle("AK-47", 2700f, 36, 0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Rifle("AK-47", 2700f, 0, 30)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Rifle("AK-47", 2700f).disparar(-1)
        );
    }

    @Test
    void dispararAfectaLaMunicionYAttenuaConLaDistancia() {
        Rifle cerca = new Rifle("AK-47", 2700f);
        Rifle lejos = new Rifle("AK-47", 2700f);

        cerca.disparar(0);
        lejos.disparar(100);

        assertEquals(29, cerca.getMunicionActual());
        assertEquals(29, lejos.getMunicionActual());
        assertTrue(cerca.disparar(0).contains("causa 31"));
        assertTrue(lejos.disparar(100).contains("causa 15"));
    }

    @Test
    void elDanoNoBajaDeLaMitadPorMuyLejosQueEsten() {
        Rifle rifle = new Rifle("AK-47", 2700f);

        assertTrue(rifle.disparar(100).contains("causa 15"));
        assertTrue(rifle.disparar(400).contains("causa 15"));
    }
}
