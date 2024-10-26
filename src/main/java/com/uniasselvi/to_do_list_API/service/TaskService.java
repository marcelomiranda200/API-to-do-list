/**
 * Classe de serviço responsável pela lógica de negócios relacionada às tarefas.
 * Utiliza o InterfaceTaskRepository para realizar operações no banco de dados.
 * * Das linhas 11 a 17 temos as importações:
 *  * - Task: Modelo que representa as tarefas
 *  * - InterfaceTaskRepository: Interface para operações de acesso a dados das tarefas
 *  * - @Autowired: Facilita a injeção de dependência para que o Spring gerencie a instância do repositório.
 *  * - @Service: Anotação que marca a classe como um serviço Spring, permitindo a injeção em outros componentes.
 *  * - List e Optional: Estruturas de dados do Java utilizadas para gerenciar coleções e valores opcionais.
 */
package com.uniasselvi.to_do_list_API.service;
import com.uniasselvi.to_do_list_API.model.Task;
import com.uniasselvi.to_do_list_API.repository.InterfaceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
















/**
 * Esta classe fornece métodos para operações CRUD (Criar, Ler, Atualizar e Deletar) relacionadas aos usuários.
 * - das linhas 44 em diante, temos:
 * - findAllTasks: Retorna todas as tarefas cadastradas.
 * - getAllTasksByUserId: Retorna todas as tarefas por id de um unico usuário.
 * - findAllByUserId: Busca todas as tarefas de um usuário específico.
 * - createTask: Cria uma nova tarefa e retorna o objeto criado.
 * - updateTask: Atualiza os dados de uma tarefa existente pelo ID e retorna a tarefa atualizada, se encontrada.
 * - deleteTask: Deleta uma tarefa pelo ID especificado.
 */
@Service
public class TaskService {

    @Autowired
    private InterfaceTaskRepository taskRepository;


    public List <Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
