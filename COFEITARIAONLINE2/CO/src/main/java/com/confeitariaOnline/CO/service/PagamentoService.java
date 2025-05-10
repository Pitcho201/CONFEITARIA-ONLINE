package com.confeitariaOnline.CO.service;

import com.confeitariaOnline.CO.model.Pagamento;
import com.confeitariaOnline.CO.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }
}
