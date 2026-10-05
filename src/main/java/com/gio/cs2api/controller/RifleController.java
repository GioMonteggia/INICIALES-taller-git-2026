package com.gio.cs2api.controller;

import com.gio.cs2api.model.Rifle;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller propio del rifle. Vive aparte del ArmaController que ya estaba
 * en el proyecto: no se modifica ningún archivo existente.
 *
 * <p>Como el proyecto no tiene un ManejadorErrores propio, el 400 se devuelve
 * desde acá con ResponseEntity para no tocar nada del código que ya estaba.</p>
 */
@RestController
@RequestMapping("/rifles")
public class RifleController {

    @GetMapping("/{nombre}")
    public ResponseEntity<Map<String, Object>> detalle(@PathVariable String nombre,
                                                       @RequestParam(defaultValue = "2700") float precio,
                                                       @RequestParam(defaultValue = "36") int dano,
                                                       @RequestParam(defaultValue = "30") int cargador) {
        try {
            Rifle rifle = new Rifle(nombre, precio, dano, cargador);
            Map<String, Object> respuesta = new LinkedHashMap<>();
            respuesta.put("nombre", rifle.getNombre());
            respuesta.put("tipo", "Rifle");
            respuesta.put("precio", rifle.getPrecio());
            respuesta.put("dano", rifle.getDano());
            respuesta.put("peso", rifle.getPeso());
            respuesta.put("cargador", rifle.getCargador());
            respuesta.put("municion", rifle.getMunicionActual() + "/" + rifle.getMunicionMax());
            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException error) {
            return error(error.getMessage());
        }
    }

    @GetMapping("/{nombre}/disparar")
    public ResponseEntity<Map<String, Object>> disparar(@PathVariable String nombre,
                                                        @RequestParam(defaultValue = "2700") float precio,
                                                        @RequestParam(defaultValue = "30") int cargador,
                                                        @RequestParam(required = false) Integer distancia,
                                                        @RequestParam(defaultValue = "1") int veces) {
        if (veces < 1 || veces > 50) {
            return error("veces debe estar entre 1 y 50");
        }
        if (distancia != null && distancia < 0) {
            return error("La distancia no puede ser negativa");
        }
        Rifle rifle;
        try {
            rifle = new Rifle(nombre, precio, 36, cargador);
        } catch (IllegalArgumentException error) {
            return error(error.getMessage());
        }

        StringBuilder disparos = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            // Sin distancia entra la sobrecarga disparar(); con distancia, la otra versión.
            String disparo = distancia == null ? rifle.disparar() : rifle.disparar(distancia);
            disparos.append(disparo);
            if (i < veces - 1) {
                disparos.append(" | ");
            }
        }
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("disparos", disparos.toString());
        respuesta.put("municionRestante", rifle.getMunicionActual());
        return ResponseEntity.ok(respuesta);
    }

    private static ResponseEntity<Map<String, Object>> error(String mensaje) {
        Map<String, Object> cuerpo = new LinkedHashMap<>();
        cuerpo.put("error", mensaje);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpo);
    }
}