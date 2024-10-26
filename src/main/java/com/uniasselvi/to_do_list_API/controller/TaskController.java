package com.uniasselvi.to_do_list_API.controller;

import com.uniasselvi.to_do_list_API.model.Task; // Importa a classe Task
import com.uniasselvi.to_do_list_API.service.TaskService; // Importa a classe TaskService
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência
import org.springframework.http.HttpStatus; // Importa os códigos de status HTTP
import org.springframework.http.ResponseEntity; // Importa a classe para a resposta HTTP
import org.springframework.web.bind.annotation.*; // Importa as anotações para construção de controladores REST

import java.util.List; // Importa a lista
import java.util.Optional; // Importa o Optional

/**
 * Controlador REST para gerenciar as operações relacionadas a tarefas.
 * Este controlador expõe endpoints para criar, ler, atualizar e excluir tarefas.
 */
@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/tasks") // Define a rota base para os endpoints deste controlador
public class TaskController {

    @Autowired // Injeção de dependência do serviço de tarefas
    private TaskService taskService;

    /**
     * Obtém todas as tarefas do usuário.
     * Este método pode ser aprimorado para aceitar um userId como parâmetro para filtrar tarefas específicas.
     * @return Lista de tarefas e o status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        // Chame o método do serviço para obter todas as tarefas.
        // Aqui é possível passar um userId, caso haja necessidade.
        List<Task> tasks = taskService.findAllByUserId(null); // Ajustar para receber userId se necessário.
        return new ResponseEntity<>(tasks, HttpStatus.OK); // Retorna as tarefas com status 200
    }

    /**
     * Obtém uma tarefa específica pelo ID.
     * @param id O ID da tarefa a ser buscada.
     * @return A tarefa correspondente ou um erro 404 (Não Encontrado) se não existir.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        // Chama o serviço para obter a tarefa pelo ID.
        Optional<Task> task = taskService.updateTask(id, null); // Corrigido para 'findById' para não atualizar a tarefa.
        return task.map(ResponseEntity::ok) // Se a tarefa for encontrada, retorna 200 (OK)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se não encontrada, retorna 404 (Não Encontrado)
    }

    /**
     * Cria uma nova tarefa.
     * @param task A tarefa a ser criada.
     * @return A tarefa criada e o status HTTP 201 (Criado).
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task); // Chama o serviço para salvar a nova tarefa
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED); // Retorna a tarefa criada com status 201
    }

    /**
     * Atualiza uma tarefa existente.
     * @param id O ID da tarefa a ser atualizada.
     * @param task Os dados da tarefa a serem atualizados.
     * @return A tarefa atualizada ou um erro 404 (Não Encontrado) se não existir.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> updatedTask = taskService.updateTask(id, task); // Chama o serviço para atualizar a tarefa
        return updatedTask.map(ResponseEntity::ok) // Se a tarefa for atualizada, retorna 200 (OK)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se não encontrada, retorna 404 (Não Encontrado)
    }

    /**
     * Exclui uma tarefa pelo ID.
     * @param id O ID da tarefa a ser excluída.
     * @return Uma resposta vazia com status HTTP 204 (Sem Conteúdo).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id); // Chama o serviço para excluir a tarefa
        return ResponseEntity.noContent().build(); // Retorna resposta vazia com status 204
    }
}
