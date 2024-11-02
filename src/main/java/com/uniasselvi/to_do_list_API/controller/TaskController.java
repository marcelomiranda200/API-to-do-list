/**
 Das linhas 14 a 22, temos os imports necessários para o funcionamento do controlador REST de tarefas.
 Esses incluem a classe `Task` e `TaskService`, essenciais para o modelo e serviço de negócio de tarefas,
 enquanto os demais imports são fornecidos automaticamente pelo Spring Boot para auxiliar em injeção de dependências,
 definição de respostas HTTP e uso de anotações para a construção de endpoints REST.

 Classes e funções principais importadas:
 - `Task` e `TaskService`: Modelagem e lógica de negócio para o gerenciamento de tarefas.
 - `@Autowired`: Facilita a injeção de dependência para que o Spring gerencie a instância do serviço `TaskService`.
 - `HttpStatus` e `ResponseEntity`: Utilizadas para estruturar e retornar as respostas HTTP com os códigos de status adequados.
 - `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.: Anotações que definem os métodos HTTP dos endpoints do controlador.
 - `List` e `Optional`: Estruturas de dados do Java utilizadas para gerenciar coleções e valores opcionais.
 **/
package com.uniasselvi.to_do_list_API.controller;
import com.uniasselvi.to_do_list_API.model.Task;
import com.uniasselvi.to_do_list_API.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;













/**
 Das linhas 51 em diante, temos o controlador REST para operações CRUD de tarefas.
 Define endpoints para criar, ler, atualizar e excluir tarefas, usando o serviço `TaskService`.

 Anotações principais:
 - `@RestController` e `@RequestMapping("/tasks")`: Indicam um controlador REST com rota base `/tasks`.
 - `@Autowired`: Injeta o serviço `TaskService` para acessar métodos de negócio.

 Métodos:
 - `getAllTasks`: Retorna todas as tarefas cadastradas (HTTP 200).
 -  getTaskById: Retorna as tarefas pelos IDs delas.
 - `getTaskById`: Retorna uma tarefa por ID ou 404 se não encontrada.
 -  getAllTasksByUserId: Retorna todas as tarefas por id de um unico usuário.
 - `createTask`: Cria uma nova tarefa e retorna com status 201.
 - `updateTask`: Atualiza dados de uma tarefa existente por ID ou retorna 404.
 - `deleteTask`: Exclui uma tarefa por ID e retorna status 204 se concluído com sucesso.
 **/@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite apenas essa origem
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id); // Corrigido método para usar camelCase
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getAllTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getAllTasksByUserId(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> updatedTask = taskService.updateTask(id, task);
        return updatedTask.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}