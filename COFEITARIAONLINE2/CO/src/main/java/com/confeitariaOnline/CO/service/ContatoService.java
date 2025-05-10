package com.confeitariaOnline.CO.service;

import com.confeitariaOnline.CO.model.Contato;
import com.confeitariaOnline.CO.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deletar(Long id) {
        contatoRepository.deleteById(id);
    }

    public Contato buscarPorId(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }
}
