/*
 * Das linhas 7 a 12 temos os imports da Interface que define os métodos de acesso a dados para as tarefas.
 * Estende JpaRepository para herdar funcionalidades básicas de CRUD.
 * Importa os modelos Task e TaskStatus, bem como as anotações do Spring para repositórios e operações de banco de dados.
 * Inclui métodos para buscar tarefas por status, ID de usuário, título e descrição.
 */
package com.uniasselvi.to_do_list_API.repository;
import com.uniasselvi.to_do_list_API.model.Task;
import com.uniasselvi.to_do_list_API.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


/**
 Das linhas 40 em diante, temos a Interface que fornece métodos para acesso a dados relacionados a tarefas,
 * permitindo a busca por status, ID de usuário, título e descrição.
 * Herda funcionalidades do JpaRepository para operações de CRUD.
 */
@Repository
public interface InterfaceTaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    Optional<Task> findById(Long taskId);

    List<Task> findByUserId(Long userId);

    List<Task> findByTitleContaining(String title);

    List<Task> findByDescriptionContaining(String description);

    List<Task> findByStatusAndUserId(TaskStatus status, Long userId);
}
