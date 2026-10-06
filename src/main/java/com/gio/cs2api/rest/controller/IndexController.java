package com.gio.cs2api.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String inicio() {
        return "API de armas de Counter-Strike 2 funcionando";
    }
}
