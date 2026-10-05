package com.gio.cs2api.controller;

import com.gio.cs2api.model.Arma;
import com.gio.cs2api.model.Escopeta;
import com.gio.cs2api.model.Francotirador;
import com.gio.cs2api.model.GranadaFlash;
import com.gio.cs2api.model.GranadaHumo;
import com.gio.cs2api.model.GranadaIncendiaria;
import com.gio.cs2api.model.Pistola;
import com.gio.cs2api.model.Subfusil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmaController {

    @GetMapping("/armas/{tipo}")
    public Arma crearArma(
            @PathVariable String tipo,
            @RequestParam(defaultValue = "Arma CS2") String nombre,
            @RequestParam(defaultValue = "100") float precio,
            @RequestParam(required = false) Integer dano,
            @RequestParam(required = false) Integer cargador) {

        return switch (tipo.toLowerCase()) {

            case "pistola" -> {
                if (dano != null && cargador != null) {
                    yield new Pistola(nombre, precio, dano, cargador);
                }
                yield new Pistola(nombre, precio);
            }

            case "escopeta" -> {
                if (dano != null && cargador != null) {
                    yield new Escopeta(nombre, precio, dano, cargador, 1.5f);
                }
                yield new Escopeta(nombre, precio);
            }

            case "subfusil" -> new Subfusil(nombre, precio);

            case "francotirador" -> new Francotirador(nombre, precio);

            case "humo" -> new GranadaHumo(nombre, precio);

            case "flash" -> new GranadaFlash(nombre, precio);

            case "incendiaria" -> new GranadaIncendiaria(nombre, precio);

            default -> throw new IllegalArgumentException(
                    "Tipo de arma no válido: " + tipo
            );
        };
    }
}
