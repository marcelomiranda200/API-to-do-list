package com.uniasselvi.to_do_list_API.controller;

import com.uniasselvi.to_do_list_API.model.User; // Importa a classe User
import com.uniasselvi.to_do_list_API.service.UserService; // Importa a classe UserService
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência
import org.springframework.http.HttpStatus; // Importa os códigos de status HTTP
import org.springframework.http.ResponseEntity; // Importa a classe para a resposta HTTP
import org.springframework.web.bind.annotation.*; // Importa as anotações para construção de controladores REST

import java.util.List; // Importa a lista
import java.util.Optional; // Importa o Optional

/**
 * Controlador REST para gerenciar operações relacionadas a usuários.
 * Este controlador expõe endpoints para criar, ler, atualizar e excluir usuários.
 */
@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/users") // Define a rota base para os endpoints deste controlador
public class UserController {

    @Autowired // Injeção de dependência do serviço de usuários
    private UserService userService;

    /**
     * Obtém todos os usuários cadastrados.
     * @return Lista de usuários e o status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        // Chama o serviço para obter todos os usuários
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK); // Retorna a lista de usuários com status 200
    }

    /**
     * Obtém um usuário específico pelo ID.
     * @param id O ID do usuário a ser buscado.
     * @return O usuário correspondente ou um erro 404 (Não Encontrado) se não existir.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Chama o serviço para obter o usuário pelo ID
        Optional<User> user = userService.findUserById(id); // Corrigido para 'findUserById'
        return user.map(ResponseEntity::ok) // Se o usuário for encontrado, retorna 200 (OK)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se não encontrado, retorna 404 (Não Encontrado)
    }

    /**
     * Cria um novo usuário.
     * @param user O usuário a ser criado.
     * @return O usuário criado e o status HTTP 201 (Criado).
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Chama o serviço para salvar o novo usuário
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // Retorna o usuário criado com status 201
    }

    /**
     * Atualiza um usuário existente.
     * @param id O ID do usuário a ser atualizado.
     * @param user Os dados do usuário a serem atualizados.
     * @return O usuário atualizado ou um erro 404 (Não Encontrado) se não existir.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Chama o serviço para atualizar o usuário
        Optional<User> updatedUser = userService.updateUser(id, user);
        return updatedUser.map(ResponseEntity::ok) // Se o usuário for atualizado, retorna 200 (OK)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se não encontrado, retorna 404 (Não Encontrado)
    }

    /**
     * Exclui um usuário pelo ID.
     * @param id O ID do usuário a ser excluído.
     * @return Uma resposta vazia com status HTTP 204 (Sem Conteúdo).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Verifica se o usuário existe antes de tentar excluí-lo
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build(); // Se não existir, retorna 404 (Não Encontrado)
        }
        // Chama o serviço para excluir o usuário
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // Retorna resposta vazia com status 204
    }
}
