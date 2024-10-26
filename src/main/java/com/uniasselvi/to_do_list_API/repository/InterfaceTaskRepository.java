package com.uniasselvi.to_do_list_API.repository;

import com.uniasselvi.to_do_list_API.model.Task; // Importação do modelo Task
import com.uniasselvi.to_do_list_API.model.TaskStatus; // Importação do modelo TaskStatus
import org.springframework.data.jpa.repository.JpaRepository; // Importação do JpaRepository para operações de banco de dados
import org.springframework.stereotype.Repository; // Importação para indicar que é um repositório

import java.util.List; // Importação para trabalhar com listas

/**
 * Interface que define os métodos de acesso a dados para as tarefas.
 * Estende JpaRepository para herdar funcionalidades básicas de CRUD.
 */
@Repository
public interface InterfaceTaskRepository extends JpaRepository<Task, Long> {

    /**
     * Método para encontrar tarefas pelo status.
     *
     * @param status O status das tarefas a serem buscadas.
     * @return Uma lista de tarefas com o status especificado.
     */
    List<Task> findByStatus(TaskStatus status);

    /**
     * Método para encontrar tarefas de um usuário específico.
     *
     * @param userId O ID do usuário cujas tarefas devem ser buscadas.
     * @return Uma lista de tarefas associadas ao usuário.
     */
    List<Task> findByUserId(Long userId);

    /**
     * Método para buscar tarefas que contêm um título específico.
     *
     * @param title Parte do título das tarefas a serem buscadas.
     * @return Uma lista de tarefas cujos títulos contêm o texto especificado.
     */
    List<Task> findByTitleContaining(String title);

    /**
     * Método para buscar tarefas que contêm uma descrição específica.
     *
     * @param description Parte da descrição das tarefas a serem buscadas.
     * @return Uma lista de tarefas cujas descrições contêm o texto especificado.
     */
    List<Task> findByDescriptionContaining(String description);

    /**
     * Método para encontrar tarefas por status e ID do usuário.
     *
     * @param status O status das tarefas a serem buscadas.
     * @param userId O ID do usuário cujas tarefas devem ser buscadas.
     * @return Uma lista de tarefas que correspondem ao status e ao usuário.
     */
    List<Task> findByStatusAndUserId(TaskStatus status, Long userId);
}
