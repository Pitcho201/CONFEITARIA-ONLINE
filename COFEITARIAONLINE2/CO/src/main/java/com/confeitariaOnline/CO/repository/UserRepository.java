package com.confeitariaOnline.CO.repository;

import com.confeitariaOnline.CO.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);  // Método para buscar usuário pelo nome de usuário
}
