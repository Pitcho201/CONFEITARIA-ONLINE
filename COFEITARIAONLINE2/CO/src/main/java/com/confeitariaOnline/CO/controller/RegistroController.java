package com.confeitariaOnline.CO.controller;

import com.confeitariaOnline.CO.model.Cliente;
import com.confeitariaOnline.CO.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private ClienteService clienteService;

    // Página de registro
    @GetMapping("/registro")
    public String exibirFormularioDeRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro"; // Exibe o formulário de registro
    }

    // Processa o formulário de registro
    @PostMapping("/registrar")
    public String registrarCliente(Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Erro no formulário de registro.");
            return "registro";
        }

        if (!cliente.getSenha().equals(cliente.getConfirmarSenha())) {
            model.addAttribute("error", "As senhas não coincidem.");
            return "registro";
        }

        try {
            clienteService.salvarCliente(cliente); // Salva o cliente e o usuário
            model.addAttribute("success", "Registro concluído com sucesso! Faça login para continuar.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao registrar. Tente novamente.");
            return "registro";
        }
    }
}
