package com.confeitariaOnline.CO.controller;

import com.confeitariaOnline.CO.model.Pedido;
import com.confeitariaOnline.CO.model.Produto;
import com.confeitariaOnline.CO.model.User;
import com.confeitariaOnline.CO.service.PedidoService;
import com.confeitariaOnline.CO.service.ProdutoService;
import com.confeitariaOnline.CO.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UserService userService;

    /**
     * Página para visualizar e realizar pedidos.
     */
    @GetMapping
    public String mostrarPaginaPedidos(Model model) {
        // Obtém o usuário autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // Verifica se o usuário está autenticado e busca seus dados
        User usuario = userService.buscarPorUsername(username);
        if (usuario == null || username.equals("anonymousUser")) {
            return "redirect:/login?redirect=/pedidos"; // Redireciona para login caso o usuário não seja encontrado
        }

        // Carrega os produtos disponíveis
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);

        // Adiciona informações do usuário à página
        model.addAttribute("usuario", usuario);

        return "pedidos"; // Renderiza a página de pedidos
    }

    /**
     * Processa o pedido e redireciona para a página de pagamento.
     */
    @PostMapping
    public String processarPedido(
            @RequestParam(required = false) Long produtoId,
            @RequestParam(required = false) String descricao) {

        // Obtém o usuário autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // Busca os dados do usuário
        User usuario = userService.buscarPorUsername(username);
        if (usuario == null || username.equals("anonymousUser")) {
            return "redirect:/login?redirect=/pedidos"; // Redireciona para login caso o usuário não esteja autenticado
        }

        // Cria um novo pedido
        Pedido pedido = new Pedido();
        pedido.setClienteNome(usuario.getUsername()); // Define o nome do cliente
        pedido.setClienteEmail(usuario.getEmail());   // Define o e-mail do cliente

        // Configura a descrição do pedido
        if (produtoId != null) {
            Produto produto = produtoService.buscarPorId(produtoId);
            if (produto != null) {
                pedido.setDescricaoPersonalizada("Produto: " + produto.getNome());
            }
        } else if (descricao != null && !descricao.isEmpty()) {
            pedido.setDescricaoPersonalizada("Descrição personalizada: " + descricao);
        }

        // Salva o pedido no banco de dados
        pedidoService.salvar(pedido);

        // Redireciona para a página de pagamento
        return "redirect:/pagamento";
    }
}
