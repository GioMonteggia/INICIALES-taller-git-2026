package com.gio.cs2api.rest.controller;

import com.gio.cs2api.domain.Arma;
import com.gio.cs2api.domain.Escopeta;
import com.gio.cs2api.domain.Francotirador;
import com.gio.cs2api.domain.GranadaFlash;
import com.gio.cs2api.domain.Jugador;
import com.gio.cs2api.domain.Pistola;
import com.gio.cs2api.domain.Rifle;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @GetMapping("/demo")
    public ResponseEntity<Map<String, Object>> mostrarJugador() {

        Jugador jugador = crearJugadorDemo();

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("jugador", jugador.getNombre());
        respuesta.put("cantidadArmas", jugador.cantidadArmas());
        respuesta.put("armas", obtenerInformacionArmas(jugador));

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/demo/disparar")
    public ResponseEntity<Map<String, Object>> dispararTodas() {

        Jugador jugador = crearJugadorDemo();

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("jugador", jugador.getNombre());
        respuesta.put("resultado", jugador.dispararTodas());

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/demo/recargar")
    public ResponseEntity<Map<String, Object>> recargarTodas() {

        Jugador jugador = crearJugadorDemo();

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("jugador", jugador.getNombre());
        respuesta.put("resultado", jugador.recargarTodas());

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/demo/tienda")
    public ResponseEntity<Map<String, Object>> mostrarTienda() {

        Jugador jugador = crearJugadorDemo();

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("jugador", jugador.getNombre());
        respuesta.put("productos", jugador.mostrarTienda());

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/demo/disparar/{posicion}")
    public ResponseEntity<Map<String, Object>> dispararArma(
            @PathVariable int posicion) {

        Jugador jugador = crearJugadorDemo();

        Map<String, Object> respuesta = new LinkedHashMap<>();

        respuesta.put("jugador", jugador.getNombre());
        respuesta.put("posicion", posicion);
        respuesta.put("resultado",
                jugador.dispararArma(posicion));

        return ResponseEntity.ok(respuesta);
    }

    private Jugador crearJugadorDemo() {

        Jugador jugador = new Jugador("Jugador Demo");

        Arma rifle = new Rifle("AK-47", 2700f);
        Arma pistola = new Pistola("Glock", 700f);
        Arma escopeta = new Escopeta("Nova", 1050f);
        Arma francotirador =
                new Francotirador("AWP", 4750f);
        Arma granada =
                new GranadaFlash("Flash", 200f);

        jugador.agregarArma(rifle);
        jugador.agregarArma(pistola);
        jugador.agregarArma(escopeta);
        jugador.agregarArma(francotirador);
        jugador.agregarArma(granada);

        return jugador;
    }

    private List<Map<String, Object>> obtenerInformacionArmas(
            Jugador jugador) {

        return jugador.getInventario()
                .getArmas()
                .stream()
                .map(arma -> {

                    Map<String, Object> informacion =
                            new LinkedHashMap<>();

                    informacion.put(
                            "tipo",
                            arma.getClass().getSimpleName()
                    );

                    informacion.put(
                            "nombre",
                            arma.getNombre()
                    );

                    informacion.put(
                            "precio",
                            arma.getPrecio()
                    );

                    informacion.put(
                            "municion",
                            arma.getMunicionActual()
                    );

                    return informacion;
                })
                .toList();
    }
}
