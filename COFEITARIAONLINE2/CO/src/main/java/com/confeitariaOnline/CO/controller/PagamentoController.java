package com.confeitariaOnline.CO.controller;

import com.confeitariaOnline.CO.model.Pedido;
import com.confeitariaOnline.CO.service.PedidoService;
import com.confeitariaOnline.CO.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{pedidoId}")
    public String exibirPagamento(@PathVariable Long pedidoId, HttpSession session, Model model) {
        User usuario = (User) session.getAttribute("user");

        if (usuario == null) {
            return "redirect:/login?redirect=/pagamento/" + pedidoId;
        }

        // Buscar o pedido baseado no ID
        Pedido pedido = pedidoService.buscarPorId(pedidoId);
        if (pedido == null) {
            model.addAttribute("erro", "Pedido não encontrado.");
            return "erro";
        }

        // Adicionar dados do pedido à página de pagamento
        model.addAttribute("pedido", pedido);
        return "pagamento";
    }

    @PostMapping("/{pedidoId}")
    public String processarPagamento(@PathVariable Long pedidoId, HttpSession session, Model model) {
        User usuario = (User) session.getAttribute("user");

        if (usuario == null) {
            return "redirect:/login?redirect=/pagamento/" + pedidoId;
        }

        // Lógica do pagamento (exemplo de simulação)
        Pedido pedido = pedidoService.buscarPorId(pedidoId);
        if (pedido == null) {
            model.addAttribute("erro", "Pedido não encontrado.");
            return "erro";
        }

        // Aqui você pode adicionar a lógica para processar o pagamento
        // Exemplo: Confirmar pagamento e atualizar status do pedido

        // Após pagamento, redirecionar para uma página de sucesso ou confirmação
        model.addAttribute("mensagem", "Pagamento realizado com sucesso!");
        return "redirect:/pedidos";
    }
}
