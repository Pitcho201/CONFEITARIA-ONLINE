package com.confeitariaOnline.CO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.confeitariaOnline.CO.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNome (String nome);
}
