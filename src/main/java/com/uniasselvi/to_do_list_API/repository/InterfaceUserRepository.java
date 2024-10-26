package com.uniasselvi.to_do_list_API.repository;

import com.uniasselvi.to_do_list_API.model.User; // Corrigido
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Long> {
    // Métodos de consulta adicionais

    // Consulta para retornar usuário por nome
    User findByName(String name); // Corrigido

    // Consulta para retornar usuário por email
    User findByEmail(String email);
}
