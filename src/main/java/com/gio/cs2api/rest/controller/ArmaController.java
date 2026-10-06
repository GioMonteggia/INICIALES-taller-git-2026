package com.gio.cs2api.rest.controller;

import com.gio.cs2api.domain.Arma;
import com.gio.cs2api.domain.Escopeta;
import com.gio.cs2api.domain.Francotirador;
import com.gio.cs2api.domain.GranadaFlash;
import com.gio.cs2api.domain.GranadaHumo;
import com.gio.cs2api.domain.GranadaIncendiaria;
import com.gio.cs2api.domain.GranadaSenuelo;
import com.gio.cs2api.domain.Pistola;
import com.gio.cs2api.domain.Rifle;
import com.gio.cs2api.domain.Subfusil;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmaController {

    @GetMapping("/armas/{tipo}")
    public ResponseEntity<Map<String, Object>> crearArma(
            @PathVariable String tipo,
            @RequestParam(defaultValue = "Arma CS2") String nombre,
            @RequestParam(defaultValue = "100") float precio,
            @RequestParam(required = false) Integer dano,
            @RequestParam(required = false) Integer cargador) {

        if ((dano == null) != (cargador == null)) {
            throw new IllegalArgumentException(
                    "Los parámetros dano y cargador deben enviarse juntos"
            );
        }

        Arma arma = switch (tipo.toLowerCase()) {

            case "pistola" -> {
                if (dano != null) {
                    yield new Pistola(nombre, precio, dano, cargador);
                }
                yield new Pistola(nombre, precio);
            }

            case "escopeta" -> {
                if (dano != null) {
                    yield new Escopeta(nombre, precio, dano, cargador, 1.5f);
                }
                yield new Escopeta(nombre, precio);
            }

            case "subfusil" -> new Subfusil(nombre, precio);

            case "francotirador" -> new Francotirador(nombre, precio);

            case "rifle" -> {
                if (dano != null) {
                    yield new Rifle(nombre, precio, dano, cargador);
                }
                yield new Rifle(nombre, precio);
            }

            case "humo" -> new GranadaHumo(nombre, precio);

            case "flash" -> new GranadaFlash(nombre, precio);

            case "incendiaria" -> new GranadaIncendiaria(nombre, precio);

            case "senuelo" -> new GranadaSenuelo(nombre, precio);

            default -> throw new IllegalArgumentException(
                    "Tipo de arma no válido: " + tipo
            );
        };

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("tipo", arma.getClass().getSimpleName());
        respuesta.put("nombre", arma.getNombre());
        respuesta.put("precio", arma.getPrecio());
        respuesta.put("dano", arma.getDano());
        respuesta.put("peso", arma.getPeso());
        respuesta.put("municionMax", arma.getMunicionMax());
        respuesta.put("municionActual", arma.getMunicionActual());
        respuesta.put("mensaje", arma.disparar());
        respuesta.put("municionRestante", arma.getMunicionActual());

        return ResponseEntity.ok(respuesta);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> manejarError(
            IllegalArgumentException exception) {

        Map<String, Object> error = new LinkedHashMap<>();
        error.put("error", exception.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
}
