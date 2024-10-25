package br.com.uniasselvi.to_do_list.repository;

import br.com.uniasselvi.to_do_list.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Integer> {
    // Métodos de consulta adicionais

    // Consulta para retornar usuário por nome de usuário
    User findByUsername(String username);

    // Consulta para retornar usuário por email
    User findByEmail(String email);
}
