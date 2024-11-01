/**
Das linhas 14 a 22, temos os imports necessários para o funcionamento do controlador REST de usuários.
Esses incluem a classe `User` e `UserService`, essenciais para o modelo e serviço de negócio de usuários,
enquanto os demais imports são fornecidos automaticamente pelo Spring Boot para auxiliar em injeção de dependências,
definição de respostas HTTP e uso de anotações para a construção de endpoints REST.

Classes e funções principais importadas:
- `User` e `UserService`: Modelagem e lógica de negócio para o gerenciamento de usuários.
- `@Autowired`: Facilita a injeção de dependência para que o Spring gerencie a instância do serviço `UserService`.
- `HttpStatus` e `ResponseEntity`: Utilizadas para estruturar e retornar as respostas HTTP com os códigos de status adequados.
- `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.: Anotações que definem os métodos HTTP dos endpoints do controlador.
- `List` e `Optional`: Estruturas de dados do Java utilizadas para gerenciar coleções e valores opcionais.
**/
package com.uniasselvi.to_do_list_API.controller;
import com.uniasselvi.to_do_list_API.model.User;
import com.uniasselvi.to_do_list_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;












/**
Das linhas 51 em diante, temos o controlador REST para operações CRUD de usuários.
Define endpoints para criar, ler, atualizar e excluir usuários, usando o serviço `UserService`.

Anotações principais:
- `@RestController` e `@RequestMapping("/users")`: Indicam um controlador REST com rota base `/users`.
- `@Autowired`: Injeta o serviço `UserService` para acessar métodos de negócio.

Métodos:
- `getAllUsers`: Retorna todos os usuários cadastrados (HTTP 200).
- `getUserById`: Retorna um usuário por ID ou 404 se não encontrado.
- `createUser`: Cria um novo usuário e retorna com status 201.
- `updateUser`: Atualiza dados de um usuário existente por ID ou retorna 404.
- `deleteUser`: Exclui um usuário por ID e retorna status 204 se concluído com sucesso.
**/
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite apenas essa origem
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> updatedUser = userService.updateUser(id, user);
        return updatedUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
