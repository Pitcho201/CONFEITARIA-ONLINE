package com.confeitariaOnline.CO.service;

import com.confeitariaOnline.CO.model.Cliente;
import com.confeitariaOnline.CO.model.User;
import com.confeitariaOnline.CO.repository.ClienteRepository;
import com.confeitariaOnline.CO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injeta PasswordEncoder

    public void salvarCliente(Cliente cliente) {
        // Codifica a senha usando PasswordEncoder
        String senhaCodificada = passwordEncoder.encode(cliente.getSenha());

        // Define a senha codificada para o Cliente
        cliente.setSenha(senhaCodificada);
        clienteRepository.save(cliente);

        // Cria o objeto User a partir dos dados do Cliente
        User user = new User();
        user.setUsername(cliente.getNome());
        user.setPassword(senhaCodificada); // Define a senha codificada
        user.setEmail(cliente.getEmail());
        user.setEnabled(true);

        // Salva o usuário na tabela User
        userRepository.save(user);
    }
}