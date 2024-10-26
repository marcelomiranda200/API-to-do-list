/*
 * Das linhas 7 a 10 temos os imports da Interface que define os métodos de acesso a dados para os usuários.
 * Estende JpaRepository para herdar funcionalidades básicas de CRUD.
 * Importa o modelo User e as anotações do Spring para repositórios e operações de banco de dados.
 * Inclui métodos para buscar usuários pelo nome e pelo email.
 */
package com.uniasselvi.to_do_list_API.repository;
import com.uniasselvi.to_do_list_API.model.User; // Importação do modelo User
import org.springframework.data.jpa.repository.JpaRepository; // Importação do JpaRepository para operações de banco de dados
import org.springframework.stereotype.Repository; // Importação para indicar que é um repositório
























/**
 * Das linhas 40 em diante, temos a Interface que fornece métodos para acesso a dados relacionados a usuários,
 * permitindo a busca por nome e email.
 * Herda funcionalidades do JpaRepository para operações de CRUD.
 */
@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByEmail(String email);
}
