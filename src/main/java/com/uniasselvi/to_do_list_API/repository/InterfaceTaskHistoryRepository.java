package br.com.uniasselvi.to_do_list.repository;

import br.com.uniasselvi.to_do_list.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceTaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
    // Recupera o histórico de mudanças de status por ID da tarefa
    List<TaskHistory> findByTaskId(int taskId);

    // Recupera o histórico de mudanças de status por status da tarefa
    // Usar String diretamente para o status
    List<TaskHistory> findByStatus(String status);

    // Recupera o histórico de mudanças de status ordenado pela data de mudança (mais recente primeiro)
    List<TaskHistory> findByTaskIdOrderByChangedAtDesc(int taskId);

    // Recupera o histórico de mudanças de status por ID da tarefa e status
    List<TaskHistory> findByTaskIdAndStatus(int taskId, String status);
}
