package com.confeitariaOnline.CO.controller;

import com.confeitariaOnline.CO.model.Contato;
import com.confeitariaOnline.CO.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    // Exibe a lista de contatos na página
    @GetMapping
    public String listarContatos(Model model) {
        List<Contato> contatos = contatoService.listarTodos();
        model.addAttribute("contatos", contatos);
        return "contatos"; // Exibe os contatos na página
    }

    // Recebe os dados do formulário e salva no banco de dados
    @PostMapping
    public String adicionarContato(@RequestParam String nome,
                                   @RequestParam String email,
                                   @RequestParam String mensagem,
                                   Model model) {
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setMensagem(mensagem);
    
        contatoService.salvar(contato); // Salva o contato no banco de dados

        // Após salvar, redireciona para a página de confirmação
        model.addAttribute("nome", nome); // Adiciona o nome à confirmação
        return "contatoConfirmacao"; // Página de confirmação
    }

}
