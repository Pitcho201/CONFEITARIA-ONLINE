package com.confeitariaOnline.CO.service;
import org.springframework.stereotype.Service;
import com.confeitariaOnline.CO.model.Pedido;

@Service
public class ServicoPagamento {

    public boolean processarPagamento(Pedido pedido) {
        // Lógica simulada para pagamento
        return true; // Simulação de sucesso
    }
}
