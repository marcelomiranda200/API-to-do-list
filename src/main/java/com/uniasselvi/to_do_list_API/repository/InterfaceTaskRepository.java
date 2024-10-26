package com.uniasselvi.to_do_list_API.repository;

import br.com.uniasselvi.to_do_list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceTaskRepository extends JpaRepository<Task, Long> {
    // Defina métodos de consulta personalizados aqui
    List<Task> findByStatus(Task.Status status);

    // Consulta para retornar tarefas por usuário
    List<Task> findByUserId(Long userId);

    // Consulta para retornar tarefas por título
    List<Task> findByTitleContaining(String title);

    // Consulta para retornar tarefas por descrição
    List<Task> findByDescriptionContaining(String description);

    // Consulta para retornar tarefas por status e usuário
    List<Task> findByStatusAndUserId(Task.Status status, int userId);
}
