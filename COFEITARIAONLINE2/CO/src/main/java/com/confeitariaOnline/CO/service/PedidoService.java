package com.confeitariaOnline.CO.service;

import com.confeitariaOnline.CO.model.Pedido;
import com.confeitariaOnline.CO.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
}
