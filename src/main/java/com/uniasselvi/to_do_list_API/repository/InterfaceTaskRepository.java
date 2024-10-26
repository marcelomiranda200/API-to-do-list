package com.uniasselvi.to_do_list_API.repository;

import com.uniasselvi.to_do_list_API.model.Task; // Corrigido
import com.uniasselvi.to_do_list_API.model.TaskStatus; // Corrigido
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceTaskRepository extends JpaRepository<Task, Long> {
    // Defina métodos de consulta personalizados aqui
    List<Task> findByStatus(TaskStatus status); // Corrigido

    // Consulta para retornar tarefas por usuário
    List<Task> findByUserId(Long userId);

    // Consulta para retornar tarefas por título
    List<Task> findByTitleContaining(String title);

    // Consulta para retornar tarefas por descrição
    List<Task> findByDescriptionContaining(String description);

    // Consulta para retornar tarefas por status e usuário
    List<Task> findByStatusAndUserId(TaskStatus status, Long userId); // Corrigido
}
