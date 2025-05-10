package com.confeitariaOnline.CO.controller;
import com.confeitariaOnline.CO.model.Produto;
import com.confeitariaOnline.CO.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InserirProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    // Página de registro
    @GetMapping("/inserirProduto")
    public String exibirFormularioDeRegistro(Model model) {
        model.addAttribute("produto", new Produto());
        return "inserirProduto"; // Exibe o formulário de registro
    }

    // Processa o formulário de registro
    @PostMapping("/inserir")
    public String registrarCliente(Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Erro no formulário de registro.");
            return "inserir";
        }

        try {
            produtoService.salvar(produto); // Salva o cliente e o usuário
            model.addAttribute("success", "Registro concluído com sucesso! Faça login para continuar.");
            return "redirect:/inserirProduto";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao registrar. Tente novamente.");
            return "inserirProduto";
        }
    }

}
