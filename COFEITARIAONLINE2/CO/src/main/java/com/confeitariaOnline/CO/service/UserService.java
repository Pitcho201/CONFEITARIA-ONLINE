package com.confeitariaOnline.CO.service;

import com.confeitariaOnline.CO.model.User;
import com.confeitariaOnline.CO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar o usuário no banco de dados
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        // Retornar os detalhes do usuário
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())  // A senha já está codificada
                .roles("USER") // Aqui você pode personalizar as roles do usuário
                .build();
    }

    // Método para buscar o usuário pelo nome de usuário
    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Método para salvar o usuário
    public void salvarUsuario(User user) {
        userRepository.save(user);
    }
}
