package com.uniasselvi.to_do_list_API.service;

import com.uniasselvi.to_do_list_API.model.Task; // Importação do modelo Task
import com.uniasselvi.to_do_list_API.repository.InterfaceTaskRepository; // Importação do repositório de tarefas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; // Importação para trabalhar com listas
import java.util.Optional; // Importação para trabalhar com valores opcionais

/**
 * Classe de serviço responsável pela lógica de negócios relacionada às tarefas.
 * Utiliza o InterfaceTaskRepository para realizar operações no banco de dados.
 */
@Service
public class TaskService {

    @Autowired
    private InterfaceTaskRepository taskRepository; // Injeção de dependência do repositório de tarefas

    /**
     * Método para buscar todas as tarefas de um usuário específico.
     *
     * @param userId O ID do usuário cujas tarefas devem ser buscadas.
     * @return Uma lista de tarefas associadas ao usuário.
     */
    public List<Task> findAllByUserId(Long userId) {
        return taskRepository.findByUserId(userId); // Retorna todas as tarefas do usuário
    }

    /**
     * Método para criar uma nova tarefa.
     *
     * @param task O objeto Task a ser criado.
     * @return A tarefa criada.
     */
    public Task createTask(Task task) {
        return taskRepository.save(task); // Salva e retorna a nova tarefa
    }

    /**
     * Método para atualizar uma tarefa existente.
     *
     * @param id O ID da tarefa a ser atualizada.
     * @param updatedTask O objeto Task com os novos dados.
     * @return Um Optional contendo a tarefa atualizada, se encontrada.
     */
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        // Verifica se a tarefa existe e atualiza seus dados
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle()); // Atualiza o título da tarefa
            task.setDescription(updatedTask.getDescription()); // Atualiza a descrição
            task.setStatus(updatedTask.getStatus()); // Atualiza o status
            return taskRepository.save(task); // Salva e retorna a tarefa atualizada
        });
    }

    /**
     * Método para deletar uma tarefa pelo ID.
     *
     * @param id O ID da tarefa a ser deletada.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id); // Deleta a tarefa com o ID especificado
    }
}
