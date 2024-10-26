package com.uniasselvi.to_do_list_API.service;

import com.uniasselvi.to_do_list_API.model.User; // Importação do modelo User
import com.uniasselvi.to_do_list_API.repository.InterfaceUserRepository; // Importação do repositório de usuários
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; // Importação para trabalhar com listas
import java.util.Optional; // Importação para trabalhar com valores opcionais

/**
 * Classe de serviço responsável pela lógica de negócios relacionada aos usuários.
 * Utiliza o InterfaceUserRepository para realizar operações no banco de dados.
 */
@Service
public class UserService {

    @Autowired
    private InterfaceUserRepository userRepository; // Injeção de dependência do repositório de usuários

    /**
     * Método para buscar todos os usuários.
     *
     * @return uma lista de todos os usuários cadastrados.
     */
    public List<User> findAllUsers() {
        return userRepository.findAll(); // Retorna todos os usuários
    }

    /**
     * Método para criar um novo usuário.
     *
     * @param user O objeto User a ser criado.
     * @return O usuário criado.
     */
    public User createUser(User user) {
        return userRepository.save(user); // Salva e retorna o usuário criado
    }

    /**
     * Método para atualizar um usuário existente.
     *
     * @param id O ID do usuário a ser atualizado.
     * @param updatedUser O objeto User com os novos dados.
     * @return Um Optional contendo o usuário atualizado, se encontrado.
     */
    public Optional<User> updateUser(Long id, User updatedUser) {
        // Verifica se o usuário existe e atualiza seus dados
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName()); // Atualiza o nome
            user.setEmail(updatedUser.getEmail()); // Atualiza o email
            user.setPassword(updatedUser.getPassword()); // Atualiza a senha
            return userRepository.save(user); // Salva e retorna o usuário atualizado
        });
    }

    /**
     * Método para deletar um usuário pelo ID.
     *
     * @param id O ID do usuário a ser deletado.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // Deleta o usuário com o ID especificado
    }

    /**
     * Método para verificar se um usuário existe pelo ID.
     *
     * @param id O ID do usuário.
     * @return true se o usuário existir, false caso contrário.
     */
    public boolean existsById(Long id) {
        return userRepository.existsById(id); // Retorna true se o usuário existir
    }

    /**
     * Método para buscar um usuário pelo ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return Um Optional contendo o usuário encontrado, se existir.
     */
    public Optional<User> findUserById(Long id) {
        // Busca o usuário no repositório pelo ID e retorna um Optional
        return userRepository.findById(id);
    }
}
