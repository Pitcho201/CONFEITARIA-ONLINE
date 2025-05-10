package com.confeitariaOnline.CO.controller;

import com.confeitariaOnline.CO.model.User;
import com.confeitariaOnline.CO.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Exibe a página de login
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.buscarPorUsername(username);

        if (user == null) {
            model.addAttribute("error", "Usuário não encontrado.");
            return "login";
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("error", "Senha incorreta.");
            return "login";
        }

        if (!user.isEnabled()) {
            model.addAttribute("error", "Conta desativada.");
            return "login";
        }

        // Caso o login seja bem-sucedido
        model.addAttribute("username", username);
        return "redirect:/pedidos";
    }
}
