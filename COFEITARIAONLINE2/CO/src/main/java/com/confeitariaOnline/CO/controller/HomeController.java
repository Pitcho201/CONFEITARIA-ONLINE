package com.confeitariaOnline.CO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página inicial (index)
    @GetMapping("/")
    public String exibirPaginaInicial() {
        return "index";  // Página de índice será exibida quando acessar http://localhost:8080/
    }
    
}
