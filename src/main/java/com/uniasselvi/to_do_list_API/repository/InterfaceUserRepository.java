package com.uniasselvi.to_do_list_API.repository;

import com.uniasselvi.to_do_list_API.model.User; // Importação do modelo User
import org.springframework.data.jpa.repository.JpaRepository; // Importação do JpaRepository para operações de banco de dados
import org.springframework.stereotype.Repository; // Importação para indicar que é um repositório

/**
 * Interface que define os métodos de acesso a dados para os usuários.
 * Estende JpaRepository para herdar funcionalidades básicas de CRUD.
 */
@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Long> {

    /**
     * Método para buscar um usuário pelo nome.
     *
     * @param name O nome do usuário a ser buscado.
     * @return O objeto User correspondente ao nome fornecido, ou null se não encontrado.
     */
    User findByName(String name); // Método para buscar usuário pelo nome

    /**
     * Método para buscar um usuário pelo email.
     *
     * @param email O email do usuário a ser buscado.
     * @return O objeto User correspondente ao email fornecido, ou null se não encontrado.
     */
    User findByEmail(String email); // Método para buscar usuário pelo email
}
