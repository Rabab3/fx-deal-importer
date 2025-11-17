package com.example.fxdeals; // Remplace par le package de ton application

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaviconController {

    @RequestMapping("favicon.ico")
    public void returnNoFavicon() {
        // Rien à faire ici, cette méthode empêche simplement l'erreur 404 pour favicon.ico
    }
}
