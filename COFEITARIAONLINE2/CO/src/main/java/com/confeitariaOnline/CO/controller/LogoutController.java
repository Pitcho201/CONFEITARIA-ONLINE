package com.confeitariaOnline.CO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // Lógica para logout manual
        return "redirect:/login"; // Redireciona para a página de login
    }
}
